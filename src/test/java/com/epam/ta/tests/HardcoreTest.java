package com.epam.ta.tests;


import com.epam.ta.page.GoogleCloudHomePage;
import com.epam.ta.page.GoogleCloudPrisingCalculatorPage;
import com.epam.ta.page.GoogleCloudSearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

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
        openNewTab();
        new YopMailHomePage().openPage();
        new YopMailHomePage().generateNewEmail();
        new YopMailGeneratorPage().copyGeneratedEmail();
        }
    @Test (description = "Paste Generated Email to the field", priority = 15)
    public void inputEmail() {
        switchToAnotherTab();
        new GoogleCloudPrisingCalculatorPage().inputCopiedEmail();
    }
    @Test (description = "Click Send Email button", priority = 15)
    public void sendEmail() {
        new GoogleCloudPrisingCalculatorPage().clickSendEmailButton();
    }
    @Test(description = "Navigate to the Inbox", priority = 16)
    public void checkEmail() {
        switchToAnotherTab();
        new YopMailGeneratorPage().checkInbox();
    }
    @Test(description = "Compare results from the mail", priority = 17)
    public void compareResults() throws InterruptedException {
        while (Objects.equals(new YopMailInboxPage().getMailCount(), "0 mail")){
            Thread.sleep(2000);
            new YopMailInboxPage().refreshPage();
        }
        String MailResult = new YopMailInboxPage().getEmailText();
        switchToAnotherTab();
        String GoogleResult = new GoogleCloudPrisingCalculatorPage().getTotalEstimatedCostText();
        GoogleResult = GoogleResult.split("USD ")[1];
        GoogleResult = GoogleResult.split(" per 1")[0];
        MailResult = MailResult.split("USD ")[1];
        Assert.assertEquals(GoogleResult, MailResult);
    }
}
