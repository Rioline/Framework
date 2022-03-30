package com.epam.automation.page.googlecloud;

import com.epam.automation.helper.JSExecutor;
import com.epam.automation.helper.Waiter;
import com.epam.automation.model.Instance;
import com.epam.automation.page.AbstractPage;
import com.epam.automation.util.SelecterMD;
import com.epam.automation.util.TestLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudFillComputeEngine extends AbstractPage {

    @FindBy(xpath = "//input[@name = 'quantity']")
    public WebElement numberOfInstances;

    @FindBy(xpath = "//label[text()='What are these instances for?']//following::input[1]")
    public WebElement purposeOfUses;

    @FindBy(xpath = "//label[text()='Operating System / Software']//following::md-select[1]")
    public WebElement operatingSystems;

    @FindBy(xpath = "//label[text()='Machine Class']//following::md-select[1]")
    public WebElement virtualMachinesClasses;

    @FindBy(xpath = "//label[text()='Series']//following::md-select[1]")
    public WebElement series;

    @FindBy(xpath = "//label[text()='Machine type']//following::md-select[1]")
    public WebElement machineTypes;

    @FindBy(xpath = "//div[11]//md-input-container/md-checkbox")
    public WebElement addGPUs;

    @FindBy(xpath = "//label[text()='GPU type']//following::md-select[1]")
    public WebElement addGPUTypes;

    @FindBy(xpath = "//label[text()='Number of GPUs']//following::md-select[1]")
    public WebElement numberOfGPUs;

    @FindBy(xpath = "//label[text()='Local SSD']//following::md-select[1]")
    public WebElement localSSDs;

    @FindBy(xpath = "//label[text()='Committed usage']//following::md-select[1]")
    private WebElement committedUsages;

    @FindBy(xpath = "//label[text()='Datacenter location']//following::md-select-value[1]")
    public WebElement datacenterLocations;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//*[@id='email_quote']")
    public WebElement emailEstimate;

    @Override
    public AbstractPage openPage() {
        throw new RuntimeException("Cannot open compute engine page without selection Compute Engine tab.");
    }

    public GoogleCloudFillComputeEngine(WebDriver driver) {
        super(driver);
    }

    public void fillNumberOfInstances(String numberOfInstance) {
        TestLogger.writeMessage("numberOfInstance is " + numberOfInstance);
        numberOfInstances.sendKeys(numberOfInstance);
    }

        public void fillInstancesFor(String purposeOfUse) {
        TestLogger.writeMessage("purposeOfUse is " + purposeOfUse);
        purposeOfUses.sendKeys(purposeOfUse);
    }

    public void fillOperatingSystem(String operatingSystem) {
        TestLogger.writeMessage("operatingSystem is " + operatingSystem);
        new SelecterMD(operatingSystems).selectByValue(operatingSystem);
    }

    public String fillMachineClass(String virtualMachinesClass) {
        TestLogger.writeMessage("virtualMachinesClass is " + virtualMachinesClass);
        new SelecterMD(virtualMachinesClasses).selectByValue(virtualMachinesClass);
        return virtualMachinesClasses.getText();
    }

    public void fillSeries(String serie) {
        TestLogger.writeMessage("serie is " + serie);
        new SelecterMD(series).selectByValue(serie);
    }

    public void fillMachineTypes(String machineType) {
        TestLogger.writeMessage("machineType is " + machineType);
        new SelecterMD(machineTypes).selectByValue(machineType);
    }

    public void fillCommittedUsage(String committedUsage) {
        TestLogger.writeMessage("committedUsage is " + committedUsage);
        new SelecterMD(committedUsages).selectByValue(committedUsage);
    }

    public void fillDatacenterLocation(String datacenterLocation) {
        TestLogger.writeMessage("datacenterLocation is " + datacenterLocation);
        new SelecterMD(datacenterLocations).selectRegion(datacenterLocation);
    }

    public void selectAddGPU() {
        JSExecutor.clickElement(addGPUs);
    }

    public void fillGPUType(String addGPUType) {
        TestLogger.writeMessage("addGPUType is " + addGPUType);
        Waiter.waitUntilElementToBeVisible(addGPUTypes);
        new SelecterMD(addGPUTypes).selectByValue(addGPUType);
    }

    public void fillNumberOfGPUs(String numberOfGpu) {
        TestLogger.writeMessage("numberOfGpu is " + numberOfGpu);
        new SelecterMD(numberOfGPUs).selectByValue(numberOfGpu);
    }

    public void fillLocalSSDs(String localSSD) {
        TestLogger.writeMessage("localSSD is " + localSSD);
        new SelecterMD(localSSDs).selectByValue(localSSD);
    }

    public void addTOEstimate() {
        TestLogger.writeMessage("Added to estimate.");
        JSExecutor.clickElement(addToEstimateButton);
    }

    public GoogleCloudEstimatePage fillFormWithData(Instance instance) {
        fillNumberOfInstances(instance.getNumberOfInstance());
        fillInstancesFor(instance.getInstanceFor());
        fillOperatingSystem(instance.getOperatingSoftware());
        fillMachineClass(instance.getVirtualMachinesClass());
        fillSeries(instance.getSerie());
        fillMachineTypes(instance.getMachineType());
        fillCommittedUsage(instance.getCommittedUsage());
        fillDatacenterLocation(instance.getDatacenterLocations());
        selectAddGPU();
        fillGPUType(instance.getAddGPUType());
        fillNumberOfGPUs(instance.getNumberOfGpu());
        fillLocalSSDs(instance.getLocalSSD());
        addTOEstimate();
        TestLogger.writeMessage("Compute Engine form filled");
        return new GoogleCloudEstimatePage(driver);
    }
}
