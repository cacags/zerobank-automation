package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PB_PaySavedPayeePage {

    public PB_PaySavedPayeePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//select[@id='sp_payee']")
    public WebElement payeeDropdownOptions;

    @FindBy(xpath = "//select[@id='sp_account']")
    public WebElement accountDropdownOptions;

    @FindBy(id = "sp_amount")
    public WebElement amountInbox;

    @FindBy(id = "sp_date")
    public WebElement dateInbox;

    @FindBy(id = "sp_description")
    public WebElement descriptionInbox;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;

    @FindBy(xpath = "//div[@id='alert_content']//span")
    public WebElement paymentMessage;

    public String getPaymentMessage(){
        return paymentMessage.getText();
    }

    public void clickPayButton(){
        payButton.click();
    }

    public void enterDescription(String description) {
        descriptionInbox.sendKeys(description);
    }

    public void enterDate(String date) {
        dateInbox.sendKeys(date);
    }

    public void enterAmount(String amount) {
        amountInbox.sendKeys(amount);
    }

    public void selectPayeeOptions(String payeeOption) {
        Select select = new Select(payeeDropdownOptions);
        select.selectByVisibleText(payeeOption);
    }

    public void selectAccountOptions(String accountOption) {
        Select select = new Select(accountDropdownOptions);
        select.selectByVisibleText(accountOption);
    }

    public String getAmountErrorMessage(){
        return amountInbox.getAttribute("validationMessage");
    }

    public String getDateErrorMessage(){
        return dateInbox.getAttribute("validationMessage");
    }

    public boolean getDateInputAttribute(){
          int inputTextLength = dateInbox.getAttribute("value").length();
          return (inputTextLength==0) ? true : false;
    }


}
