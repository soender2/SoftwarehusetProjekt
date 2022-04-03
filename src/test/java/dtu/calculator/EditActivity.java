package dtu.calculator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import system.app.Activity;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EditActivity {
    String name;
    TestData testData;


    public EditActivity(TestData testData){this.testData = testData;}

    @Given("there is a name {string}")
    public void there_is_a_name(String string) {
        this.name = "testing 2";
       assertEquals(string, name);
    }

    @When("the name is edited")
    public void the_name_is_edited() {
        System.out.println("røvhulshul");
        System.out.println(testData.project.hasActivity(testData.activity));



    }

    @Then("the name of the activity is {string}")
    public void the_name_of_the_activity_is(String string) {

        assertEquals(testData.activity.getName(), name);
    }
}
