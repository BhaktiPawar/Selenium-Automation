package com.bhakti.orangehrm.loginLogoutTest;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.bhakti.orangehrm.bean.WebDriverType;
import com.bhakti.orangehrm.pageobjects.LoginPageObject;
import com.bhakti.orangehrm.pageobjects.LogoutObject;
import com.bhakti.orangehrm.utils.Environment;
import com.bhakti.orangehrm.utils.WebDriverFactory;

public class LoginLogoutTestCase {
	
	private static final Logger LOGGER = LogManager.getLogger(LoginLogoutTestCase.class);
	
	private static Environment environment;
	
	private static LoginPageObject loginPageObject;
	
	private static LogoutObject logoutObject;
	
	private static WebDriver webDriver;
	
	@BeforeClass
	public static void setUp() {
		environment = Environment.getInstance();
		
		webDriver = WebDriverFactory.get(WebDriverType.CHROME);
		
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		webDriver.get(environment.getProperty("orangehrm.url.login"));
		
		loginPageObject = new LoginPageObject(webDriver);
		
		logoutObject = new LogoutObject(webDriver);
	}
	
	@Test
	public void testLoginFunctionality() {
		loginPageObject.enterUsername("Admin");
		
		loginPageObject.enterPassword("admin123");
		
		if(loginPageObject.getLoginBtnElement().isEnabled()) {
			loginPageObject.clickLoginButton();
		} else {
			LOGGER.info("Login button is not active");
		}
	}
	
	@Test
	public void testLogoutFunctionality() {
		logoutObject.clickOnWelcome();
		
		if(logoutObject.getLogoutElement().isDisplayed()) {
			logoutObject.clickOnLogout();
		} else {
			LOGGER.info("Logout Element is not accessible!");
		}
	}
	
	@AfterClass
	public static void closeTest() {
		webDriver.close();
	}

}
