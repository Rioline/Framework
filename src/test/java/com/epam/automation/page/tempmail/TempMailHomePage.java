package com.epam.automation.page.tempmail;

import com.epam.automation.helper.JSExecutor;
import com.epam.automation.helper.Switcher;
import com.epam.automation.helper.Waiter;
import com.epam.automation.page.AbstractPage;
import com.epam.automation.util.TestLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TempMailHomePage extends AbstractPage {

    public static final String TEMP_MAIL_URL = "https://temp-mail.org";

    @FindBy(xpath = "//input[@id = 'mail']")
    private WebElement emailAddress;

    @Override
    public TempMailHomePage openPage() {
        Switcher.openNewTab();
        Waiter.waitUntilNewWindowHandleAppear();
        Switcher.switchToNewTab(TEMP_MAIL_URL);
        TestLogger.writeMessage("Page " + TEMP_MAIL_URL + " is opened");
        return this;
    }

    public TempMailHomePage(WebDriver driver) {
        super(driver);
        Switcher.switchToFrame();
    }

    public String getEmailAddress() {
        Waiter.waitUntilElementToBeVisible(emailAddress);
        JSExecutor.scrollToElement(emailAddress);
        Waiter.waitUntilEmailInValueAppears(emailAddress);
        TestLogger.writeMessage("Temp email address was received on " + TEMP_MAIL_URL);
        return emailAddress.getAttribute("value");
    }
}
