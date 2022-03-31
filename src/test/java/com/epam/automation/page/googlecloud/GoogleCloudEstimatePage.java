package com.epam.automation.page.googlecloud;

import com.epam.automation.util.helper.JSExecutor;
import com.epam.automation.util.helper.Switcher;
import com.epam.automation.page.AbstractPage;
import com.epam.automation.util.CostFormatter;
import com.epam.automation.util.TestLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudEstimatePage extends AbstractPage {

    @FindBy(xpath = "//md-card-content[@id = 'resultBlock']//div[contains(text(),'VM class')]")
    public WebElement vMClass;

    @FindBy(xpath = "//md-card-content[@id = 'resultBlock']//div[contains(text(),'Instance type')]")
    public WebElement instanceType;

    @FindBy(xpath = "//md-card-content[@id = 'resultBlock']//div[contains(text(),'Region')]")
    public WebElement region;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[8]//div[@class='md-list-item-text ng-binding cpc-cart-multiline flex']")
    public WebElement localSSD;

    @FindBy(xpath = "//md-card-content[@id = 'resultBlock']//div[contains(text(),'Commitment term')]")
    private WebElement commitmentTerm;

    @FindBy(xpath = "//md-card-content[@id = 'resultBlock']//b[contains(text(),'Total Estimated Cost')]")
    protected WebElement totalEstimateCost;

    @FindBy(xpath = "//input[@type='email']")
    protected WebElement email;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;

    @Override
    public GoogleCloudEstimatePage openPage() {
        Switcher.switchToOtherTab();
        Switcher.switchToFrame();
        return this;
    }

    public GoogleCloudEstimatePage(WebDriver driver) {
        super(driver);
    }

    public String getCommitmentTerm() {
        return commitmentTerm.getText();
    }

    public String getLocalSSD() {
        return localSSD.getText();
    }

    public String getRegion() {
        return region.getText();
    }

    public String getInstanceType () {
        return instanceType.getText();
    }

    public String getVMClass() {
        return vMClass.getText();
    }

    public String getTotalEstimatedCost() {
        return CostFormatter.receiveCostFromString(totalEstimateCost.getText());
    }

    public GoogleCloudEstimatePage sendEmail(String emailValue) {
        email.sendKeys(emailValue);
        JSExecutor.clickElement(sendEmailButton);
        TestLogger.writeMessage("Send Email button was pressed.");
        return new GoogleCloudEstimatePage(driver);
    }


}
