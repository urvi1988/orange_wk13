package com.orangeweek13.testsuite;


import com.orangeweek13.pages.AddUserPage;
import com.orangeweek13.pages.HomePage;
import com.orangeweek13.pages.LoginPage;
import com.orangeweek13.pages.ViewSystemUsersPage;
import com.orangeweek13.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class LoginPageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test
    public void verifyUserShouldLoginSuccessFully(){
        loginPage.UsernameField("Admin");
        loginPage.PasswordField("admin123");
        loginPage.clickLoginbutton();
        String actualMsg = homePage.verifyDashboardtext();
        String expectedMsg = "Dashboard";
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome text verified");
    }
    @Test
    public void verifyThatTheLogoDisplayOnHomePage(){
        loginPage.UsernameField("Admin");
        loginPage.PasswordField("admin123");
        loginPage.clickLoginbutton();
        String actualMsg = homePage.verifyWelcomeText(); // Verify welcome Text
        String expectedMsg = "Dashboard";
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome text verified");
        homePage.verifyOrangeHRMLogo();
    }
    @Test
    public void verifyUserShouldLogOutSuccessFully(){
        loginPage.UsernameField("Admin");
        loginPage.PasswordField("admin123");
        loginPage.clickLoginbutton();
        homePage.verifyUserProfilelogo();
        homePage.clickonLogout();
        String actualMsg = loginPage.LoginpanelText();// Verify login panel Text
        String expectedMsg = "Login";
        Assert.assertEquals(actualMsg, expectedMsg, "Login Panel text verified");

    }

}





