package com.epam.wizzair.page.impl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.epam.wizzair.driver.DriverSingleton.getDriver;

/**
 * Created by Aliaksandr_Krutsko on 3/7/2017.
 */
public class SeatPage extends AbstractPage {

    private WebDriverWait wait = new WebDriverWait(getDriver(), 5, 1000);

    public SeatPage() {

       // PageFactory.initElements(getDriver(), this);
    }

    @Override
    public void openPage() {

    }

    @FindBy(xpath = "//form[@name ='seat-selection']//button[@class = 'button button--medium button--filled' and text()='Continue' and @type = 'button']")
    private WebElement seatOriginContinue;

    //@FindBy(xpath = "//button[contains(@class, 'button button--medium button--filled') and text() = 'Continue']")
    @FindBy(xpath = "//form[@name ='seat-selection']//button[@class = 'button button--medium button--filled' and text()='Continue' and @type = 'submit']")
    private WebElement seatReturnContinue;


    public SeatPage continueOrigin() {
        seatOriginContinue.click();
        return this;
    }


    public SeatPage continueReturn() {

        wait.until(ExpectedConditions.elementToBeClickable(seatReturnContinue));

        seatReturnContinue.click();
        return this;

    }





}
