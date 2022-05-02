package WhiteBoxTest2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test1 {
	ArrayList<String> arrAnswers, arrNames;
	ArrayList<Project> projects;
	File myFile;
	Scanner myReader;
	int amountOfTests = 20;
	int correctAnswers = 0;
	
	Test1() throws FileNotFoundException{
		
		//Initializing variables
		arrNames = new ArrayList<String>();
		arrAnswers = new ArrayList<String>();
		projects = new ArrayList<Project>();
		myFile = new File("src/test/java/WhiteBoxTest2/Testcase1.txt");
		myReader = new Scanner(myFile);
		
		//Preparing scanner for file input
		myReader.nextLine();
		
		//Getting file inputs into both arrays
		while(myReader.hasNextLine()) {
			if(myReader.hasNext("add")) {
				myReader.next(); // Jump over add in file
				String projectName = myReader.next();
				projects.add(new Project(projectName));
				arrNames.add(projectName);
				arrAnswers.add(myReader.next());
			} else {
				arrNames.add(myReader.next());
				arrAnswers.add(myReader.next());
			}
		}
		
		
		//Running tests
		for(int i = 0; i < amountOfTests; i++) {
			if (existProjectName(arrNames.get(i)).equals(arrAnswers.get(i))) {
				correctAnswers++;
			} else System.out.println("Test case " + (i+1) + " failed");
		} System.out.println("Test case 1: Amount of correct cases: " + correctAnswers + "/" + amountOfTests);
	}
	
	public String existProjectName(String projectname) {
        for (Project project : projects) {
            if (project.name.equals(projectname)) {
                return "Yes";
            }
        } return "No";
    }
}
