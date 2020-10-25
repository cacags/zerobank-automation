package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PB_AddNewPayeePage {

    public PB_AddNewPayeePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//input[@type='text'][contains(@id,'name')]")
    public WebElement payeeName;

    @FindBy(xpath = "//textarea[contains(@name,'address')]")
    public WebElement payeeAddress;

    @FindBy(xpath = "//input[@type='text'][contains(@id,'account')]")
    public WebElement accountName;

    @FindBy(xpath = "//input[@type='text'][contains(@id,'details')]")
    public WebElement payeeDetails;

    @FindBy(xpath = "//div[@id='alert_content']")
    public WebElement payeeMessage;

    @FindBy(xpath = "//input[@value='Add']")
    public WebElement addButton;

    public String getPayeeMessage(){
        return payeeMessage.getText();
    }

    public void enterPayeeName(String name){
        payeeName.sendKeys(name);
    }

    public void enterPayeeAddress(String address){
        payeeAddress.sendKeys(address);
    }

    public void enterAccount(String account){
        accountName.sendKeys(account);
    }

    public void enterPayeeDetails(String details){
        payeeDetails.sendKeys(details);
    }

    public void clickAddButton(){
        addButton.click();
    }




}
