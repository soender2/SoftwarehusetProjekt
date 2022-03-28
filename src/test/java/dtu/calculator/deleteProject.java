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
        ErrorMessageHolder errorMessageHolder;

        public deleteProject(PMA pma, ErrorMessageHolder errorMessageHolder) {
            this.pma = pma;
            this.errorMessageHolder = errorMessageHolder;
        }

        @Given("there is a project with project name {string}")
        public void there_is_a_project_with_project_name(String string) {
            project = new Project(string);
            pma.addProject(project);
            assertTrue(pma.existProject(project));
        }

        @Given("the user with initials {string} is the manager of the project")
        public void the_user_with_initials_is_the_manager_of_the_project(String string) {
            employee = new Employee(string);
            project.setProjectManager(employee);
            try {
                assertTrue(project.isProjectManager(employee));
            } catch (OperationNotAllowed e) {
                errorMessageHolder.setErrorMessage(e.getMessage());
            }
        }

        @When("the user removes the project")
        public void the_user_removes_the_project() {
            pma.deleteProject(project);
        }

        @Then("the project is removed")
        public void the_project_is_removed() {
            assertFalse(pma.existProject(project));
        }

        @Given("the user with initials {string} is not the manager of the project")
        public void the_user_with_initials_is_not_the_manager_of_the_project(String string) {
            employee = new Employee(string);

            try {
                assertTrue(project.isProjectManager(employee));
            } catch (OperationNotAllowed e) {
                errorMessageHolder.setErrorMessage(e.getMessage());
            }

        }
        @Then("the error message {string} is given")
        public void the_error_message_is_given(String errormessage) {
            assertEquals(errormessage, this.errorMessageHolder.getErrorMessage());
        }

        @Given("there isn't a project with project name {string}")
        public void there_isn_t_a_project_with_project_name(String string) {
            assertFalse(pma.existProject(project));
            errorMessageHolder.setErrorMessage("project doesn't exist");
        }
    }


