package dtu.calculator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import system.app.*;

    public class deleteProject {
        Employee employee;
        Project project;
        PMA pma;

        public deleteProject(PMA pma) {
            this.pma = pma;
        }

        @Given("there is a project with project name {string}")
        public void there_is_a_project_with_project_name(String string) {
            // Write code here that turns the phrase above into concrete actions
            project = new Project(string);
        }

        @Given("the user with initials {string} is the manager of the project")
        public void the_user_with_initials_is_the_manager_of_the_project(String string) {
            employee = new Employee(string);
            assertTrue(project.isProjectManager(employee));
        }

        @When("the user request to remove the project")
        public void the_user_request_to_remove_the_project() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }
        @Then("the project should be removed")
        public void the_project_should_be_removed() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }
    }


