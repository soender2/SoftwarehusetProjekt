package system.app;

public class Activity {
    String name;
    Employee employee;
    int timeHolder;
    int timeEstimate;
    int startTime;
    int endTime;

    public Activity(String name) {
        this.name = name;
    }

    public void assignEmployeeActivities(Employee employee) {
        this.employee = employee;
    }

    public boolean isActivityStaffed() {
        return this.employee != null;
    }

    public void reportTimeWorked(int timeHolder){
        this.timeHolder += timeHolder;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmployeeId() {
        return this.employee.employeeId;
    }

    public String getName(){
        return this.name;
    }







}
