package com.epam.ta.tests;

import com.epam.ta.page.*;
import com.epam.ta.service.TestDataReader;
import org.testng.annotations.BeforeMethod;


public class ICanWinTest extends CommonConditions {

    @BeforeMethod(description = "PasteBin home page smoke test")
    public void pasteBinPageSmokeTest(){
        new PasteBinHomePage(driver).openPage()
                .inputText(TestDataReader.getTestData("iCanWinText"))
                .selectExpirationDateTenMinutes()
                .inputTitle(TestDataReader.getTestData("iCanWinTitle"));
    }
}
