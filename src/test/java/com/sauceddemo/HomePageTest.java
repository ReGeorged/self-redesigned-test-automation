package com.sauceddemo;

import com.sauceddemo.base.TestBase;
import com.sauceddemo.pages.HomePage;
import com.sauceddemo.pages.LoginPage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    Actions actions;



    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setup (){
        initialization();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage();
        homePage = new HomePage();
        loginPage.loginMethod();
        actions = new Actions(driver);
    }

    @Test
    public void assertProductsDisplayedTest(){
        Assert.assertTrue(homePage.verifyProductsSpan());


    }
    @Test
    public void clickOnLogoutTest() throws InterruptedException {
        homePage.clickLeftScrollMenu();
        homePage.waitForElement();
        homePage.clickLogOutButton();
        Thread.sleep(3000);

        //verify that we logged out by checking login page login and password field presence
        Assert.assertTrue(loginPage.verifyPresence());

    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
