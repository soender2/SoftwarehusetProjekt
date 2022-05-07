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

    /* her starter det vigtige */

    @Test
    public void existProjectNameTest(){
        /* Vi tilføjer et projekt */
        pma.projects.add(project);
        /* Vi tjeker efter */
     pma.existProjectName(project.name);
    }
    @Test
    public void isProjectManagerTest() throws OperationNotAllowed {
        Employee employee1 = new Employee("hans");
        pma.addProject(project);
        pma.getProject("name").setProjectManager(employee1);
        pma.getProject("name").isProjectManager(employee1);
    }

    @Test
    public void availableEmployeesTest(){
        Employee employee2 = new Employee("tolk");
        pma.employees.add(employee2);
        pma.availableEmployees();
    }

    @Test
    public void projectContainsActivitiesTest() throws OperationNotAllowed {
        project.activities.add(activity);
        project.projectContainsActivities();
    }















}
