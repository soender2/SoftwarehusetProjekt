package Controllers;

import javafx.application.Platform;
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

public class myActivityScene implements Initializable {
    private static Project project;
    public Label user_label;
    public String[] myActivityNames;
    public Label project_name;
    public Label employee_name;
    public Label start_time;
    public Label end_time;
    public static PMA pma;
    public static String projectname;
    public static String employeeId;
    public TitledPane myActivity_box_name;


    public static void myInitActivityScene(PMA pma, String projectname, String employeeId) {
        myActivityScene.pma = pma;
        myActivityScene.projectname = projectname;
        myActivityScene.employeeId = employeeId;
    }


    public void showName(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                user_label.setText("User: " + MainScene.name);
            }
        });
    }


    public myActivityScene() {
        myActivityScene.project = myActivityScene.pma.getProject(projectname);

        myActivityNames = new String[myActivityScene.project.activities.size()];
        int i = 0;
        for(Activity activity: myActivityScene.project.activities) {
            myActivityNames[i] = activity.getName();
            i++;
        }


    }


    @FXML
    private ListView<String> list_myactivity;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Initialiser Projectname
        project_name.setText("ProjectName: " + myActivityScene.project.name);

        //starter med at gøre activitybox empty
        myActivity_box_name.setVisible(false);

        showName();
        //Initialiser viewList
        ObservableList<String> myProjects = FXCollections.observableArrayList(myActivityNames);
        list_myactivity.setItems(myProjects);
        list_myactivity.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }

    public void initActivity_box_name() {
        //set boksens navn og gør den synlig
        String myActivityName = list_myactivity.getSelectionModel().getSelectedItems().get(0);
        myActivity_box_name.setText(myActivityName);
        myActivity_box_name.setVisible(true);

        //initialiser for employee, start_time og slut_time
        if(!project.getActivity(myActivityName).isActivityStaffed()) {
            employee_name.setText("Employee: None");
        } else {
            employee_name.setText("Employee: " + project.getActivity(myActivityName).getEmployeeId());
        }

        if(project.getActivity(myActivityName).startTime == 0) {
            start_time.setText("Starttime: None");
        } else {
            start_time.setText("Starttime: " + project.getActivity(myActivityName).startTime);
        }

        if(project.getActivity(myActivityName).endTime == 0) {
            end_time.setText("Starttime: None");
        } else {
            end_time.setText("Starttime: " + project.getActivity(myActivityName).endTime);
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


}
