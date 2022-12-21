package com.epam.ta.tests;

import com.epam.ta.page.*;
import com.epam.ta.service.TestDataReader;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

        SoftAssert softAssertion = new SoftAssert();
        GoogleCloudPrisingCalculatorPage page = new GoogleCloudPrisingCalculatorPage(driver);
        softAssertion.assertEquals(page.getRegion(),
                TestDataReader.getTestData("hurtMePlentyRegion"),"Regions match");
        softAssertion.assertEquals(page.getCommittedTerms(),
                TestDataReader.getTestData("hurtMePlentyCommitmentTerm"),"Committed Terms match");
        softAssertion.assertEquals(page.getProvisioningModel(),
                TestDataReader.getTestData("hurtMePlentyVMClass"),"Provisioning Model match");
        softAssertion.assertEquals(page.getInstanceType(),
                TestDataReader.getTestData("hurtMePlentyInstanceType"),"Instance Type match");
        softAssertion.assertEquals(page.getSsd(),
                TestDataReader.getTestData("hurtMePlentyLocalSSD"),"SSD match");
    }
}
