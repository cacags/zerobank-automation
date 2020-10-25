package com.zerobank.stepdefinitions;

import com.zerobank.pages.AA_FindTransactions;
import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.BasePage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FindTransactions {
    AA_FindTransactions aa_findTransactions;
    @Then("the user click the {string} tab")
    public void theUserClickTheTab(String moduleName) {
        new BasePage().navigateTo(moduleName);

    }

    @Given("the user accesses the {string} tab")
    public void theUserAccessesTheTab(String moduleName) {
        new AccountActivityPage().navigateTo(moduleName);
        BrowserUtils.waitFor(5);
    }

    @When("the user enters date range	from {string} to {string}")
    public void theUserEntersDateRangeFromTo(String fDate, String tDate) {
        aa_findTransactions = new AA_FindTransactions();
        aa_findTransactions.fromDate.clear();
        aa_findTransactions.toDate.clear();
        aa_findTransactions.fromDate.sendKeys(fDate);
        aa_findTransactions.toDate.sendKeys(tDate);
        BrowserUtils.waitFor(5);
    }

    @And("clicks search")
    public void clicksSearch() {
        new AA_FindTransactions().findButton.click();
    }

    @Then("results table should only show	transactions dates between {string}	to {string}")
    public void resultsTableShouldOnlyShowTransactionsDatesBetweenTo(String fDate, String tDate) throws Exception {
        BrowserUtils.waitFor(5);
        aa_findTransactions = new AA_FindTransactions();
        Assert.assertFalse(aa_findTransactions.isFirst(tDate));
        Assert.assertFalse(aa_findTransactions.isLast(fDate));

    }

    @And("the	results	should be sorted by	most recent date")
    public void theResultsShouldBeSortedByMostRecentDate() {
        String expectedDate = aa_findTransactions.toDate.getAttribute("value");
        String actualDate = aa_findTransactions.getMostRecentDate();
        Assert.assertEquals(expectedDate,actualDate);
    }

    @And("the	results	table should only not contain transactions dated {string}")
    public void theResultsTableShouldOnlyNotContainTransactionsDated(String date) {
        Assert.assertFalse(aa_findTransactions.isContain(date));
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        aa_findTransactions = new AA_FindTransactions();
        aa_findTransactions.descriptionInbox.clear();
        aa_findTransactions.descriptionInbox.sendKeys(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String value) {
        BrowserUtils.waitFor(3);
        Assert.assertTrue(new AA_FindTransactions().isContainDescription(value));
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {

    }



}
