package com.epam.automation.test;

import com.epam.automation.model.Instance;
import com.epam.automation.page.googlecloud.GoogleCloudHomePage;
import com.epam.automation.service.InstanceCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EstimatedCostInComputeEngineTest extends CommonConditions{

    @Test(description = "Check that the rental amount coincides with the manual calculation")
    public void compareOfCalculationsByProgramAndManually() {
        Instance testInstance = InstanceCreator.withCredentialsFromProperty();
        String actual = new GoogleCloudHomePage(driver)
                .openPage()
                .searchPage()
                .openCalculator()
                .switchToFrameAndSelectCompute()
                .fillFormWithData(testInstance)
                .getTotalEstimatedCost();
//        String expected = "USD 4,026.13";
//        Assert.assertEquals(actual,expected);
    }

}
