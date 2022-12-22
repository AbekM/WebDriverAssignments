package com.epam.ta.tests;

import com.epam.ta.page.*;
import com.epam.ta.service.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BringItOnTest extends CommonConditions {

    @Test(description = "New Paste title check", priority = 1, groups = {"bringItOn"})
    public void checkInsertedCode(){
        new PasteBinHomePage(driver).openPage()
                .inputText(TestDataReader.getTestData("bringItOnText"))
                .selectSyntaxBash()
                .selectExpirationDateTenMinutes()
                .inputTitle(TestDataReader.getTestData("bringItOnTitle"));
        String title = new PasteBinHomePage(driver).createNewPaste().getTitle();
        Assert.assertEquals(title, TestDataReader.getTestData("bringItOnTitle") + " - Pastebin.com",
                "New Paste title check");
    }

    @Test(description = "Syntax is the same as chosen", dependsOnMethods = {"checkInsertedCode"})
    public void verifySyntax(){
        String syntax = new PastePage(driver).getSyntax();
        Assert.assertEquals(syntax, TestDataReader.getTestData("bringItOnSyntax"),
                "Syntax is the same as chosen");
    }

    @Test(description = "Code is the same as inserted", dependsOnMethods = {"checkInsertedCode"})
    public void verifyPaste(){
        String pasteData = new PastePage(driver).getPasteData();
        Assert.assertEquals(pasteData, TestDataReader.getTestData("bringItOnText"),
                "Code is the same as inserted");
    }
}
