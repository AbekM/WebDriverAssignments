package com.epam.ta.tests;


import com.epam.ta.page.*;
import com.epam.ta.service.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ICanWinTest extends CommonConditions {

    @Test(description = "PasteBin home page smoke test")
    public void pasteBinPageSmokeTest(){
        new PasteBinHomePage(driver).openPage()
                .inputText(TestDataReader.getTestData("iCanWinText"))
                .selectExpirationDateTenMinutes();
        String titleToInsert = TestDataReader.getTestData("iCanWinTitle");
        new PasteBinHomePage(driver).inputTitle(titleToInsert);
        String title = new PasteBinHomePage(driver).getPateTitle();
        Assert.assertEquals(title, titleToInsert, "Titles match");
    }
}
