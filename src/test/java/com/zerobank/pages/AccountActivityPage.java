package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityPage extends BasePage {

    public AccountActivityPage() {

        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//select[@name='accountId']")
    public WebElement dropdown;

    @FindBy(xpath = "//table[@class='table table-condensed table-hover']//thead//th")
    public List<WebElement> tableHeader;

    public void navigateTo(String tabName) {
        Driver.get().findElement(By.xpath("//a[contains(.,'" + tabName + "')]")).click();

    }

    public String firstDisplayed() {
        Select account = new Select(dropdown);
        return account.getFirstSelectedOption().getText();
    }

    public List<String> getAccountOptions() {
        List<WebElement> dropdownOptions = new Select(dropdown).getOptions();
        List<String> optionTextList = new ArrayList<>();
        dropdownOptions.forEach(option -> optionTextList.add(option.getText()));
        return optionTextList;
    }

    public List<String> getTableHeaderList(){
        List<String> tableHeaderText = new ArrayList<>();
        tableHeader.forEach(element -> tableHeaderText.add(element.getText()));
        return tableHeaderText;
    }


}
