package com.bhakti.orangehrm.pageobjects;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {

	@FindBy(id = "txtUsername")
	private WebElement userName;
	
	@FindBy(id = "txtPassword")
	private WebElement password;
	
	@FindBy(id = "btnLogin")
	private WebElement loginBtn;
	
	public LoginPageObject(final WebDriver webDriver) {
		Objects.requireNonNull(webDriver, "WebDriver must not be null.");
		PageFactory.initElements(webDriver, this);
	}
	
	public void enterUsername(String userName) {
		this.userName.sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}
	
	public void clickLoginButton() {
		this.loginBtn.click();
	}
	
	public WebElement getLoginBtnElement() {
		return this.loginBtn;
	}
}
