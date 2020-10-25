package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.BasePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class AccountActivityNavigation {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String linkName) {
        //BrowserUtils.waitFor(3);
        new AccountSummaryPage().clickLinks(linkName);
    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String tabName) {
        String actualURL = Driver.get().getCurrentUrl();
        Assert.assertTrue(actualURL.contains(new BasePage().expectedURL(tabName)));

    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String selected) {
        //BrowserUtils.waitFor(3);
        String expectedValue = new AccountActivityPage().firstDisplayed();
        String actualValue = selected;
        Assert.assertEquals(expectedValue,actualValue);
    }


}
