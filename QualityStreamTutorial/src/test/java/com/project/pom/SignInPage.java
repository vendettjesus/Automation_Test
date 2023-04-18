package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends Base {
	
	
	By authPageLocator = By.xpath("//img[@src='images/banner2.gif']");
	
	By authUserLocator = By.name("userName");
	By passLocator = By.name("password");
 	
	By submitBtnLocator = By.name("submit");
	By authLinkLocator = By.linkText("SIGN-ON");
	
	public SignInPage(WebDriver driver) {
		super(driver);
	}
	
	public void signIn() {
		if (isDisplayed(authUserLocator)) {
			type("qualityadmin", authUserLocator);
			type("pass1", passLocator);
			click(submitBtnLocator);
		}else {
			System.out.println("username textbox was not present");
		}
	}
	
	public boolean isHomePageDisplayed() {
		return isDisplayed(authPageLocator);
	}
	
	

}
