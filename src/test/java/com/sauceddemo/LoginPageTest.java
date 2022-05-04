package com.sauceddemo;

import com.sauceddemo.base.TestBase;
import com.sauceddemo.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v85.log.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    static LoginPage loginPage;

    public LoginPageTest(){
        super();
    }


    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        // (we would do this if class didnt extend loginPage and instead it extended TestBase
        // loginPage.checkFieldsPresence();
    }
    @Test
    public void checkFieldsPresenceTest() {
        //Assert.assertTrue(loginPage.checkFieldsPresence());
        //Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"user-name\"]")).isDisplayed());
        Assert.assertTrue(loginPage.verifyPresence());
    }

    @Test
    public void loginTest() throws InterruptedException {
        loginPage.loginMethod();
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
