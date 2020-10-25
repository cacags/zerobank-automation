package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountActivity {

    @Then("the account dropdown should see the following options")
    public void the_account_dropdown_should_see_the_following_options(List<String> expectedDropdownOptions) {
        List<String> actualDropdownOption = new AccountActivityPage().getAccountOptions();
        Assert.assertEquals(expectedDropdownOptions, actualDropdownOption);
    }

    @Then("Transactions table should have column names")
    public void transactions_table_should_have_column_names(List<String> expectedColumnNames) {
        List<String> actualColumnNames = new AccountActivityPage().getTableHeaderList();
        Assert.assertEquals(expectedColumnNames, actualColumnNames);

    }
}
