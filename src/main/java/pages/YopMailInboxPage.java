package pages;

import base.BaseUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class YopMailInboxPage extends BaseUtil {

    @FindBy(xpath = "//span[text() = 'Check Inbox']")
    public WebElement mailText;


    public YopMailInboxPage() {
        PageFactory.initElements(driver, this);
    }

    public String getEmailText() {
        return  mailText.getText();
    }

}