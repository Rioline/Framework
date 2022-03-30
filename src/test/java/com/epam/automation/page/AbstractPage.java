package com.epam.automation.page;

import com.epam.automation.helper.HelperInitializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected final int WAIT_TIME_OUT = 5;

    protected abstract AbstractPage openPage();

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        HelperInitializer.initHelpers(driver);
    }

}
