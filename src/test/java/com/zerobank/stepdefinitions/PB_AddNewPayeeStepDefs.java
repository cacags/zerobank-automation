package com.zerobank.stepdefinitions;

import com.zerobank.pages.PB_AddNewPayeePage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class PB_AddNewPayeeStepDefs {

    PB_AddNewPayeePage pb_addNewPayeePage = new PB_AddNewPayeePage();

    @Given("{string} tab")
    public void tab(String tabName) {
        new PayBillsPage().navigateTo(tabName);
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> payeeInformation) {
        BrowserUtils.waitFor(2);
        pb_addNewPayeePage.enterPayeeName(payeeInformation.get("Payee Name"));
        pb_addNewPayeePage.enterPayeeAddress(payeeInformation.get("Payee Address"));
        pb_addNewPayeePage.enterAccount(payeeInformation.get("Account"));
        pb_addNewPayeePage.enterPayeeDetails(payeeInformation.get("Payee details"));
        pb_addNewPayeePage.clickAddButton();

    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String expectedPayeeMessage) {
        String actualPayeeMessage = pb_addNewPayeePage.getPayeeMessage();
        Assert.assertEquals(expectedPayeeMessage,actualPayeeMessage);
    }
}
