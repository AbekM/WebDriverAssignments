package com.epam.ta.page;

import com.epam.ta.service.TestDataReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class PasteBinHomePage extends AbstractPage {

    @FindBy(xpath = "//textarea")
    public WebElement textArea;
    @FindBy(id = "select2-postform-expiration-container")
    private WebElement expirationContainer;
    @FindBy(xpath = "//span[@id='select2-postform-format-container']")
    private WebElement syntaxContainer;
    @FindBy(xpath = "postform-name")
    private WebElement postFormTitle;
    @FindBy(xpath = "//button[contains(text(), 'Create New Paste')]")
    private WebElement createNewPasteButton;
    private final By expirationResultTenMinutes =
            By.xpath("//li[contains(text(), '10 Minutes')]");
    private final By syntaxSelectionBash =
            By.xpath("//li[contains(text(),'Bash')]");
    private final By selectedSyntaxArchive =
            By.xpath("//div[@class='left']//a");

    public PasteBinHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public PasteBinHomePage openPage() {
        driver.get(TestDataReader.getTestData("pasteBinURL"));
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        return this;
    }

    public PasteBinHomePage inputText(String text) {
        textArea.sendKeys(text);
        return this;
    }

    public PasteBinHomePage selectExpirationDateTenMinutes() {
        expirationContainer.click();
        driver.findElement(expirationResultTenMinutes).click();
        return this;
    }

    public PasteBinHomePage selectSyntaxBash() {
        syntaxContainer.click();
        driver.findElement(syntaxSelectionBash).click();
        return this;
    }

    public void inputTitle(String title) {
        postFormTitle.sendKeys(title);
    }

    public String getPasteTitle() {
        return postFormTitle.getText();
    }

    public PastePage createNewPaste() {
        createNewPasteButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(IMPLICIT_WAIT))
                .until(ExpectedConditions.presenceOfElementLocated(selectedSyntaxArchive));
        return new PastePage(driver);
    }
}