package com.epam.ta.page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage
{
	protected WebDriver driver;
	protected final int WAIT_TIMEOUT_SECONDS = 10;
	protected final int PAGE_LOAD_TIMEOUT = 20;
	protected final long IMPLICIT_WAIT = 20;

	protected AbstractPage(WebDriver driver)
	{
		this.driver = driver;
	}
}
