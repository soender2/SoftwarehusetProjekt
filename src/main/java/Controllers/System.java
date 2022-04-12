package Controllers;

import system.app.PMA;

public class System {

    public static String initials;

    PMA pma;




    public System() {
        pma = new PMA();




    }

    public static void setInitials(String initials) {
        System.initials = initials;
    }
}
