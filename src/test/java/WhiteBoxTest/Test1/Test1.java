package WhiteBoxTest.Test1;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Test1{
	ArrayList<String> arrNames, arrAnswers;
	File myFile = new File("src/test/java/WhiteBoxTest/Test1/Testcase1.txt");
	Scanner myReader = new Scanner(myFile);
	int amountOfTests = 8;
	int correctAnswers = 0;
	
	Test1() throws FileNotFoundException{
		
		//Initializing variables
		arrNames = new ArrayList<String>();
		arrAnswers = new ArrayList<String>();
		
		//Preparing scanner for file input
		myReader.nextLine();
		
		//Getting file inputs into both arrays
		while(myReader.hasNextLine()) {
			arrNames.add(myReader.next());
			arrAnswers.add(myReader.next());
		}
		
		//Running tests
		for(int i = 0; i < amountOfTests; i++) {
			if (login(arrNames.get(i)).equals(arrAnswers.get(i))) {
				correctAnswers++;
			} else System.out.println("Test case " + (i+1) + " failed");
		} System.out.println("Test case 1: Amount of correct cases: " + correctAnswers + "/" + amountOfTests);
	}
	
	public String login(String initials) {
        if (initials.length() <=4 && initials.matches("^[a-zA-Z]*$") && arrNames.contains(initials) == true){
            return "Yes";
        } else return "No";
    }
}
