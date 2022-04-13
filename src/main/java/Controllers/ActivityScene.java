package Controllers;

import io.cucumber.java.en_old.Ac;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import system.app.Activity;
import system.app.PMA;
import system.app.Project;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ActivityScene implements Initializable {

    private static Project project;
    public String[] myActivityNames;
    public Label project_name;
    public TitledPane Activity_box_name;
    public Label employee_name;
    public Label start_time;
    public Label end_time;
    public static PMA pma;
    public static String projectname;
    public TextField employye_add;
    public TextField start_time_add;
    public TextField end_time_add;
    public Button Done_button;
    public TextField name_activity_add;


    public static void initActivityScene(PMA pma, String projectname) {
        ActivityScene.pma = pma;
        ActivityScene.projectname = projectname;
    }



    public ActivityScene() {
        ActivityScene.project = ActivityScene.pma.getProject(projectname);

        myActivityNames = new String[ActivityScene.project.activities.size()];
        int i = 0;
        for(Activity activity: ActivityScene.project.activities) {
            myActivityNames[i] = activity.getName();
            i++;
        }


    }


    @FXML
    private ListView<String> list_activity;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Initialiser Projectname
        project_name.setText("ProjectName: " + ActivityScene.project.name);

        //starter med at gøre activitybox empty
        Activity_box_name.setVisible(false);

        //gør de tre bokse og knap usynlige til at starte med
        employye_add.setVisible(false);
        start_time_add.setVisible(false);
        end_time_add.setVisible(false);
        Done_button.setVisible(false);
        name_activity_add.setVisible(false);


        //Initialiser viewList
        ObservableList<String> myProjects = FXCollections.observableArrayList(myActivityNames);
        list_activity.setItems(myProjects);
        list_activity.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }

    public void initActivity_box_name() {
        //set boksens navn og gør den synlig
        String activityName = list_activity.getSelectionModel().getSelectedItems().get(0);
        Activity_box_name.setText(activityName);
        Activity_box_name.setVisible(true);

        //initialiser for employee, start_time og slut_time
        if(!project.getActivity(activityName).isActivityStaffed()) {
            employee_name.setText("Employee: None");
        } else {
            employee_name.setText("Employee: " + project.getActivity(activityName).getEmployeeId());
        }

        if(project.getActivity(activityName).startTime == 0) {
            start_time.setText("Starttime: None");
        } else {
            start_time.setText("Starttime: " + project.getActivity(activityName).startTime);
        }

        if(project.getActivity(activityName).endTime == 0) {
            end_time.setText("Starttime: None");
        } else {
            end_time.setText("Starttime: " + project.getActivity(activityName).endTime);
        }

    }


    public void show_button_action(ActionEvent event) {
        initActivity_box_name();

    }


    //metoden for når man trykker på tilbage button
    public void back_action(ActionEvent event) throws IOException {
        systemScene.setPma(pma);
        URL url = new File("src/test/resources/fxml/systemScene.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void Add_activity_action(ActionEvent event) {
        employye_add.setVisible(true);
        start_time_add.setVisible(true);
        end_time_add.setVisible(true);
        Done_button.setVisible(true);
        name_activity_add.setVisible(true);
    }


    public Activity createActivty() {
        String nameActivity = name_activity_add.getText();
        String startTime = start_time_add.getText();
        String endTime = end_time_add.getText();
        String employeeId = employye_add.getText();

        Activity activity = new Activity(nameActivity);
        activity.editTimeSchedule(Integer.parseInt(startTime), Integer.parseInt(endTime));

        //vi skal lige finde ud af hvordan man tilføjer en employee-objekt
        return activity;

    }

    public void Done_action(ActionEvent event) {

        pma.getProject(ActivityScene.projectname).addActivity(createActivty());
        ActivityScene.project = ActivityScene.pma.getProject(projectname);


        //fjerner tekst fra boksene
        name_activity_add.clear();
        end_time_add.clear();
        start_time_add.clear();
        employye_add.clear();



        myActivityNames = new String[ActivityScene.project.activities.size()];
        int i = 0;
        for(Activity activity: ActivityScene.project.activities) {
            myActivityNames[i] = activity.getName();
            i++;
        }

        ObservableList<String> myProjects = FXCollections.observableArrayList(myActivityNames);
        list_activity.setItems(myProjects);
        list_activity.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


    }
}
