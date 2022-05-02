package WhiteBoxTest4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test1{
	ArrayList<Employee> employees;
	ArrayList<String> arrAnswers;
	File myFile = new File("src/test/java/WhiteBoxTest4/Testcase1.txt");
	Scanner myReader = new Scanner(myFile);
	int amountOfTests = 12;
	int correctAnswers = 0;
	
	Test1() throws FileNotFoundException{
		
		//Initializing variables
		employees = new ArrayList<Employee>();
		arrAnswers = new ArrayList<String>();
		
		//Preparing scanner for file input
		myReader.nextLine();
		
		//Getting file inputs into both arrays
		while(myReader.hasNextLine()) {
			myReader.next();
			employees.add(new Employee(myReader.nextInt()));
			arrAnswers.add(myReader.next());
		}
		
		//Running tests
		for(int i = 0; i < amountOfTests; i++) {
			if (employees.get(i).EmployeeAvailableTestOutput().equals(arrAnswers.get(i))) {
				correctAnswers++;
			} else System.out.println("Test case " + (i+1) + " failed");
		} System.out.println("Test case 1: Amount of correct cases: " + correctAnswers + "/" + amountOfTests);
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
