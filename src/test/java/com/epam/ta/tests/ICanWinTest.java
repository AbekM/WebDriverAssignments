package com.epam.ta.tests;

import com.epam.ta.page.PasteBinHomePage;
import com.epam.ta.service.TestDataReader;
import org.testng.annotations.Test;


public class ICanWinTest extends CommonConditions {
    @Test (description = "Home page opened", priority = 1)
    public void ICanWinTest() {
        new PasteBinHomePage(driver)
                .openPage()
                .inputText(TestDataReader.getTestData("iCanWinText"))
                .selectExpirationDate()
                .inputTitle(TestDataReader.getTestData("iCanWinTitle"));
    }
}