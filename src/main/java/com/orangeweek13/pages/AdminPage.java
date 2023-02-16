package com.orangeweek13.pages;

import com.orangeweek13.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends Utility {
    private static final Logger log = LogManager.getLogger(AdminPage.class.getName());

    public AdminPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@class='oxd-topbar-body-nav-tab --parent --visited']")
    WebElement UserManagementTab;
    @FindBy(xpath = "div[@class='oxd-topbar-body']/nav/ul/li[2]")
    WebElement JobTab;
    @FindBy(xpath = "div[@class='oxd-topbar-body']/nav/ul/li[3]")
    WebElement OrganizationTab;

    public void usermanagementDropdownTab(String user){
        selectByVisibleTextFromDropDown(UserManagementTab,user);
    }
    public void JobtabDropdownTab(String job ) {
        selectByVisibleTextFromDropDown(JobTab, job);
    }
    public void OrganizationtabDropdowntab(String organization){
        selectByVisibleTextFromDropDown(OrganizationTab,organization);
    }





}
