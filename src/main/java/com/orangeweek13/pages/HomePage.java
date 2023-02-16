package com.orangeweek13.pages;

import com.orangeweek13.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='oxd-brand-banner']/img")
    WebElement OrangeHRMlogo;
    @FindBy(xpath = "//nav[@class='oxd-navbar-nav']/div[2]/ul/li[1]")
    WebElement Admintab;
    @FindBy(xpath = "//div[@class='oxd-sidepanel-body']/ul/li[2]")
    WebElement PIMtab;
    @FindBy(xpath = "//div[@class='oxd-sidepanel-body']/ul/li[3]")
    WebElement Leavetab;
    @FindBy(xpath = "//div[@class='oxd-sidepanel-body']/ul/li[3]")
    WebElement Dashboardtab;
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    WebElement WelcomeText;
    @FindBy(xpath = "//div[@class='oxd-topbar-header-userarea']/ul/li/span//img[@alt='profile picture']")
    WebElement Userprofilelogo;
    @FindBy(xpath = "//div[@class='oxd-topbar-header-userarea']/ul/li/ul/li[4]//a[@href='/web/index.php/auth/logout']" )
    WebElement logout;

    @FindBy(xpath = "//div[@class='oxd-topbar-header']/div//h6[text()='Dashboard']")
    WebElement DashboardText;

    public String verifyOrangeHRMLogo(){
        return getTextFromElement(OrangeHRMlogo);
    }
    public void clickonAdminTab(){
        clickOnElement(Admintab);
        log.info("click on Admintab"+ Admintab);
    }
    public void clickonPIMTab() {
        clickOnElement(PIMtab);
        log.info("click on PIMtab"+PIMtab);
    }
    public void clickonLeaveTab(){
        clickOnElement(Leavetab);
        log.info("click on Leavetab"+ Leavetab);
    }
    public void clickonDashboardTab(){
        clickOnElement(Dashboardtab);
        log.info("click on DashboardTab");
    }
    public String verifyWelcomeText() {
        return getTextFromElement(WelcomeText);
    }
    public void verifyUserProfilelogo() {
        clickOnElement(Userprofilelogo);
    }
    public void clickonLogout(){
        clickOnElement(logout);
    }
    public String verifyDashboardtext() {
        return getTextFromElement(DashboardText);
    }
}
