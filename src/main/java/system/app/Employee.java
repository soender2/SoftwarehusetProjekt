package system.app;

import java.util.ArrayList;

public class Employee {
    public String employeeId;
    public ArrayList<Activity> activities;
    public ArrayList<Project> projects;
    int timeWorked;
    int[][] annaulTime;

    public Employee(String employeeId) {
        this.activities = new ArrayList<>();
        this.employeeId = employeeId;
        this.activities = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    public String[] getEmployeeProjects() {
        String[] projectsName = new String[this.projects.size()];
        int i = 0;
        for(Project project: projects) {
            projectsName[i] = project.name;
            i++;
        }
        return projectsName;
    }


    public int getDailyWorkedHours() {
        return this.timeWorked;
    }

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
