package com.epam.automation.page.googlecloud;

import com.epam.automation.page.AbstractPage;
import com.epam.automation.util.TestLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private static final String SEARCH_QUERY = "Google Cloud Pricing Calculator";

    @FindBy(name = "q")
    public WebElement searchInput;

    @Override
    public GoogleCloudHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        TestLogger.writeMessage("Page " + HOMEPAGE_URL + " is opened");
        return this;
    }

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudSearchPage searchPage() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_OUT)).until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.click();
        searchInput.sendKeys(SEARCH_QUERY);
        searchInput.submit();
        TestLogger.writeMessage("Search with search query " + SEARCH_QUERY + "was executed.");
        return new GoogleCloudSearchPage(driver);
    }
}