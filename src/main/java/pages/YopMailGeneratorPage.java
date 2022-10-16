package pages;

import base.BaseUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class YopMailGeneratorPage extends BaseUtil {

    @FindBy(xpath = "///div[@id='egen']")
    public WebElement generatedEmail;
    @FindBy(xpath = "//button[@id='cprnd']")
    public WebElement copyEmailButton;
    @FindBy(xpath = "//span[text() = 'Check Inbox']")
    public WebElement checkInboxButton;
    @FindBy(xpath = "//body")
    public WebElement pageBody;


    public YopMailGeneratorPage() {
        PageFactory.initElements(driver, this);
    }

    public String generatedEmail () {
        return generatedEmail.getText();
    }
    public void copyGeneratedEmail() {
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(copyEmailButton)).click();
        pageBody.sendKeys(Keys.CONTROL + "T");
    }
    public void checkInbox() {
        checkInboxButton.click();
    }
    public String getWindowHandle(){
        return driver.getWindowHandle();
    }
}
