package dtu.calculator;

import io.cucumber.java.en_old.Ac;
import system.app.Employee;
import system.app.PMA;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.an.E;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import system.app.*;

public class DeleteActivity {

    Employee employee;
    TestData testData;
    Activity activity;

    public DeleteActivity(TestData testData) {
        this.testData = testData;
        this.testData.pma = new PMA();
        this.testData.errorMessageHolder = new ErrorMessageHolder();
    }

    @Given("the project have an activity named {string}")
    public void the_project_have_an_activity_named(String string) {
        this.activity = new Activity(string);
        testData.project.addActivity(this.activity);
        assertTrue(testData.project.hasActivity(activity));
    }

    @When("the user deletes the activity")
    public void the_user_deletes_the_activity() {
        testData.project.removeActivity(this.activity);
    }

    @Then("the activity named {string} is deleted from the project")
    public void the_activity_named_is_deleted_from_the_project(String string) {
        assertFalse(testData.project.nameExistActivity(string));
    }

    @Given("the project contains zero activities")
    public void the_project_contains_zero_activities() {
        try {
            assertFalse(testData.project.projectContainsActivity());
        } catch (OperationNotAllowed e) {
            testData.errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }
}
