package com.sauceddemo.pages;

import com.sauceddemo.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends TestBase {



    public HomePage(){
        PageFactory.initElements(driver,this);

    }



    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement productsSpan;

    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    WebElement leftScrollMenu;
    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    WebElement LogOutButton;


    public boolean verifyProductsSpan(){
        return productsSpan.isDisplayed();
    }

    //simple click
    public void clickLeftScrollMenu(){
        leftScrollMenu.click();
    }


    //normal click does not work because this element is side bar menu so we have to use this instead
    //for this to work we need actions that we declared in Testbase and gave it to initialization method
    public void clickLogOutButton(){
        actions.moveToElement(LogOutButton).click().perform();
    }

    // this waits for log out element to appear from left menu
    public void waitForElement(){
        wait.until(ExpectedConditions.visibilityOf(LogOutButton));
    }



}
