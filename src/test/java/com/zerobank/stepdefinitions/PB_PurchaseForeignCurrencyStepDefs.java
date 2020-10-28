package com.zerobank.stepdefinitions;

import com.zerobank.pages.PB_PurchaseForeignCurrencyPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class PB_PurchaseForeignCurrencyStepDefs {

    PB_PurchaseForeignCurrencyPage pb_purchaseForeignCurrencyPage
            = new PB_PurchaseForeignCurrencyPage();

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedCurrency) {
        BrowserUtils.waitFor(3);
        List<String > actualCurrency = pb_purchaseForeignCurrencyPage.getCurrencyOptions();
        Assert.assertEquals(expectedCurrency,actualCurrency);
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        BrowserUtils.waitFor(2);
        pb_purchaseForeignCurrencyPage.enterAmount("100");
        pb_purchaseForeignCurrencyPage.calculateCostButton.click();
    }

    @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedErrorMessage) {
        String actualErrorMessage = pb_purchaseForeignCurrencyPage.getAlertErrorMessage();
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
        System.out.println(expectedErrorMessage);
        System.out.println(actualErrorMessage);
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        BrowserUtils.waitFor(2);
        pb_purchaseForeignCurrencyPage.selectCurrency("Denmark (krone)");
        pb_purchaseForeignCurrencyPage.calculateCostButton.click();

    }

}
