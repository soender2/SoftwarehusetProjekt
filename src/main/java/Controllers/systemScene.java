package Controllers;

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
import java.util.ResourceBundle;


public class systemScene {

    private ListView<String> myListProject;


    public static String initials;
    public Label user_label;
    public Button showInit;
    PMA pma;
    String[] myProjectsName;

    public void Show_initials(javafx.event.ActionEvent actionEvent) {
        showInit.setVisible(false);
       this.user_label.setText("User initials: " + initials);
        myListProject.getItems().addAll(myProjectsName);
        myListProject.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }


    public systemScene() {
        this.pma = new PMA();
        myListProject = new ListView<>();
        Project project1 = new Project("project1");
        Project project2 = new Project("project2");
        this.pma.addProject(project1);
        this.pma.addProject(project2);
        Employee employee1 = new Employee("old");
        Employee employee2 = new Employee("mol");
        this.pma.addEmployee(employee1);
        this.pma.addEmployee(employee2);
        myProjectsName = new String[pma.projects.size()];
        projectsNames();

    }


    public void projectsNames() {
        int i = 0;
        for(Project project: this.pma.projects) {
            myProjectsName[i] = project.name;
            i++;

        }
    }

    public static void setInitials(String initials) {
        systemScene.initials = initials;
    }
}
