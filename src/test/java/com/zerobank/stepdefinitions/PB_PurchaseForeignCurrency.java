package com.zerobank.stepdefinitions;

import com.zerobank.pages.PB_PurchaseForeignCurrencyPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class PB_PurchaseForeignCurrency {

    PB_PurchaseForeignCurrencyPage pb_purchaseForeignCurrencyPage
            = new PB_PurchaseForeignCurrencyPage();

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedCurrency) {
        BrowserUtils.waitFor(3);
        List<String > actualCurrency = pb_purchaseForeignCurrencyPage.getCurrencyOptions();
        Assert.assertEquals(expectedCurrency,actualCurrency);
    }
}
