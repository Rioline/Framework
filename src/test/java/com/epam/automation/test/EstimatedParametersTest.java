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

    @Test(description = "Check Instance type")
    public void testVerifyInstanceType() {
        Instance testInstance = InstanceCreator.withCredentialsFromProperty();
        String actual = new GoogleCloudHomePage(driver)
                .openPage()
                .searchPage()
                .openCalculator()
                .switchToFrameAndSelectCompute()
                .fillFormWithData(testInstance)
                .getInstanceType();
        String expected = "n1-standard-8";
        Assert.assertTrue(actual.toLowerCase(Locale.ROOT).contains(expected.toLowerCase(Locale.ROOT)));
    }

    @Test(description = "Check Region")
    public void testVerifyRegion(){
        Instance testInstance = InstanceCreator.withCredentialsFromProperty();
        String actual = new GoogleCloudHomePage(driver)
                .openPage()
                .searchPage()
                .openCalculator()
                .switchToFrameAndSelectCompute()
                .fillFormWithData(testInstance)
                .getRegion();
        String expected = "Frankfurt";
        Assert.assertTrue(actual.toLowerCase(Locale.ROOT).contains(expected.toLowerCase(Locale.ROOT)));
    }

    @Test(description = "Check LocalSSD")
    public void testVerifyLocalSSD() {
        Instance testInstance = InstanceCreator.withCredentialsFromProperty();
        String actual = new GoogleCloudHomePage(driver)
                .openPage()
                .searchPage()
                .openCalculator()
                .switchToFrameAndSelectCompute()
                .fillFormWithData(testInstance)
                .getLocalSSD();
        String expected = "2x375 GiB";
        Assert.assertTrue(actual.toLowerCase(Locale.ROOT).contains(expected.toLowerCase(Locale.ROOT)));
    }

    @Test(description = "Check Commitment Term")
    public void testVerifyCommitmentTerm() {
        Instance testInstance = InstanceCreator.withCredentialsFromProperty();
        String actual = new GoogleCloudHomePage(driver)
                .openPage()
                .searchPage()
                .openCalculator()
                .switchToFrameAndSelectCompute()
                .fillFormWithData(testInstance)
                .getCommitmentTerm();
        String expected = "1 Year";
        Assert.assertTrue(actual.toLowerCase(Locale.ROOT).contains(expected.toLowerCase(Locale.ROOT)));
    }

}
