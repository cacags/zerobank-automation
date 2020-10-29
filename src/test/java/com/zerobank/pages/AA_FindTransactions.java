package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

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

    public void isBetweenTheDates(String fromDate, String toDate) throws ParseException {
        List<String> theDateList = BrowserUtils.getElementsText(dates);
        Date expectedFromDate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
        Date expectedToDate = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
        for (String textOfDates : theDateList) {
            Date actualDate = new SimpleDateFormat("yyyy-MM-dd").parse(textOfDates);
            System.out.println(actualDate);
            boolean date_1 = actualDate.compareTo(expectedToDate)==0 || actualDate.compareTo(expectedToDate)<0;
            boolean date_2 = actualDate.compareTo(expectedFromDate)==0 || actualDate.compareTo(expectedFromDate)>0;
            Assert.assertTrue(date_1);
            Assert.assertTrue(date_2);
        }

    }

    public boolean isContain(String date){
        for (WebElement element : dates) {
            if(element.getText().equals(date)){
                return true;
            }
        }
        return false;
    }

    public void isDescriptionContain(String value){

        List<String> listOfDescriptions = BrowserUtils.getElementsText(description);

        if(description.get(0).isDisplayed()){
            listOfDescriptions.forEach(text->Assert.assertTrue(text.contains(value)));
        }else{
            throw new NoSuchElementException();
        }

    }

    public void isDescriptionNotContain(String value){

        List<String> listOfDescriptions = BrowserUtils.getElementsText(description);

        if(description.get(0).isDisplayed()){
            listOfDescriptions.forEach(text->Assert.assertFalse(text.contains(value)));
        }else{
            throw new NoSuchElementException();
        }
    }

    public void isSortedByMostRecentDate() throws ParseException {
        List<String> theDateList = BrowserUtils.getElementsText(dates);
        for (int i = 0; i < theDateList.size()-1; i++) {
            Date actualDate_1 = new SimpleDateFormat("yyyy-MM-dd").parse(theDateList.get(i));
            Date actualDate_2 = new SimpleDateFormat("yyyy-MM-dd").parse(theDateList.get(i+1));
            boolean check = actualDate_1.compareTo(actualDate_2)==0 || actualDate_1.compareTo(actualDate_2)>0;
            Assert.assertTrue(check);
        }
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
