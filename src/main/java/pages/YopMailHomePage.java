package pages;

import base.BaseUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class YopMailHomePage extends BaseUtil {

    @FindBy(xpath = "//b[contains(text(), 'Random Email')]")
    public WebElement randomEmailGeneratorButton;


    public YopMailHomePage() {
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(prop.getProperty("yopMailUrl"));
    }

    public void generateNewEmail() {
        randomEmailGeneratorButton.click();
    }

}