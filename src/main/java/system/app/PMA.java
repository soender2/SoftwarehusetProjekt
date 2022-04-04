package system.app;

import java.util.ArrayList;

public class PMA {
    ArrayList<Employee> employees;
    ArrayList<Project> projects;

    public PMA() {
        projects = new ArrayList<Project>();
        employees = new ArrayList<Employee>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public void deleteProject(Project project) {
        projects.remove(project);
    }

    public boolean existProject(Project project) {
        return projects.contains(project);
    }

    public boolean existProjectName(String projectname) {
        for(Project project: projects) {
            if(project.name.equals(projectname)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Employee> availableEmployees() {
        return employees;
    }

    public Employee getEmployee(String employee_id) {
        for(Employee employee: employees) {
            if(employee.employeeId.equals(employee_id)) {
                return employee;
            }
        }
        return null;
    }

    public boolean isEmployeeAvailable(String name){

        for(Employee employee: employees) {
            if(employee.employeeId.equals(name)) {
                return employee.EmployeeAvailable();
            }
        }
        return false;
    }

}
