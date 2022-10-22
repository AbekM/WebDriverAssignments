package com.epam.ta.page;

import com.epam.ta.service.TestDataReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;


public class GoogleCloudPrisingCalculatorPage extends AbstractPage {
    @FindBy(xpath = "//label[contains(text(), 'Number of instances')]/following-sibling::input")
    public WebElement instancesInput;
    @FindBy(xpath = "//label[contains(text(), 'Operating System')]/following-sibling::md-select")
    public WebElement operatingSystemContainer;
    @FindBy(xpath = "//label[contains(text(), 'Provisioning model')]/following-sibling::md-select")
    public WebElement provisioningModelContainer;
    @FindBy(xpath = "//label[contains(text(), 'Series')]/following-sibling::md-select")
    public WebElement seriesContainer;
    @FindBy(xpath = "//label[contains(text(), 'Machine type')]/following-sibling::md-select")
    public WebElement machineTypeContainer;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    public WebElement databaseLocationContainer;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.cud']")
    public WebElement committedUsageContainer;
    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    public WebElement addGPUCheckbox;
    @FindBy(xpath = "//label[contains(text(), 'Local SSD')]/following-sibling::md-select")
    public WebElement localSSDContainer;
    @FindBy(xpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    public WebElement addEstimateButton;
    private final By operatingSystemSelection =
            By.xpath("//md-option/div[contains(text(),'Free: Debian, CentOS, CoreOS, Ubuntu')]");
    private final By provisioningModelSelection =
            By.xpath("//md-option/div[contains(text(),'Regular')]");
    private final By seriesSelection =
            By.xpath("//md-option[@value='n1']");
    private final By machineTypeSelection =
            By.xpath("//md-option/div[contains(text(),'n1-standard-8')]");
    private final By gpuTypeContainer =
            By.xpath("//md-select[@ng-model='listingCtrl.computeServer.gpuType']");
    private final By gpuTypeSelector =
            By.xpath("//md-option[@value='NVIDIA_TESLA_T4']");
    private final By gpuCountContainer =
            By.xpath("//md-select[@ng-model='listingCtrl.computeServer.gpuCount']");
    private final By gpuCountSelector=
            By.xpath("//md-option[contains(@ng-repeat, 'listingCtrl.supportedGpuNumbers')]" +
                    "/div[contains(text(), '1')]");
    private final By localSsdSelector=
            By.xpath("//md-option[@ng-repeat='item in " +
                    "listingCtrl.dynamicSsd.computeServer' and @value = '2']");
    private final By databaseLocationSelector=
            By.xpath("//md-option[@region-option and @value='europe-west3' " +
                    "and @id='select_option_228']/div");
    private final By committedUsageSelector=
            By.xpath("//md-option[@value='1' and @id = 'select_option_128']/div");
    private final By regionResult=
            By.xpath("//div[@class='md-list-item-text ng-binding' " +
                    "and contains(text(), 'Region')]");
    private final By committedTermResult=
            By.xpath("//div[@class='md-list-item-text ng-binding' " +
                    "and contains(text(), 'Commitment')]");
    private final By provisioningModelResult=
            By.xpath("//div[@class='md-list-item-text ng-binding' " +
                    "and contains(text(), 'Provisioning model')]");
    private final By instanceTypeResult=
            By.xpath("//div[contains(@class, 'md-list-item-text ng-binding')" +
                    " and contains(text(), 'Instance type')]");
    private final By ssdResult=
            By.xpath("//div[contains(@class, 'md-list-item-text') " +
                    "and contains(text(), 'SSD')]");
    private final By totalEstimatedCostSelector=
            By.xpath("//b[contains(@class, 'ng-binding') " +
                    "and contains(text(), 'Total Estimated Cost')]");
    private final By emailButton=
            By.xpath("//button[@id='Email Estimate']");
    private final By sendEmailButton=
            By.xpath("//button[contains(@class, 'cpc-button') and @aria-label = 'Send Email']");
    private final By emailField=
            By.xpath("//form[@name='emailForm']//input[@ng-model='emailQuote.user.email']");
    private final By mainIframe=
            By.xpath("//devsite-iframe/iframe");
    private final By myIframe=
            By.xpath("//iframe[@id='myFrame']");
    public GoogleCloudPrisingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public GoogleCloudPrisingCalculatorPage inputInstances() {
        driver.switchTo().frame(driver.findElement(mainIframe));
        driver.switchTo().frame(driver.findElement(myIframe));
        instancesInput.click();
        instancesInput.sendKeys(TestDataReader.getTestData("hurtMePlentyNumberOfInstances"));
        return this;
    }
    public GoogleCloudPrisingCalculatorPage chooseOS() {
        operatingSystemContainer.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(operatingSystemSelection)).click();
        return this;
    }
    public GoogleCloudPrisingCalculatorPage chooseVMClass() {
        provisioningModelContainer.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(provisioningModelSelection)).click();
        return this;
    }
    public GoogleCloudPrisingCalculatorPage chooseSeries() {
        seriesContainer.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(seriesSelection)).click();
        return this;
    }
    public GoogleCloudPrisingCalculatorPage chooseInstanceType() {
        seriesContainer.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(seriesSelection)).click();
        machineTypeContainer.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(machineTypeSelection)).click();
        return this;
    }
    public GoogleCloudPrisingCalculatorPage addGpus() {
        addGPUCheckbox.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(gpuTypeContainer)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(gpuTypeSelector)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(gpuCountContainer)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(gpuCountSelector)).click();
        return this;
    }
    public GoogleCloudPrisingCalculatorPage chooseSsd() {
        localSSDContainer.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(localSsdSelector)).click();
        return this;
    }
    public GoogleCloudPrisingCalculatorPage chooseDatabaseLocation() {
        databaseLocationContainer.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(databaseLocationSelector)).click();
        return this;
    }
    public GoogleCloudPrisingCalculatorPage chooseCommittedUsage() {
        committedUsageContainer.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(committedUsageSelector)).click();
        return this;
    }
    public GoogleCloudPrisingCalculatorPage clickAddToEstimateButton() {
        addEstimateButton.click();
        return this;
    }
    public Boolean compareRegion() {
        String Result = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(regionResult)).getText();
        return Objects.equals(Result, TestDataReader.getTestData("hurtMePlentyRegion"));
    }
    public Boolean compareCommittedTerms() {
        String Result = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(committedTermResult)).getText();
        return Objects.equals(Result, TestDataReader.getTestData("hurtMePlentyCommitmentTerm"));
    }
    public Boolean compareProvisioningModel() {
        String Result = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(provisioningModelResult)).getText();
        return Objects.equals(Result, TestDataReader.getTestData("hurtMePlentyVMClass"));
    }
    public Boolean compareInstanceType() {
        String Result = driver.findElement(instanceTypeResult).getText();
        return Objects.equals(Result, TestDataReader.getTestData("hurtMePlentyInstanceType"));
    }
    public Boolean compareSsd() {
        String Result = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(ssdResult)).getText();
        return Objects.equals(Result, TestDataReader.getTestData("hurtMePlentyLocalSSD"));
    }
    public GoogleCloudPrisingCalculatorPage clickEmailButton() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(emailButton)).click();
        return this;
    }
    public GoogleCloudPrisingCalculatorPage clickSendEmailButton() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(sendEmailButton)).click();
        return this;
    }
    public GoogleCloudPrisingCalculatorPage inputCopiedEmail() {
        driver.switchTo().frame(driver.findElement(mainIframe));
        driver.switchTo().frame(driver.findElement(myIframe));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(emailField)).click();
        driver.findElement(emailField).sendKeys(Keys.CONTROL + "V");
        return this;
    }
    public String getTotalEstimatedCostText() {
        driver.switchTo().frame(driver.findElement(mainIframe));
        driver.switchTo().frame(driver.findElement(myIframe));
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(totalEstimatedCostSelector)).getText();
    }
}