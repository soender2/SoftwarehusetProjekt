package dtu.calculator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import system.app.Employee;
import system.app.PMA;
import system.app.Project;

public class AddActivity {
    Employee employee;
    Project project;
    PMA pma;
    ErrorMessageHolder errorMessageHolder;

    public AddActivity(Project project, PMA pma){
        this.project = project;
        this.pma = pma;

    }

    @Given("the activity with the name {string} is not in the project")
    public void the_activity_with_the_name_is_not_in_the_project(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the activity is added to the project")
    public void the_activity_is_added_to_the_project() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the activity with title {string} is added to the project")
    public void the_activity_with_title_is_added_to_the_project(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
