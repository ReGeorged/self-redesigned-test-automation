package com.sauceddemo.pages;

import com.sauceddemo.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    WebElement loginField;
        @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement pwordField;
    @FindBy(xpath = "//*[@id=\"login-button\"]")
    WebElement loginButton;

    public boolean verifyPresence(){
        return loginField.isDisplayed() &&pwordField.isDisplayed();
        }
    public HomePage loginMethod(){
            loginField.sendKeys(prop.getProperty("login"));
            pwordField.sendKeys(prop.getProperty("pword"));
            loginButton.click();
            return new HomePage();
    }

}