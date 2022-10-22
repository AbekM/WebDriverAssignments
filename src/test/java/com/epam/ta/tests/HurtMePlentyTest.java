package com.epam.ta.tests;


import com.epam.ta.page.GoogleCloudHomePage;
import com.epam.ta.page.GoogleCloudPrisingCalculatorPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HurtMePlentyTest extends CommonConditions {
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
                .clickAddToEstimateButton();
    }
    @Test (description = "Compare results", priority = 2)
    public void checkResults() {
        Assert.assertTrue(new GoogleCloudPrisingCalculatorPage(driver).compareRegion() &
                new GoogleCloudPrisingCalculatorPage(driver).compareCommittedTerms() &
                new GoogleCloudPrisingCalculatorPage(driver).compareProvisioningModel() &
                new GoogleCloudPrisingCalculatorPage(driver).compareInstanceType() &
                new GoogleCloudPrisingCalculatorPage(driver).compareSsd());}
}