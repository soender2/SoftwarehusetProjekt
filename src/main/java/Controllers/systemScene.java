package Controllers;

import Exceptions.IllegalInputException;
import javafx.application.Platform;
import javafx.beans.Observable;
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
import system.app.Employee;
import system.app.PMA;
import system.app.Project;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;


public class systemScene implements Initializable {

    public ListView<String> list_activity;
    public Label activityString;
    public Button projectActivities;
    public Button add_Employee;
    public TextField add_Employee_holder;
    private ListView<String> myListProject;
    private Alert errorAlert = new Alert(Alert.AlertType.ERROR);


    public static String initials;
    public Label user_label;
    public Button showInit;
    public static PMA pma;
    public String[] myProjectsName;
    public String[] myActivityName;
    public String[] myActivityName1;




    public static void setPma(PMA pma) {
        systemScene.pma = pma;
    }




    public systemScene() {
        if(systemScene.pma != null) {
            showName();
        }
    }

    public void showName(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                user_label.setText("User: " + MainScene.name);
            }
        });
    }

    public static void setInitials(String initials) {
        systemScene.initials = initials;
    }


    @FXML private ListView<String> list_project;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myProjectsName = new String[pma.projects.size()];
        int i = 0;
        for(Project project: systemScene.pma.projects) {
            myProjectsName[i] = project.name;
            i++;
        }
        ObservableList<String> myProjects = FXCollections.observableArrayList(myProjectsName);
        list_project.setItems(myProjects);
        list_project.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


        myActivityName = new String[pma.getProject("project0").activities.size()];
        myActivityName1 = new String[pma.getProject("project1").activities.size()];


    }


    public void showProjectActivities(ActionEvent event) throws IOException {
        String projects = list_project.getSelectionModel().getSelectedItems().get(0);
        ActivityScene.initActivityScene(pma, projects);
        URL url = new File("src/test/resources/fxml/ActivityScene.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void showMyProjects(ActionEvent event) throws IOException {
        myProjectScene.initMyProjectScene(systemScene.pma, systemScene.initials);
        URL url1 = new File("src/test/resources/fxml/myProjectScene.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void add_Employee(ActionEvent actionEvent) throws IllegalInputException {

        if (add_Employee_holder.getText().length() == 4 && add_Employee_holder.getText().matches("^[a-zA-Z]*$")){
            Employee employee = new Employee(add_Employee_holder.getText());
            pma.addEmployee(employee);
            add_Employee_holder.clear();

        } else if (!(add_Employee_holder.getText().length() <=4)){
            errorAlert.setContentText("Illegal input. Input Must be initials of four letters or less");
            errorAlert.showAndWait();
            throw new IllegalInputException("Illegal input. Input Must be initials of four letters or less");

        } else if (!(add_Employee_holder.getText().matches("^[a-zA-Z]*$"))){
            errorAlert.setContentText("Illegal character input. Must be alphabetic letters");
            errorAlert.showAndWait();
            throw new IllegalInputException("Illegal character input. Must be alphabetic letters");

        } else if(add_Employee_holder.getText().isEmpty()) {
            errorAlert.setContentText("Field is Empty");
            errorAlert.showAndWait();
            throw new IllegalInputException("Field is Empty");

        } else {
            errorAlert.setContentText("Illegal input. User does not exist");
            errorAlert.showAndWait();
            throw new IllegalInputException("Illegal input. User does not exist");
        }

    }
}
