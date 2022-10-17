package pages;

import base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class PasteBinHomePage extends BaseUtil {
    @FindBy(xpath = "//textarea")
    public WebElement textArea;
    @FindBy(xpath = "//span[contains(@id, 'select2-postform-expiration-container')]")
    private WebElement expirationContainer;
    @FindBy(xpath = "//span[@id='select2-postform-format-container']")
    private WebElement syntaxContainer;
    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement postFormTitle;
    @FindBy(xpath = "//button[contains(text(), 'Create New Paste')]")
    private WebElement createNewPasteButton;
    private final By expirationResultTenMinutes =
            By.xpath("//li[contains(text(), '10 Minutes')]");
    private final By syntaxSelectionBash =
            By.xpath("//li[contains(text(),'Bash')]");
    private final By selectedSyntaxArchive =
            By.xpath("//div[@class='left']//a");
    public PasteBinHomePage() {
        PageFactory.initElements(driver, this);
    }
    public void openPage() {
        driver.get(prop.getProperty("pasteBinURL"));
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    }
    public void inputText(String text) {
        textArea.sendKeys(text);
    }
    public void selectExpirationDate() {
        expirationContainer.click();
        driver.findElement(expirationResultTenMinutes).click();
    }
    public void selectSyntax() {
        syntaxContainer.click();
        driver.findElement(syntaxSelectionBash).click();
    }
    public void inputTitle(String title) {
        postFormTitle.sendKeys(title);
    }
    public PastePage createNewPaste() {
        createNewPasteButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(IMPLICIT_WAIT))
                .until(ExpectedConditions.presenceOfElementLocated(selectedSyntaxArchive));
        return new PastePage();
    }
}