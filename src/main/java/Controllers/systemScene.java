package Controllers;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
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
    private ListView<String> myListProject;


    public static String initials;
    public Label user_label;
    public Button showInit;
    PMA pma;
    public String[] myProjectsName;
    public String[] myActivityName;
    public String[] myActivityName1;


    public void Show_initials(javafx.event.ActionEvent actionEvent) {
        showInit.setVisible(false);
        this.user_label.setText("User initials: " + initials);
    }


    public systemScene() {
        this.pma = new PMA();

        Project project0 = new Project("project0");
        Project project1 = new Project("project1");
        this.pma.addProject(project0);
        this.pma.addProject(project1);
        Employee employee0 = new Employee("old");
        Employee employee1 = new Employee("mol");
        this.pma.addEmployee(employee0);
        this.pma.addEmployee(employee1);
        Activity activity0 = new Activity("Make Cards");
        Activity activity1 = new Activity("Make Diagrams");
        this.pma.getProject("project0").addActivity(activity0);
        this.pma.getProject("project1").addActivity(activity1);
    }

    public static void setInitials(String initials) {
        systemScene.initials = initials;
    }


    @FXML private ListView<String> list_project;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myProjectsName = new String[pma.projects.size()];
        int i = 0;
        for(Project project: this.pma.projects) {
            myProjectsName[i] = project.name;
            i++;
        }
        ObservableList<String> myProjects = FXCollections.observableArrayList(myProjectsName);
        list_project.setItems(myProjects);
        list_project.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


        myActivityName = new String[pma.getProject("project0").activities.size()];
        myActivityName1 = new String[pma.getProject("project1").activities.size()];


    }



    public void showProjectActivities(ActionEvent event) {
        ObservableList<String> projects;
        projects = list_project.getSelectionModel().getSelectedItems();
        for(String Project : projects){
            list_activity.setVisible(true);
            if(activityString.getText().trim().isEmpty()) {
                activityString.setText("Aktivities for " + Project + ":");
                activityString.setVisible(true);

            } else {
                activityString.setText("");
                activityString.setText("Aktivities for " + Project + ":");
                activityString.setVisible(true);
            }
        }

    }
}
