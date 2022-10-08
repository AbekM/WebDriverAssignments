package pages;

import base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class GoogleCloudPrisingCalculatorPage extends BaseUtil {

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

    private final By numberOfInstancesResult=
            By.xpath("//span[@class='ng-binding ng-scope']");
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
            By.xpath("//div[contains(@class, 'md-list-item-text ng-binding') " +
                    "and contains(text(), 'Instance type')]");
    private final By operatingSystemResult=
            By.xpath("//div[contains(@class, 'md-list-item-text') " +
                    "and contains(text(), 'Operating')]");
    private final By gpuResult=
            By.xpath("//div[contains(@class, 'md-list-item-text') " +
                    "and contains(text(), 'GPU')]");
    private final By totalEstimatedCostSelector=
            By.xpath("//b[contains(@class, 'ng-binding') " +
                    "and contains(text(), 'Total Estimated Cost')]");
    private final By emailButton=
            By.xpath("//button[@id='email_quote']");
    private final By mainIframe=
            By.xpath("//devsite-iframe/iframe");
    private final By myIframe=
            By.xpath("//iframe[@id='myFrame']");
    public GoogleCloudPrisingCalculatorPage() {
        PageFactory.initElements(driver, this);
    }
    public void inputInstances() {
        driver.switchTo().frame(driver.findElement(mainIframe));
        driver.switchTo().frame(driver.findElement(myIframe));
        instancesInput.click();
        instancesInput.sendKeys(prop.getProperty("hurtMePlentyNumberOfInstances"));
    }
    public void chooseOS() {
        operatingSystemContainer.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(operatingSystemSelection)).click();
    }
    public void chooseVMClass() {
        provisioningModelContainer.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(provisioningModelSelection)).click();
    }
    public void chooseSeries() {
        seriesContainer.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(seriesSelection)).click();
    }
    public void chooseInstanceType() {
        seriesContainer.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(seriesSelection)).click();
        machineTypeContainer.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(machineTypeSelection)).click();
    }
    public void addGpus() {
        addGPUCheckbox.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(gpuTypeContainer)).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(gpuTypeSelector)).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(gpuCountContainer)).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(gpuCountSelector)).click();
    }
    public void chooseSsd() {
        localSSDContainer.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(localSsdSelector)).click();
    }
    public void chooseDatabaseLocation() {
        databaseLocationContainer.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(databaseLocationSelector)).click();
    }
    public void chooseCommittedUsage() {
        committedUsageContainer.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(committedUsageSelector)).click();
    }
    public void clickAddToEstimateButton() {
        addEstimateButton.click();
    }
    public void clickEmailButton() {
        driver.findElement(emailButton).click();
    }

}