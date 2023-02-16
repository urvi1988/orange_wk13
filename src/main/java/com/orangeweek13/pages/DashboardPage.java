package com.orangeweek13.pages;

import com.orangeweek13.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends Utility {
    private static final Logger log = LogManager.getLogger(DashboardPage.class.getName());

    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']")
    WebElement DashboardText;

    public String verifyDashboardText(){
        return getTextFromElement(DashboardText);
    }
}




