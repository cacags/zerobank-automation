package com.zerobank.stepdefinitions;

import com.zerobank.pages.BasePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("the user is on the Login Page")
    public void the_user_is_on_the_Login_Page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enters {string} and {string}")
    public void the_user_enters_and(String username, String password) {
        new LoginPage().login(username,password);
    }

    @Then("Error message {string} should be displayed")
    public void error_message_should_be_displayed(String message) {
        BrowserUtils.waitFor(3);
        Assert.assertTrue(new LoginPage().errorMessage.getText().equals(message));
    }


}
