package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AccountSummaryPage {

    public AccountSummaryPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//h2[contains(.,'Cash Accounts')]")
    public WebElement cashAccounts;

    @FindBy(xpath = "//h2[contains(.,'Investment Accounts')]")
    public WebElement investmentAccounts;

    @FindBy(xpath = "//h2[contains(.,'Credit Accounts')]")
    public WebElement creditAccounts;

    @FindBy(xpath = "//h2[contains(.,'Credit Accounts')]/following-sibling::div[1]//th")
    public WebElement creditAccountsTableHeader;

    @FindBy(xpath = "//h2[contains(.,'Loan Accounts')]")
    public WebElement loanAccounts;

    @FindBy(xpath = "//a[contains(.,'Savings')]")
    public WebElement savings;

    @FindBy(xpath = "//a[contains(.,'Brokerage')]")
    public WebElement brokerage;

    @FindBy(xpath = "//a[contains(.,'Checking')]")
    public WebElement checking;

    @FindBy(xpath = "//a[contains(.,'Credit Card')]")
    public WebElement creditCard;

    @FindBy(xpath = "//a[contains(.,'Loan')]")
    public WebElement loan;

    public void clickLinks(String linkName) {
        Driver.get().findElement(By.xpath("//a[contains(.,'" + linkName + "')]")).click();
    }

    public List<String> getTableHeadersList(String accountTypes) {
        List<String> headerOptions = new ArrayList<>();
        By header = By.xpath("//h2[contains(.,'" + accountTypes + "')]/following-sibling::div[1]//th");
        List<WebElement> tableHeader = Driver.get().findElements(header);
        tableHeader.forEach(table -> headerOptions.add(table.getText()));
        return headerOptions;

    }


}
