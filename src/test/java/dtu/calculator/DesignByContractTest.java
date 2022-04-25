package dtu.calculator;
import Exceptions.OperationNotAllowed;
import org.junit.Test;
import system.app.Activity;
import system.app.Employee;
import system.app.PMA;
import system.app.Project;

public class DesignByContractTest {
    PMA pma = new PMA();
    Project project = new Project("name");
    Employee employee = new Employee("Initials");
    Activity activity = new Activity("Aktivitet");
    @Test
    public void getProjectTest(){
        pma.addProject(project);
        pma.getProject(project.name);
    }

    @Test
    public void isProjectManagerTest() throws OperationNotAllowed {
        pma.addProject(project);
        pma.getProject("name").setProjectManager(employee);
        pma.getProject("name").isProjectManager(employee);
    }

    @Test
    public void assignEmployeeActivitiesTest(){
        activity.assignEmployeeActivities(employee);
    }

    @Test
    public void isEmployeeAvailableTest() throws OperationNotAllowed {
        pma.employees.add(employee);
        pma.isEmployeeAvailable(employee.getEmployeeId());

    }












}
