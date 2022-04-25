package dtu.calculator;
import org.junit.Test;
import system.app.Employee;
import system.app.OperationNotAllowed;
import system.app.PMA;
import system.app.Project;

public class DesignByContractTest {
    PMA pma = new PMA();
    Project project = new Project("name");
    Employee employee = new Employee("Initials");
    @Test
    public void getProjectTest(){
        pma.addProject(project);
        pma.getProject(project.name);
    }
    @Test
    public void existProjectNameTest(){
        pma.addProject(project);
        pma.existProjectName("name");
    }
    @Test
    public void isProjectManagerTest() throws OperationNotAllowed {
        pma.addProject(project);
        pma.getProject("name").setProjectManager(employee);
        pma.getProject("name").isProjectManager(employee);
    }
    @Test
    public void getAvailableEmployeesTest(){
        pma.employees.add(employee);
        pma.getAvailableEmployees();
    }










}
