package system.app;

public class Project {
    int id;
    String name;
    Employee projectManager;
    int finishTime;
    int timeSpent;

    public Project(String name) {
        this.name = name;
    }

    public boolean isProjectManager(Employee employee) {
        return this.projectManager.employeeId.equals(employee.employeeId);
    }


}
