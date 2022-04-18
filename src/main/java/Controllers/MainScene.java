package Controllers;

import Exceptions.IllegalInputException;
import io.cucumber.datatable.internal.difflib.StringUtills;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import system.app.Activity;
import system.app.Employee;
import system.app.PMA;
import system.app.Project;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainScene  {
    public static String name;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Alert errorAlert = new Alert(Alert.AlertType.ERROR);
    public PMA pma;

    @FXML
    public TextField Initials_holder;
    public Button loginbutton;
    String user_initials;


    public void goToSystem(ActionEvent event) throws IOException, IllegalInputException {
        initEmployees();
        URL url = new File("src/test/resources/fxml/systemScene.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        name = Initials_holder.getText();
        login();
    }

    public void login() throws IOException, IllegalInputException {

        if (Initials_holder.getText().length() <=4 && Initials_holder.getText().matches("^[a-zA-Z]*$") && pma.getEmployee(name) != null ){
            stage.setScene(scene);
            initSystem();
            stage.show();
        }  else if (!(Initials_holder.getText().length() <=4)){
            errorAlert.setContentText("Illegal input. Input Must be initials of four letters or less");
            errorAlert.showAndWait();
            throw new IllegalInputException("Illegal input. Input Must be initials of four letters or less");

        } else if (!(Initials_holder.getText().matches("^[a-zA-Z]*$"))){
            errorAlert.setContentText("Illegal character input. Must be alphabetic letters");
            errorAlert.showAndWait();
            throw new IllegalInputException("Illegal character input. Must be alphabetic letters");

        } else {
            errorAlert.setContentText("Illegal input. User does not exist");
            errorAlert.showAndWait();
            throw new IllegalInputException("Illegal input. User does not exist");
        }
    }

    public void initSystem() {
        String user_initials = Initials_holder.getText();
        systemScene.setInitials(user_initials);
    }

    public void initEmployees(){
        pma = new PMA();
        Project project0 = new Project("project0");
        Project project1 = new Project("project1");
        pma.addProject(project0);
        pma.addProject(project1);
        Employee employee0 = new Employee("Øl");
        Employee employee1 = new Employee("er");
        Employee employee2 = new Employee("godt");
        pma.addEmployee(employee0);
        pma.addEmployee(employee1);
        pma.addEmployee(employee2);
        Activity activity0 = new Activity("Make Cards");
        Activity activity1 = new Activity("Make Diagrams");
        activity0.assignEmployeeActivities(employee0);
        activity1.assignEmployeeActivities(employee1);
        activity0.editTimeSchedule(50, 200);
        pma.getProject("project0").addActivity(activity0);
        pma.getProject("project0").addActivity(activity1);
        pma.getProject("project1").addActivity(activity1);
        systemScene.setPma(pma);
    }

}

