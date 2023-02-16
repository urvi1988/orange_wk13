package com.orangeweek13.testsuite;

import com.orangeweek13.pages.AddUserPage;
import com.orangeweek13.pages.HomePage;
import com.orangeweek13.pages.LoginPage;
import com.orangeweek13.pages.ViewSystemUsersPage;
import com.orangeweek13.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UsersTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    AddUserPage addUserPage;
    ViewSystemUsersPage viewSystemUsersPage;

    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        addUserPage = new AddUserPage();
        viewSystemUsersPage = new ViewSystemUsersPage();
    }

    @Test
    public void adminShouldAddUserSuccessFully() throws InterruptedException {
        loginPage.UsernameField("Admin");
        loginPage.PasswordField("admin123");
        loginPage.clickLoginbutton();
        homePage.clickonAdminTab();
        String actualMsg = viewSystemUsersPage.verifySystemUsertext();// Verify "System Users" Text
        String expectedMsg = "System Users";
        Assert.assertEquals(actualMsg, expectedMsg, "System Users text verified");
        viewSystemUsersPage.clickonAddbutton();
        String actualMsg1 = viewSystemUsersPage.verifyAddUserText();// Verify "Add User" Text
        String expectedMsg1 = "Add User";
        Assert.assertEquals(actualMsg, expectedMsg, "Add Users text verified");
        addUserPage.addUserrolldownmenu();
        addUserPage.addemployeenameField();
        addUserPage.addStatusDropdown();
        addUserPage.enterusername("Dominic Chase");
        addUserPage.enterpassword("Apple123@");
        addUserPage.confirmpassword("Apple123@");
        addUserPage.clickOnSavebutton();
        //verify message sucessfully saved
    }
    @Test
    public void searchTheUserCreatedAndVerifyIt() throws InterruptedException {
        loginPage.UsernameField("Admin");
        loginPage.PasswordField("admin123");
        loginPage.clickLoginbutton();
        homePage.clickonAdminTab();
        String actualMsg = viewSystemUsersPage.verifySystemUsertext(); // Verify "System Users" Text
        String expectedMsg = "System Users";
        Assert.assertEquals(actualMsg, expectedMsg, "System Users text verified");
        viewSystemUsersPage.enterusername("Dominic Chase");
        viewSystemUsersPage.StatusDropdown();
        viewSystemUsersPage.clickOnSearchButton();
        //verify user should be in result list
    }
    @Test
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() throws InterruptedException {
        loginPage.UsernameField("Admin");
        loginPage.PasswordField("admin123");
        loginPage.clickLoginbutton();
        homePage.clickonAdminTab();
        String actualMsg = viewSystemUsersPage.verifySystemUsertext();
        String expectedMsg = "System Users";
        Assert.assertEquals(actualMsg, expectedMsg, "System Users text verified");
        addUserPage.enterusername("Admin");
        viewSystemUsersPage.Userrolldown();
        viewSystemUsersPage.StatusDropdown();
        viewSystemUsersPage.clickOnSearchButton();
        //Verify the User should be in Result list.
        viewSystemUsersPage.Usercheckbox();
        viewSystemUsersPage.clickondeletebutton();
        viewSystemUsersPage.deletecompletely();
        viewSystemUsersPage.verifyRecord();
        //Click on Ok Button on Popup

    }
    @Test
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound() throws InterruptedException {
        loginPage.UsernameField("Admin");
        loginPage.PasswordField("admin123");
        loginPage.clickLoginbutton();
        homePage.clickonAdminTab();
        String actualMsg = viewSystemUsersPage.verifySystemUsertext();// Verify "System Users" Text
        String expectedMsg = "System Users";
        Assert.assertEquals(actualMsg, expectedMsg, "System Users text verified");
        addUserPage.enterusername("Admin1");
        viewSystemUsersPage.Userrolldown();
        viewSystemUsersPage.StatusDropdown();
        viewSystemUsersPage.clickOnSearchButton();
        String actualMsg1 = viewSystemUsersPage.verifyRecord(); //verify message "No Records Found"
        String expectedMsg1 = "No Record Found";
        Assert.assertEquals(actualMsg, expectedMsg, "Not Found text verified");

    }
}


