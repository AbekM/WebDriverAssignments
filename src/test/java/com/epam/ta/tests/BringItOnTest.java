package com.epam.ta.tests;

import com.epam.ta.page.PasteBinHomePage;
import com.epam.ta.service.TestDataReader;
import org.testng.annotations.Test;
import com.epam.ta.page.PastePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;


public class BringItOnTest extends CommonConditions {
    @Test (description = "Home page opened", priority = 1)
    public void titlesComparison() {
        String Title = new PasteBinHomePage(driver)
                .openPage()
                .inputText(TestDataReader.getTestData("bringItOnText"))
                .selectSyntax()
                .selectExpirationDate()
                .inputTitle(TestDataReader.getTestData("bringItOnTitle"))
                .createNewPaste()
                .getTitle();
        assertThat(Title, is(equalTo(TestDataReader.getTestData("bringItOnTitle") + " - Pastebin.com")));
    }

    @Test (description = "Syntax is the same as chosen", priority = 2)
    public void syntaxVerification() {
        String Syntax = new PastePage(driver).getSyntax();
        assertThat(Syntax, is(equalTo(TestDataReader.getTestData("bringItOnSyntax"))));
    }

    @Test (description = "Code is the same as inserted", priority = 3)
    public void pasteVerification() {
        String PasteData = new PastePage(driver).getPasteData();
        assertThat(PasteData, is(equalTo(TestDataReader.getTestData("bringItOnText"))));
    }
}