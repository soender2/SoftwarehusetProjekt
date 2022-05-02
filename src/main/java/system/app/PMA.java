package system.app;

import Exceptions.OperationNotAllowed;

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

    public boolean employeeExist(String employeeId) {
        for(Employee employee: employees) {
            if(employee.employeeId.equals(employeeId)) {
                return true;
            }
        }
        return false;
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


    public Project getProject(String name) {
        assert true: "precondition getProject";
        for (Project project : projects) {
            if (project.name.equals(name)) {
                assert name.equals(project.name): "postcondition getProject";
                return project;
            }
        }
        return null;
    }

    public boolean existProjectName(String projectname) {
        assert true: "precondition existProjectName";
        for (Project project : projects) {
            if (project.name.equals(projectname)) {
                assert project.name.equals(projectname): "postcondition existProjectName";
                return true;
            }}
        return false;
    }



    public ArrayList<Employee> availableEmployees() {
        ArrayList<Employee> availableEmployees = new ArrayList<>();
        for(Employee employee : employees) {
            if(employee.EmployeeAvailable()){
                availableEmployees.add(employee);
            }}
        return availableEmployees;
    }


    public Employee getEmployee(String employee_id) {
        for(Employee employee: employees) {
            if(employee.employeeId.equals(employee_id)) {
                return employee;
            }}
        return null;
    }

    public boolean isEmployeeAvailable(String name) throws OperationNotAllowed {
        assert true: "precondition for isEmployeeAvailable";
        for(Employee employee: employees) {
            if(employee.employeeId.equals(name)) {
                assert employee.employeeId.equals(name): "postcondition for isEmployeeAvailable";
                return employee.EmployeeAvailable();
            }}
        throw new OperationNotAllowed("Employee is not available");
    }
}
