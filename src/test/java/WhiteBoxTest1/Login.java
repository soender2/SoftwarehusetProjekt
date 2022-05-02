package WhiteBoxTest1;

import java.util.ArrayList;

public class Login {
	public static ArrayList<String> arrNames = new ArrayList<String>();
	
	public void login(String initials) {

        if (initials.length() <=4 && initials.matches("^[a-zA-Z]*$") && arrNames.contains(initials) == true){
            System.out.println("Yes");
        } else System.out.println("No");
    }
}
