package WhiteBoxTest1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {
	ArrayList<String> arrNames, arrAnswers;
	File myFile;
	Scanner myReader;
	int amountOfTests = 98;
	int correctAnswers = 0;
	
	Test2() throws FileNotFoundException{
		
		//Initializing variables
		arrNames = new ArrayList<String>();
		arrAnswers = new ArrayList<String>();
		myFile = new File("src/test/java/WhiteBoxTest1/Testcase2.txt");
		myReader = new Scanner(myFile);
		
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
		} System.out.println("Test case 2: Amount of correct cases: " + correctAnswers + "/" + amountOfTests);
	}
	
	public String login(String initials) {
        if (initials.length() <=4 && initials.matches("^[a-zA-Z]*$") && arrNames.contains(initials) == true){
            return "Yes";
        } else return "No";
    }
}
