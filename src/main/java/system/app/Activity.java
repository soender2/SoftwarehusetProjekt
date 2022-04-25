package system.app;


public class Activity {
    String name;
    Employee employee;
    int timeHolder;
    int timeEstimate;
    public int startTime;
    public int endTime;
    PMA pma;

    public Activity(String name) {
        this.name = name;
        this.employee = null;
    }

    public void assignEmployeeActivities(Employee employee) {
        assert true: "precondition for assignEmployeeActivities";
        this.employee = employee;
        if(!employee.activities.contains(this)) {
            employee.activities.add(this);
        }
        assert employee.activities.contains(this):"postcondition for assignEmployeeActivities";

    }

    public boolean isActivityStaffed() {
        return this.employee != null;
    }

    public void reportTimeWorked(int timeHolder){
        this.timeHolder += timeHolder;
    }

    public void editTimeSchedule(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    public String getEmployeeId() {
        return this.employee.employeeId;
    }

    public String getName(){
        return this.name;
    }




}
