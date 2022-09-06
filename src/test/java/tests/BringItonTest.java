package tests;

import base.BaseUtil;
import org.testng.annotations.Test;
import pages.HomePage;


public class BringItonTest extends BaseUtil {
    @Test (description = "Home page opened", priority = 1)
    public void homePageOpened() {
        new HomePage().openPage();
    }


}