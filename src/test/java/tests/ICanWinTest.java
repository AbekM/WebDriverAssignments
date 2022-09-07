package tests;

import base.BaseUtil;
import org.testng.annotations.Test;
import pages.PasteBinHomePage;


public class ICanWinTest extends BaseUtil {
    @Test (description = "Home page opened", priority = 1)
    public void homePageOpened() {
        new PasteBinHomePage().openPage();
    }

    @Test (description = "Text inserted", priority = 2)
    public void textInput() {
        new PasteBinHomePage().inputText(prop.getProperty("iCanWinText"));
    }

    @Test (description = "Expiration Date Selected", priority = 3)
    public void selectExpirationDate() {
        new PasteBinHomePage().selectExpirationDate();
    }

    @Test (description = "Title inserted", priority = 4)
    public void inputTitle() {
        new PasteBinHomePage().inputTitle(prop.getProperty("iCanWinTitle"));
    }
}