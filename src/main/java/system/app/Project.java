package system.app;

import java.util.ArrayList;

public class Project {
    int id;
    String name;
    Employee projectManager;
    int finishTime;
    int timeSpent;
    ArrayList<Activity> activities;

    public Project(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    public Employee getProjectManager() {
        return this.projectManager;
    }

    public void setProjectManager(Employee employee) {
        this.projectManager = employee;
    }

    public boolean isProjectManager(Employee employee) throws OperationNotAllowed {
        if(this.projectManager == null) {
            throw new OperationNotAllowed("project manager is not registered");
        } else {
            return this.projectManager.employeeId.equals(employee.employeeId);
        }
    }

    public boolean hasActivity(Activity activity) {
        return activities.contains(activity);
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public boolean nameExistActivity(String name) {
        for(Activity activity: activities) {
            if(activity.name.equals(name)) {
                return true;
            }
        }
        return false;
    }

}
