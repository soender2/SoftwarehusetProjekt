package WhiteBoxTest.Test4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test2{
	ArrayList<Employee> employees, availableEmployees;
	ArrayList<String> arrAnswers;
	File myFile = new File("src/test/java/WhiteBoxTest/Test4/Testcase2.txt");
	Scanner myReader = new Scanner(myFile);
	int sizeOfAvaibleEmployees = 6;
	int amountOfTests = 1;
	int correctAnswers = 0;
	
	Test2() throws FileNotFoundException, Exception{
		
		//Initializing variables
		availableEmployees = new ArrayList<Employee>();
		employees = new ArrayList<Employee>();
		
		arrAnswers = new ArrayList<String>();
		
		//Preparing scanner for file input
		myReader.nextLine();
		
		//Getting file inputs into both arrays
		while(myReader.hasNextLine()) {
			employees.add(new Employee(myReader.next(),myReader.nextInt()));
			arrAnswers.add(myReader.next());
		}
		
		availableEmployees = availableEmployees();
		
		//Running tests
		for(int i = 0; i < amountOfTests; i++) {
			if(availableEmployees.size() == sizeOfAvaibleEmployees) correctAnswers++;
		} System.out.println("Test case 2: Amount of correct cases: " + correctAnswers + "/" + amountOfTests);
	}
	
	public ArrayList<Employee> availableEmployees() throws Exception {
        ArrayList<Employee> availableEmployees = new ArrayList<Employee>();
        for(Employee employee : employees) {
            if(employee.EmployeeAvailable()){
                availableEmployees.add(employee);
            }
        }
        
        if(availableEmployees.isEmpty()) {
        	throw new Exception("No available employees");
        } else return availableEmployees;
    }
}
