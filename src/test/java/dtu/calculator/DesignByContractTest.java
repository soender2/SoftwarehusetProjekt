package dtu.calculator;
import org.junit.Test;
import system.app.PMA;
import system.app.Project;

public class DesignByContractTest {

    @Test
    public void testFailingAsserts(){
        PMA pma = new PMA();
        Project project = new Project("name");
        pma.addProject(project);
        pma.getProject(project.name);

    }
    @Test
    public void existProjectNameTest(){
        PMA pma = new PMA();
        Project project = new Project("name");
        pma.addProject(project);
        pma.existProjectName("name");

    }

}
