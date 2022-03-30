package com.epam.automation.test;

import com.epam.automation.model.Instance;
import com.epam.automation.page.googlecloud.GoogleCloudEstimatePage;
import com.epam.automation.page.googlecloud.GoogleCloudHomePage;
import com.epam.automation.page.tempmail.TempMailHomePage;
import com.epam.automation.page.tempmail.TempMailInboxPage;
import com.epam.automation.service.InstanceCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EstimatedCostInEmailTest extends CommonConditions {

    @Test(description = "Check calculation in Estimate and Mail.") //this fail.
    public void calculationInEstimateAndEmail() {
        Instance testInstance = InstanceCreator.withCredentialsFromProperty();
        GoogleCloudEstimatePage googleCloudEstimatePage = new GoogleCloudHomePage(driver)
                .openPage()
                .searchPage()
                .openCalculator()
                .switchToFrameAndSelectCompute()
                .fillFormWithData(testInstance);

        String email = new TempMailHomePage(driver).openPage().getEmailAddress();
        googleCloudEstimatePage.openPage().sendEmail(email);

        String totalEstimateCostInEstimatePage = new GoogleCloudEstimatePage(driver).getTotalEstimatedCost();
        String totalEstimateCostInEmailPage = new TempMailInboxPage(driver).openPage().receiveEstimateCostFromEmail();
        Assert.assertEquals(totalEstimateCostInEstimatePage, totalEstimateCostInEmailPage);
    }

}
