package system.app;

import java.util.ArrayList;

public class Employee {
    public String employeeId;
    ArrayList<Activity> activities;
    int timeWorked;
    int[][] annaulTime;

    public Employee(String employeeId) {
        this.employeeId = employeeId;
    }

    /*
    public int getDailyWorkedHours() {
    }*/

    public String getEmployeeId() {
        return employeeId;
    }

    public boolean EmployeeAvailable() {
        if(this.activities == null || this.activities.size() < 10) {
            return true;
        } else {
            return false;
        }
    }

}
