package dtu.calculator;

import system.app.Activity;
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

import java.util.ArrayList;

public class StaffEmployee {

    Employee employee;
    TestData testData;
    Activity activity;

    public StaffEmployee(TestData testData) {
        this.testData = testData;
        this.testData.pma = new PMA();
        this.testData.errorMessageHolder = new ErrorMessageHolder();
    }

    @Given("the activity named {string} is not staffed")
    public void the_activity_named_is_not_staffed(String string) {
        assertFalse(testData.project.getActivity(string).isActivityStaffed());
    }

    @Given("the given employee named {string} is available")
    public void the_given_employee_named_is_available(String string) {
        ArrayList<Employee> availableemployees = testData.pma.availableEmployees();

        for(Employee employee: availableemployees) {
            if(employee.employeeId.equals(string)) {
                assertTrue(employee.EmployeeAvailable());
            }
        }
    }
    @When("the user {string} staffs the employee {string} to the activity {string}")
    public void the_user_staffs_the_employee_to_the_activity(String string, String string2, String string3) {
        ArrayList<Employee> availableemployees = testData.pma.availableEmployees();
        Employee worker = null;

        for(Employee employee: availableemployees) {
            if(employee.employeeId.equals(string2)) {
                worker = employee;
            }
        }
        assert worker != null;
        testData.project.getActivity(string3).assignEmployeeActivities(worker);
    }
    @Then("the employee {string} is staffed to the activity {string}")
    public void the_employee_is_staffed_to_the_activity(String string, String string2) {
        System.out.println(testData.project.getActivity(string2).getEmployeeId());
        assertEquals(string, testData.project.getActivity(string2).getEmployeeId());
    }

}
