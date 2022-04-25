package system.app;
import io.cucumber.java.en_old.Ac;

import java.util.ArrayList;

public class Project {
    private static final int CURRENT_YEAR = 2022;
    private static final int CURRENT_YEAR_ID = CURRENT_YEAR - 2000;
    private static int projectCounter = 0;
    String projectID;
    int id;
    public String name;
    Employee projectManager;
    int finishTime;
    int timeSpent;
    public ArrayList<Activity> activities;

    public Project(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
        projectCounter++;
        this.projectID = projectCounter + "" + CURRENT_YEAR_ID;
    }

    public Employee getProjectManager() {
        return this.projectManager;
    }

    public void setProjectManager(Employee employee) {
        this.projectManager = employee;
    }

    public boolean hasProjectManager(){
        if(this.projectManager == null) return false;
        else return true;
    }

    public boolean isProjectManager(Employee employee) throws OperationNotAllowed {
        assert true: "precondition for isProjectManager";
        if(this.projectManager == null || employee != this.projectManager) {
            throw new OperationNotAllowed("Projectmanager is not registered");
        } else {
            assert true: "postcondition for isProjectManager";
            return true;
        }
    }

    public boolean hasActivity(Activity activity) {
        return activities.contains(activity);
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
        if(!activity.employee.projects.contains(this)) {
            activity.employee.projects.add(this);
        }
    }

    public boolean nameExistActivity(String name) {
        for(Activity activity: activities) {
            if(activity.name.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public Activity getActivity(String name) {
        for(Activity activity: activities) {
            if(activity.name.equals(name)) {
                return activity;
            }
        }
        return null;
    }

    public boolean projectContainsActivity() throws OperationNotAllowed {
        if(this.activities.isEmpty()) {
            throw new OperationNotAllowed("No activities available for deleting");
        } else {
            return false;
        }
    }



}
