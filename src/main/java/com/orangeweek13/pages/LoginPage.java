package com.orangeweek13.pages;


import com.orangeweek13.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends Utility {
    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "username")
     WebElement Usernamefield;
    @FindBy(name = "password")
    WebElement Passwordfield;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement LoginButton;
    @FindBy(xpath = "//div[@class='orangehrm-login-form']")
    WebElement LoginPanel;
    @FindBy(xpath="//h5[text()='Login']")
    WebElement LoginPanelText;

    public void UsernameField(String Username){
        sendTextToElement(Usernamefield,Username);
    }
    public void PasswordField(String Password){
        sendTextToElement(Passwordfield,Password);
    }
    public void clickLoginbutton(){
        clickOnElement(LoginButton);
    }
    public String LoginPanelForm(){
        return getTextFromElement(LoginPanel);
    }
    public String LoginpanelText(){
        return getTextFromElement(LoginPanelText);
    }

}
