package com.epam.ta.tests;


import com.epam.ta.page.*;
import com.epam.ta.service.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ICanWinTest extends CommonConditions {

    @Test(description = "PasteBin home page smoke test")
    public void pasteBinPageSmokeTest(){
        String titleToInsert = TestDataReader.getTestData("iCanWinTitle");
        new PasteBinHomePage(driver).openPage()
                .inputText(TestDataReader.getTestData("iCanWinText"))
                .selectExpirationDateTenMinutes()
                .inputTitle(titleToInsert);
        //String title = new PasteBinHomePage(driver).getPasteTitle();
        //Assert.assertEquals(new PasteBinHomePage(driver).getPasteTitle(), titleToInsert, "Titles match");
    }
}
