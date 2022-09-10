package pages;

import base.BaseUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YopMailGeneratorPage extends BaseUtil {

    @FindBy(xpath = "///div[@id='egen']")
    public WebElement generatedEmail;
    @FindBy(xpath = "//button[@id='cprnd']")
    public WebElement copyEmailButton;
    @FindBy(xpath = "//span[text() = 'Check Inbox']")
    public WebElement checkInboxButton;


    public YopMailGeneratorPage() {
        PageFactory.initElements(driver, this);
    }

    public String generatedEmail () {
        return generatedEmail.getText();
    }
    public void copyGeneratedEmail() {
        copyEmailButton.click();
    }
    public void checkInbox() {
        checkInboxButton.click();
    }
}
