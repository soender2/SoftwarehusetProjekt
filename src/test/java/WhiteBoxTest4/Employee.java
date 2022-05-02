package WhiteBoxTest4;

import java.util.ArrayList;

public class Employee {
	ArrayList<Activity> activities = new ArrayList<Activity>();
	String name;
	
	Employee(int amountOfActivities){
		for(int i = 0; i < amountOfActivities; i++) {
			this.activities.add(new Activity());
		}
	}
	
	Employee(String name, int amountOfActivities){
		this.name = name;
		for(int i = 0; i < amountOfActivities; i++) {
			this.activities.add(new Activity());
		}
	}
	
	public boolean EmployeeAvailable() {
        if(this.activities == null || this.activities.size() < 10) {
            return true;
        } else return false;
    }
	
	public String EmployeeAvailableTestOutput() {
        if(this.activities == null || this.activities.size() < 10) {
            return "Yes";
        } else return "No";
    }
}
