package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefs {

    @Then("the page should have the title {string}")
    public void the_page_should_have_the_title(String title) {
        String expectedTitle = title;
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

    }

    @Then("the user should see following account types")
    public void the_user_should_see_following_account_types(List<String> accountTypes) {
        BrowserUtils.waitFor(4);
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        Assert.assertEquals(accountTypes.get(0), accountSummaryPage.cashAccounts.getText());
        Assert.assertEquals(accountTypes.get(1), accountSummaryPage.investmentAccounts.getText());
        Assert.assertEquals(accountTypes.get(2), accountSummaryPage.creditAccounts.getText());
        Assert.assertEquals(accountTypes.get(3), accountSummaryPage.loanAccounts.getText());

    }

    @Then("{string} table must have following columns")
    public void table_must_have_following_columns(String tableName, List<String> expectedHeader) {
        List<String> actualHeader = new AccountSummaryPage().getTableHeadersList(tableName);

        Assert.assertEquals(expectedHeader, actualHeader);


    }
}
