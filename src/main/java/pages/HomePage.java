package pages;

import base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class HomePage extends BaseUtil {

    @FindBy(xpath = "//textarea")
    public WebElement textArea;

    @FindBy(xpath = "//span[contains(@id, 'select2-postform-expiration-container')]")
    private WebElement expirationContainer;

    private final By expirationResultTenMinutes =
            By.xpath("//li[contains(text(), '10 Minutes')]");

    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement postFormTitle;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(prop.getProperty("homePageUrl"));
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    }

    public void inputText() {
        textArea.sendKeys(prop.getProperty("pasteText"));
    }

    public void selectExpirationDate() {
        expirationContainer.click();

        driver.findElement(expirationResultTenMinutes).click();
    }

    public void inputTitle() {
        postFormTitle.sendKeys(prop.getProperty("pasteTitle"));
    }

}