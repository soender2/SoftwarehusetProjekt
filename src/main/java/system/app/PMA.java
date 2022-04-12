package system.app;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class PMA {
    public ArrayList<Employee> employees;
    public ArrayList<Project> projects;
    Employee employee;

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
        for (Project project : projects) {
            if (project.name.equals(projectname)) {
                return true;
            }
        }
        return false;
    }




    public ArrayList<Employee> availableEmployees() {
        ArrayList<Employee> availableEmployees = new ArrayList<>();
        for(Employee employee : employees) {
            if(employee.EmployeeAvailable()){
                availableEmployees.add(employee);
            }
        }
        return availableEmployees;
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
