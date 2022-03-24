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


}
