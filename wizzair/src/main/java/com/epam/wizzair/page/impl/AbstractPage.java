package com.epam.wizzair.page.impl;
import org.openqa.selenium.WebDriver;


public abstract class AbstractPage {

    protected WebDriver driver;

    public abstract void openPage();

    public AbstractPage() {
        this.driver = driver;
    }

}
