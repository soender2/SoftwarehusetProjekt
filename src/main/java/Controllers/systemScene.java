package Controllers;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import system.app.Employee;
import system.app.PMA;
import system.app.Project;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;


public class systemScene implements Initializable {

    private ListView<String> myListProject;


    public static String initials;
    public Label user_label;
    public Button showInit;
    PMA pma;
    String[] myProjectsName;
    String userProjects;

    public void Show_initials(javafx.event.ActionEvent actionEvent) {
        showInit.setVisible(false);
        this.user_label.setText("User initials: " + initials);
    }


    public systemScene() {
        this.pma = new PMA();
        Project project1 = new Project("project1");
        Project project2 = new Project("project2");
        this.pma.addProject(project1);
        this.pma.addProject(project2);
        Employee employee1 = new Employee("old");
        Employee employee2 = new Employee("mol");
        this.pma.addEmployee(employee1);
        this.pma.addEmployee(employee2);

        myProjectsName = new String[pma.projects.size()];
        int i = 0;
        for(Project project: this.pma.projects) {
            myProjectsName[i] = project.name;
            i++;
        }
        System.out.println(Arrays.toString(myProjectsName));

    }

    public static void setInitials(String initials) {
        systemScene.initials = initials;
    }



    @FXML private ListView<String> list_project;
    ObservableList<String> myProjects = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        list_project.setItems(myProjects);
    }
}
