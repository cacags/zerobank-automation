package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;

public class BasePage {

    //public String expectedURL(String tabName){
      //  String pageName = tabName.toLowerCase().replace(" ", "-");
        //return "http://zero.webappsecurity.com/bank/"+pageName+".html";
    //}

    public void navigateTo(String tabName){
        Driver.get().findElement(By.xpath("//a[contains(.,'"+tabName+"')]")).click();

    }

    public String expectedURL(String tabName){

        return tabName.toLowerCase().replace(" ", "-");
    }

}
