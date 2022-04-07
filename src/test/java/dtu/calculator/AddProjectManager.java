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

public class AddProjectManager {

    Employee employee;
    TestData testData;
    Activity activity;
    ErrorMessageHolder errorMessageHolder;

    public AddProjectManager(TestData testData, ErrorMessageHolder errorMessageHolder) {
        this.testData = testData;
        this.testData.pma = new PMA();
        this.testData.errorMessageHolder = errorMessageHolder;
    }

    @Given("there is a project with name {string} without a project manager")
    public void the_project_with_name_does_not_contain_a_project_manager(String string) {
        testData.project = new Project(string);
        assertFalse(testData.project.hasProjectManager());
    }

    @When("the user with name {string} is added to the project")
    public void the_user_with_name_is_added_to_the_project_with_name(String userName) {
        testData.employee = new Employee(userName);
        testData.project.setProjectManager(testData.employee);
    }

    @Then("the user is added as project manager successfully")
    public void the_user_is_added_as_project_manager_successfully() {
        assertTrue(testData.project.hasProjectManager());
    }

    @Given("there is a project with name {string} with a project manager")
    public void there_is_a_project_with_name_with_a_project_manager(String string) {
        testData.project = new Project(string);
        testData.employee = new Employee("testName");
        testData.project.setProjectManager(testData.employee);
        assertTrue(testData.project.hasProjectManager());
        testData.errorMessageHolder.setErrorMessage("project already has a project manager");
    }


}
