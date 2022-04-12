package Controllers;

import javafx.scene.control.Label;
import system.app.PMA;


public class systemScene {

    public static String initials;
    public Label user_label;

    PMA pma;

    public void initSystem(){
        this.user_label.setText("User initials: " + initials);
    }




    public systemScene() {
        pma = new PMA();



    }

    public static void setInitials(String initials) {
        systemScene.initials = initials;
    }
}
