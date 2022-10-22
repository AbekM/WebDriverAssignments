package com.epam.ta.util;


import com.epam.ta.tests.CommonConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class BrowserManipulation extends CommonConditions {
    protected WebDriver driver;


    public void openNewTab(){
        driver.switchTo().newWindow(WindowType.TAB);
    }
    public void switchToAnotherTab(){
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
