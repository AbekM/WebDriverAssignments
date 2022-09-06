package tests;

import base.BaseUtil;
import org.testng.annotations.Test;
import pages.HomePage;


public class ICanWinTest extends BaseUtil {
    @Test (description = "Home page opened", priority = 1)
    public void homePageOpened() {
        new HomePage().openPage();
    }

    @Test (description = "Home page opened", priority = 2)
    public void textInput() {
        new HomePage().inputText();
    }

    @Test (description = "Home page opened", priority = 3)
    public void selectExpirationDate() {

        new HomePage().selectExpirationDate();
    }

    @Test (description = "Home page opened", priority = 4)
    public void inputTitle() {
        new HomePage().inputTitle();
    }
}