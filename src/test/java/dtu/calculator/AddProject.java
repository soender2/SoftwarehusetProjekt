package dtu.calculator;

import java.util.Date;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en_old.Ac;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import system.app.Activity;
import system.app.Employee;
import system.app.PMA;
import system.app.Project;
public class AddProject {

    Employee employee;
    TestData testData;
    Activity activity;


    public AddProject(TestData testData) {
        this.testData = testData;
        this.testData.pma = new PMA();
        this.testData.errorMessageHolder = new ErrorMessageHolder();
    }

    @Given("a project with title {string}")
    public void a_project_with_title(String string) {
        assertTrue(string.length() > 0);
    }

    @Given("the project does not exist with title {string}")
    public void the_project_does_not_exist_with_title(String string) {
        assertFalse(testData.pma.existProjectName(string));
    }

    @When("the project is added with title {string}")
    public void the_project_is_added_with_title(String string) {
        testData.pma.addProject(new Project(string));
        assertTrue(testData.pma.existProjectName(string));
    }

    @Then("the project is contained in PMA with title {string}")
    public void the_project_is_contained_in_pma_with_title(String string) {
        assertTrue(testData.pma.existProjectName(string));
    }

    @Then("the error message {string} is given for all")
    public void the_error_message_is_given_for_all(String string) {
        testData.errorMessageHolder.setErrorMessage("project already exists");
        assertEquals(testData.errorMessageHolder.getErrorMessage(), "project already exists");
    }

}
