package com.epam.ta.tests;


import com.epam.ta.page.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HurtMePlenty extends CommonConditions {

    @Test(description = "Compare Google Calculator with manual estimation")
    public void checkGoogleCalculatorResults() {
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
        Assert.assertTrue(new GoogleCloudPrisingCalculatorPage(driver).compareRegion() &
                new GoogleCloudPrisingCalculatorPage(driver).compareCommittedTerms() &
                new GoogleCloudPrisingCalculatorPage(driver).compareProvisioningModel() &
                new GoogleCloudPrisingCalculatorPage(driver).compareInstanceType() &
                new GoogleCloudPrisingCalculatorPage(driver).compareSsd());
    }
}
