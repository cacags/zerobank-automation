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

public class FindTransactionsStepDefs {
    AA_FindTransactions aa_findTransactions = new AA_FindTransactions();
    @Then("the user click the {string} tab")
    public void theUserClickTheTab(String moduleName) {
        new BasePage().navigateTo(moduleName);

    }

    @Given("the user accesses the {string} tab")
    public void theUserAccessesTheTab(String moduleName) {
        new AccountActivityPage().navigateTo(moduleName);
        //BrowserUtils.waitFor(5);
    }

    @When("the user enters date range	from {string} to {string}")
    public void theUserEntersDateRangeFromTo(String fDate, String tDate) {
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
        aa_findTransactions.descriptionInbox.clear();
        aa_findTransactions.descriptionInbox.sendKeys(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String value) {
        BrowserUtils.waitFor(3);
        new AA_FindTransactions().isDescriptionContain(value);
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String value) {
        BrowserUtils.waitFor(5);
        new AA_FindTransactions().isDescriptionNotContain(value);
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(aa_findTransactions.isDepositContainsData());
        //System.out.println(aa_findTransactions.isDepositContainsData());
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(aa_findTransactions.isWithdrawalContainsData());
        //System.out.println(aa_findTransactions.isWithdrawalContainsData());
    }

    @When("user selects type {string}")
    public void user_selects_type(String type) {
        //BrowserUtils.waitFor(2);
        aa_findTransactions.selectType(type);
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        Assert.assertFalse(aa_findTransactions.isWithdrawalContainsData());
        //System.out.println(aa_findTransactions.isWithdrawalContainsData());
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        Assert.assertFalse(aa_findTransactions.isDepositContainsData());
        //System.out.println(aa_findTransactions.isDepositContainsData());
    }



}
