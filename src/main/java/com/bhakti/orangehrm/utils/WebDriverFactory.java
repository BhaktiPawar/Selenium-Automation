package com.bhakti.orangehrm.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.bhakti.orangehrm.bean.WebDriverType;

public class WebDriverFactory {

	public static WebDriver get(WebDriverType webDriverType) {
		Environment environment = Environment.getInstance();

		switch (webDriverType) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", environment.getProperty("webdriver.chrome.location"));
			return new ChromeDriver();

		case IE:
			System.setProperty("webdriver.chrome.driver", environment.getProperty("webdriver.ie.location"));
			return new InternetExplorerDriver();

		case MOZILA:
			System.setProperty("webdriver.gecko.driver", environment.getProperty("webdriver.mozilla.location"));
			return new FirefoxDriver();

		default:
			System.setProperty("webdriver.chrome.driver", environment.getProperty("webdriver.chrome.location"));
			return new ChromeDriver();
		}
	}
}
