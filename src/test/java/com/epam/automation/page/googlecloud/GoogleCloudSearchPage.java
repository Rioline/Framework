package com.epam.automation.page.googlecloud;

import com.epam.automation.page.AbstractPage;
import com.epam.automation.util.TestLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudSearchPage extends AbstractPage {
    private final String LINK_TEXT = "Google Cloud Pricing Calculator";

    @Override
    public AbstractPage openPage() {
        throw new RuntimeException("This is not the Google Cloud page!");
    }

    public GoogleCloudSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchLink() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_OUT))
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText(LINK_TEXT)));
        driver.findElement(By.linkText(LINK_TEXT))
                .click();
    }

    public GoogleCloudCalculatorPage openCalculator() {
        searchLink();
        TestLogger.writeMessage("Page " + LINK_TEXT + " is opened");
        return new GoogleCloudCalculatorPage(driver);
    }
}
