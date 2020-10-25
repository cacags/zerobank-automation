package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class PayBillsPage {
    public PayBillsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    public void navigateTo(String tabName) {
        Driver.get().findElement(By.xpath("//li[contains(.,'"+tabName+"')]")).click();

    }



}
