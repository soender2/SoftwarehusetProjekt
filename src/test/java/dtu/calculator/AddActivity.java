package dtu.calculator;

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

public class AddActivity {
    Employee employee;
    Project project;
    PMA pma;
    Activity activity;
    ErrorMessageHolder errorMessageHolder;
    TestData testData;

    public AddActivity(TestData testData){
        this.testData = testData;
    }

    @Given("the activity with the name {string} is not in the project")
    public void the_activity_with_the_name_is_not_in_the_project(String string) {
        activity = new Activity(string);
        assertFalse(testData.project.hasActivity(activity));
    }

    @When("the activity is added to the project")
    public void the_activity_is_added_to_the_project() {
        testData.project.addActivity(activity);
    }

    @Then("the activity with title {string} is added to the project")
    public void the_activity_with_title_is_added_to_the_project(String string) {
        assertTrue(testData.project.nameExistActivity(string));
    }

}
