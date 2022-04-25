package WhiteBoxTest.Test3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test1 {
	ArrayList<String> arrAnswers;
	ArrayList<Project> arrProjects;
	File myFile = new File("src/test/java/WhiteBoxTest/Test3/Testcase1.txt");
	Scanner myReader = new Scanner(myFile);
	int amountOfTests = 10;
	int correctAnswers = 0;
	
	Test1() throws FileNotFoundException{
		
		//Initializing variables
		arrAnswers = new ArrayList<String>();
		arrProjects = new ArrayList<Project>();
		
		//Preparing scanner for file input
		myReader.nextLine();
		
		//Getting file inputs into both arrays
		while(myReader.hasNextLine()) {
			if(myReader.hasNext("null")) {
				arrProjects.add(new Project(null));
				arrAnswers.add("No");
				myReader.nextLine();
;			} else {
				arrProjects.add(new Project(new Employee()));
				arrAnswers.add("Yes");
				myReader.nextLine();
			}
		}
		
		//Running tests
		for(int i = 0; i < amountOfTests; i++) {
			if (arrProjects.get(i).isProjectManager().equals(arrAnswers.get(i))) {
				correctAnswers++;
			} else System.out.println("Test case " + (i+1) + " failed");
		} System.out.println("Test case 1: Amount of correct cases: " + correctAnswers + "/" + amountOfTests);
	}
}
