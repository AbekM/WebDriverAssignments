package pages;

import base.BaseUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class GoogleCloudSearchResultsPage extends BaseUtil {
    @FindBy(xpath = "//div[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']")
    public WebElement searchResultPricingCalculator;
    public GoogleCloudSearchResultsPage() {
        PageFactory.initElements(driver, this);
    }
    public void clickOnSearchResult() {
        searchResultPricingCalculator.click();
    }
}