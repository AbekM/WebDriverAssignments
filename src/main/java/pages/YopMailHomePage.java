package pages;

import base.BaseUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.concurrent.TimeUnit;


public class YopMailHomePage extends BaseUtil {
    @FindBy(xpath = "//h3[contains(text(), 'Random Email')]")
    public WebElement randomEmailGeneratorButton;
    public YopMailHomePage() {
        PageFactory.initElements(driver, this);
    }
    public void openPage() {
        driver.get(prop.getProperty("yopMailUrl"));
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    }
    public void generateNewEmail() {
        randomEmailGeneratorButton.click();
    }
}