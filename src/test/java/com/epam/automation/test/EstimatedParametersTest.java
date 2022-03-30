package com.epam.automation.test;

import com.epam.automation.model.Instance;
import com.epam.automation.page.googlecloud.GoogleCloudHomePage;
import com.epam.automation.service.InstanceCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class EstimatedParametersTest extends CommonConditions{

    @Test(description = "Check VmClass")
    public void testVerifyVMClassField() {
        Instance testInstance = InstanceCreator.withCredentialsFromProperty();
        String actual = new GoogleCloudHomePage(driver)
                .openPage()
                .searchPage()
                .openCalculator()
                .switchToFrameAndSelectCompute()
                .fillFormWithData(testInstance)
                .getVMClass();
        String expected = "Regular";
        Assert.assertTrue(actual.toLowerCase(Locale.ROOT).contains(expected.toLowerCase(Locale.ROOT)));
    }

}
