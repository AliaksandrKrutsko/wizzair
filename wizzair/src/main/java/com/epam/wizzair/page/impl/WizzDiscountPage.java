package com.epam.wizzair.page.impl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.epam.wizzair.driver.DriverSingleton.getDriver;


public class WizzDiscountPage extends AbstractPage {
    public WizzDiscountPage() {
        //super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    @Override
    public void openPage() {

    }

    @FindBy(css = "[data-test=\"booking-wdc-submit\"")
    private WebElement decline;


    public WizzDiscountPage declineOffer() {
        decline.click();
        return this;
    }


}
