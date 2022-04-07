package system.app;


public class Activity {
    String name;
    Employee employee;
    int timeHolder;
    int timeEstimate;
    int startTime;
    int endTime;
    PMA pma;

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

    public void seekAssistance(Activity activity){
        activity.setEmployee(pma.availableEmployees().get(0));
        pma.availableEmployees().remove(0);

    }




}
