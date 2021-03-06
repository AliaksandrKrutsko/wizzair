package com.epam.wizzair.page.impl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.epam.wizzair.driver.DriverSingleton.getDriver;


public abstract class AbstractPage {

    protected WebDriver driver;

    public abstract void openPage();

    public AbstractPage() {
        PageFactory.initElements(getDriver(), this);
    }

}
