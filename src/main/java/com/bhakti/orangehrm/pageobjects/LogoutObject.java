package com.bhakti.orangehrm.pageobjects;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutObject {

	@FindBy(css = "a#welcome")
	private WebElement welcomeOpt;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	private WebElement logout;

	public LogoutObject(final WebDriver webDriver) {
		Objects.requireNonNull(webDriver, "WebDriver must not be null.");
		PageFactory.initElements(webDriver, this);
	}

	public void clickOnWelcome() {
		this.welcomeOpt.click();
	}

	public void clickOnLogout() {
		this.logout.click();
	}
	
	public WebElement getLogoutElement() {
		return this.logout;
	}
}
