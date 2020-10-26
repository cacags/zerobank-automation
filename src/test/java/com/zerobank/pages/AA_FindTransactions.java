package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AA_FindTransactions {
    public AA_FindTransactions(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "aa_description")
    public WebElement descriptionInbox;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(id = "aa_fromAmount")
    public WebElement fromAmount;

    @FindBy(id = "aa_toAmount")
    public WebElement toAmount;

    @FindBy(xpath = "//select[contains(@name,'type')]")
    public WebElement typeSelect;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement findButton;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//tr")
    public List<WebElement> table;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//tr//td[1]")
    public List<WebElement> dates;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//tr//td[2]")
    public List<WebElement> description;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//tr//td[3]")
    public List<WebElement> depositElements;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//tr//td[4]")
    public List<WebElement> withdrawalElements;

    public void selectType(String typeValue){
        new Select(typeSelect).selectByVisibleText(typeValue);
    }

    public int getRowNumberOfTable(){
        return table.size();
    }

    public boolean isLast(String fromDate) throws Exception{
        Date expectedDate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
        Date actualDate = new SimpleDateFormat("yyyy-MM-dd").parse(dates.get(getRowNumberOfTable()-1).getText());
        return actualDate.before(expectedDate);
    }

    public boolean isFirst(String toDate) throws Exception{
        Date expectedDate = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
        Date actualDate = new SimpleDateFormat("yyyy-MM-dd").parse(dates.get(0).getText());
        return actualDate.after(expectedDate);
    }

    public boolean isContain(String date){
        for (WebElement element : dates) {
            if(element.getText().equals(date)){
                return true;
            }
        }
        return false;
    }

    public boolean isContainDescription(String value){
        for (WebElement element : description) {
            if(!element.getText().contains(value)){
                return false;
            }
        }
        return true;
    }

    public String getMostRecentDate(){
        return dates.get(0).getText();
    }

    public boolean isDepositContainsData(){
        boolean dummy = false;
        for (WebElement depositElement : depositElements) {
            if(!depositElement.getText().equals("")){
                dummy = true;
                break;
            }
        }
        return dummy;
    }

    public boolean isWithdrawalContainsData(){
        boolean dummy = false;
        for (WebElement withdrawalElement : withdrawalElements) {
            if(!withdrawalElement.getText().equals("")){
                dummy = true;
                break;
            }
        }
        return dummy;
    }
}
