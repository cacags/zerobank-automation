package com.zerobank.stepdefinitions;

import com.zerobank.pages.PB_PaySavedPayeePage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PB_PaySavedPayeeStepDefs {

    @Then("the user choose {string} as a Payee from dropdown options")
    public void the_user_choose_as_a_Payee_from_dropdown_options(String payeeOption) {
        BrowserUtils.waitFor(3);
        new PB_PaySavedPayeePage().selectPayeeOptions(payeeOption);
    }

    @Then("the user choose {string} as an Account from dropdown options")
    public void the_user_choose_as_an_Account_from_dropdown_options(String accountOption) {
        new PB_PaySavedPayeePage().selectAccountOptions(accountOption);
    }

    @Then("the user enters {string} as an amount of payment")
    public void the_user_enters_as_an_amount_of_payment(String amount) {
        new PB_PaySavedPayeePage().enterAmount(amount);
    }

    @Then("the user enters {string} as a date")
    public void the_user_enters_as_a_date(String date) {
        new PB_PaySavedPayeePage().enterDate(date);
    }

    @Then("user enters {string} as a description")
    public void user_enters_as_a_description(String description) {
        new PB_PaySavedPayeePage().enterDescription(description);
    }

    @When("the user enter the pay button")
    public void the_user_enter_the_pay_button() {
        new PB_PaySavedPayeePage().clickPayButton();
    }

    @Then("the user should see {string} message")
    public void the_user_should_see_message(String expectedMessage) {
        BrowserUtils.waitFor(3);
        String actualMessage = new PB_PaySavedPayeePage().getPaymentMessage();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Then("{string} message in amount box should pop-up")
    public void message_in_amount_box_should_pop_up(String expectedErrorMessage) {
        String actualErrorMessage = new PB_PaySavedPayeePage().getAmountErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Then("{string} in date box message should pop-up")
    public void in_date_box_message_should_pop_up(String expectedErrorMessage) {
        String actualErrorMessage = new PB_PaySavedPayeePage().getDateErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Then("in data field there should't be any alphabetical characters")
    public void in_data_field_there_should_t_be_any_alphabetical_characters() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(new PB_PaySavedPayeePage().getDateInputAttribute());
    }
}
