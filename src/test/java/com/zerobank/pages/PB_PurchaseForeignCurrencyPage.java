package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class PB_PurchaseForeignCurrencyPage {

    public PB_PurchaseForeignCurrencyPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//input[@id='pc_amount']")
    public WebElement amount;

    @FindBy(xpath = "//input[@type='radio'][contains(@id,'true')]")
    public WebElement usDollar;

    @FindBy(xpath = "//input[@type='radio'][contains(@id,'false')]")
    public WebElement selectedCurrency;

    @FindBy(xpath = "//input[@type='button'][contains(@id,'costs')]")
    public WebElement calculateCostButton;

    @FindBy(xpath = "//input[@type='submit'][contains(@id,'cash')]")
    public WebElement purchaseButton;

    @FindBy(xpath = "//select[contains(@name,'currency')]")
    public WebElement currencyDropdown;

    public List<String> getCurrencyOptions(){
        List<String> optionText = new ArrayList<>();
        Select select = new Select(currencyDropdown);
        List<WebElement> options = select.getOptions();
        options.forEach(element -> optionText.add(element.getText()));
        return optionText;
    }

    public void enterAmount(String expectedAmount){
        amount.sendKeys(expectedAmount);
    }


}
