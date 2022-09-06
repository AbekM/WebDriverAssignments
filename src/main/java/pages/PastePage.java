package pages;

import base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class PastePage extends BaseUtil {

    @FindBy(xpath = "//textarea")
    private WebElement textArea;

    @FindBy(xpath = "//div[@class='left']//a")
    private WebElement selectedSyntaxArchive;

    private final By expirationResultTenMinutes =
            By.xpath("//li[contains(text(), '10 Minutes')]");

    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement postFormTitle;

    public PastePage() {
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }


    public String getPasteData() {
        return textArea.getText();
    }

    public void inputTitle() {
        postFormTitle.sendKeys(prop.getProperty("bringItOnTitle"));
    }

}