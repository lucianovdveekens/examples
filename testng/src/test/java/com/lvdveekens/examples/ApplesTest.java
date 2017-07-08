package com.lvdveekens.examples;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.testng.AbstractTestNGCucumberTests;

import static org.testng.AssertJUnit.assertEquals;

@CucumberOptions(
        features = "classpath:features/Apples.feature",
        glue = "classpath:com.lvdveekens.examples",
        format = "pretty",
        strict = true
)
public class ApplesTest extends AbstractTestNGCucumberTests {

    private int amountOfApples;

    @Given("^I have (\\d+) apples$")
    public void iHaveApples(int amount) throws Throwable {
        amountOfApples = amount;
    }

    @When("^I give (\\d+) away$")
    public void iGiveAway(int amount) throws Throwable {
        amountOfApples -= amount;
    }

    @Then("^I have (\\d+) left$")
    public void iHaveLeft(int amount) throws Throwable {
        assertEquals(amount, amountOfApples);
    }
}
