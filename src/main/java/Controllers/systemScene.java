package Controllers;

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
import javafx.scene.input.MouseEvent;
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
    public Button availableEmployees;
    public ListView<String> listAvailableEmployees;
    private ListView<String> myListProject;


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


    /*
    public void showProjectActivities(ActionEvent event) {
        ObservableList<String> projects;
        projects = list_project.getSelectionModel().getSelectedItems();
        for(String Project : projects){
            list_activity.setVisible(true);
            if(activityString.getText().trim().isEmpty()) {
                activityString.setText("Aktivities for " + Project + ":");
                activityString.setVisible(true);
            } else {
                activityString.setText("Aktivities for " + Project + ":");
                activityString.setVisible(true);
            }
        }

    }
    */

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
        myProjectScene.initMyProjectScene(pma, myProjectScene.projectname, myProjectScene.employeeId);
        URL url1 = new File("src/test/resources/fxml/myProjectScene.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void showAvailableEmployees(ActionEvent event) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                String[] availableEmployees = pma.getAvailableEmployees();
                ObservableList<String> employees = FXCollections.observableArrayList(availableEmployees);
                listAvailableEmployees.setItems(employees);
                listAvailableEmployees.setVisible(true);
            }
        });
    }

}
