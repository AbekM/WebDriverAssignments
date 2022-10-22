package com.epam.ta.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class PastePage extends AbstractPage {
    @FindBy(xpath = "//div[contains(@class, 'source')]")
    private WebElement textArea;
    @FindBy(xpath = "//div[@class='left']//a")
    private WebElement selectedSyntaxArchive;
    private final By expirationResultTenMinutes =
            By.xpath("//li[contains(text(), '10 Minutes')]");
    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement postFormTitle;
    public PastePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public String getTitle() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver.getTitle();
    }
    public String getPasteData() {
        return textArea.getText();
    }
    public String getSyntax() {
        return selectedSyntaxArchive.getText();
    }


}