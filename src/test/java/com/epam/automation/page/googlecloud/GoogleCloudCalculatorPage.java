package com.epam.automation.page.googlecloud;

import com.epam.automation.util.helper.Switcher;
import com.epam.automation.page.AbstractPage;
import com.epam.automation.util.TestLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudCalculatorPage extends AbstractPage {

    @FindBy(css = ".md-ink-ripple[aria-controls='tab-content-1']")
    protected WebElement computeEngine;

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("This is not calculator page.");
    }

    protected GoogleCloudCalculatorPage(WebDriver driver) {
        super(driver);
    }

    protected void selectComputeEngine() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_OUT))
                .until(ExpectedConditions.visibilityOf(computeEngine));
        computeEngine.click();
    }

    public GoogleCloudFillComputeEngine switchToFrameAndSelectCompute() {
        Switcher.switchToFrame();
        selectComputeEngine();
        TestLogger.writeMessage("Page with calculator is opened");
        return new GoogleCloudFillComputeEngine(driver);
    }
}
