package Controllers;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import system.app.PMA;

import java.awt.event.ActionEvent;
import java.io.IOException;


public class systemScene {

    public static String initials;
    public Label user_label;
    public Button showInit;
    PMA pma;

    public void Show_initials(javafx.event.ActionEvent actionEvent) {
        showInit.setVisible(false);
       this.user_label.setText("User initials: " + initials);
    }




    public systemScene() {
        pma = new PMA();



    }

    public static void setInitials(String initials) {
        systemScene.initials = initials;
    }

}
