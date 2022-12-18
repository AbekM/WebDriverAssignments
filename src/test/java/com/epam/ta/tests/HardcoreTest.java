package com.epam.ta.tests;


import com.epam.ta.page.*;
import com.epam.ta.util.BrowserManipulation;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class HardcoreTest extends CommonConditions {
    @Test (description = "Home page opened", priority = 1)
    public void homePageOpened() {
        new GoogleCloudHomePage(driver)
                .openPage()
                .inputSearch()
                .clickOnSearchResult()
                .inputInstances()
                .chooseOS()
                .chooseVMClass()
                .chooseSeries()
                .chooseInstanceType()
                .addGpus()
                .chooseSsd()
                .chooseDatabaseLocation()
                .chooseCommittedUsage()
                .clickAddToEstimateButton()
                .clickEmailButton();
    }

    @Test(description = "Copy Generated Email", priority = 14)
    public void getGeneratedEmail() {
        //driver.switchTo().newWindow(WindowType.TAB);
        new BrowserManipulation().openNewTab();
        new YopMailHomePage(driver)
                .openPage()
                .generateNewEmail()
                .copyGeneratedEmail();
        }
    @Test (description = "Paste Generated Email to the field", priority = 15)
    public void inputEmail() {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        //new BrowserManipulation().switchToAnotherTab();
        new GoogleCloudPrisingCalculatorPage(driver)
                .inputCopiedEmail()
                .clickSendEmailButton();
    }

    @Test(description = "Navigate to the Inbox", priority = 16)
    public void checkEmail() {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        //new BrowserManipulation().switchToAnotherTab();
        new YopMailGeneratorPage(driver).checkInbox();
    }
    @Test(description = "Compare results from the mail", priority = 17)
    public void compareResults() throws InterruptedException {
        while (Objects.equals(new YopMailInboxPage(driver).getMailCount(), "0 mail")){
            Thread.sleep(2000);
            new YopMailInboxPage(driver).refreshPage();
        }
        String MailResult = new YopMailInboxPage(driver).getEmailText();
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        // new BrowserManipulation().switchToAnotherTab();
        String GoogleResult = new GoogleCloudPrisingCalculatorPage(driver).getTotalEstimatedCostText();
        GoogleResult = GoogleResult.split("USD ")[1];
        GoogleResult = GoogleResult.split(" per 1")[0];
        MailResult = MailResult.split("USD ")[1];
        Assert.assertEquals(GoogleResult, MailResult);
    }
}
