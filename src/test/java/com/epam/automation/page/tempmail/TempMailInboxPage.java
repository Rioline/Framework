package com.epam.automation.page.tempmail;

import com.epam.automation.util.helper.JSExecutor;
import com.epam.automation.util.helper.Switcher;
import com.epam.automation.util.helper.Waiter;
import com.epam.automation.page.AbstractPage;
import com.epam.automation.util.CostFormatter;
import com.epam.automation.util.TestLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TempMailInboxPage extends AbstractPage {
    private final String COST_TITLE = "Estimated Monthly Cost:";

    @FindBy(xpath = "//main")
    private WebElement messagesList;

    @FindBy(xpath = "//a[contains(text(), 'Google Cloud Price Estimate')]")
    private WebElement message;

    @FindBy(xpath = "//h2[contains(text(), 'Estimated Monthly Cost:')]")
    private WebElement estimateCost;

    @Override
    public TempMailInboxPage openPage() {
        Switcher.switchToOtherTab();
        return this;
    }

    public TempMailInboxPage(WebDriver driver) {
        super(driver);
    }

    public String receiveEstimateCostFromEmail() {
        Waiter.waitUntilElementToBeVisible(messagesList);
        JSExecutor.scrollToElement(messagesList);
        Waiter.waitUntilElementToBeVisible(message);
        JSExecutor.clickElement(message);
        Waiter.waitUntilTextToBe(estimateCost, COST_TITLE);
        System.out.println(estimateCost.getText());
        TestLogger.writeMessage("Estimated cost from email was readed.");
        return CostFormatter.receiveCostFromString(estimateCost.getText());
    }


}
