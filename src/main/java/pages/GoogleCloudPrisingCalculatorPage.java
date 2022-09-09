package pages;

import base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']//div[@class='md-icon']")
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
            By.xpath("//md-option[@value='n2']");

    private final By machineTypeSelection =
            By.xpath("//md-option/div[contains(text(),'n1-standard-8')]");

    private final By gpuTypeContainer =
            By.xpath("//md-select[@ng-model='listingCtrl.computeServer.gpuType']");

    private final By gpuTypeSelector =
            By.xpath("//md-option[@value='NVIDIA_TESLA_T4']");

    private final By gpuCountContainer =
            By.xpath("//md-select[@ng-model='listingCtrl.computeServer.gpuCount']");

    private final By gpuCountSelector=
            By.xpath("//md-select[@ng-model='listingCtrl.computeServer.gpuCount']");

    public GoogleCloudPrisingCalculatorPage() {
        PageFactory.initElements(driver, this);
    }
    

}