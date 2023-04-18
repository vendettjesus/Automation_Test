package com.checkingLinks.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class InicioSesiónTest {

	WebDriver driver;
	By authPageLocator = By.xpath("//img[@src='/images/logo-largo.png\']");
	
	By usernameLocator = By.id("xUsuario");
	By passwordLocator = By.id("xContrasena");
	By btnSubmitLocator = By.id("btnSubmit");
	By alumnoBtnLocator = By.id("yAbierto144");
	
	CheckingLinksPage page;

	@BeforeClass
	public void beforeClass() {
		ChromeOptions cops = new ChromeOptions();
		cops.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver(cops);
		page = new CheckingLinksPage(driver);
		driver.get("http://sito.utags.edu.mx/index.jsp");
	}
	
	@Test
	public void authUser() throws InterruptedException {
		driver.findElement(authPageLocator).click();
		Thread.sleep(2000);
		if(driver.findElement(authPageLocator).isDisplayed()) {
			driver.findElement(usernameLocator).sendKeys("211352");
			driver.findElement(passwordLocator).sendKeys("fhw6nhyaeHm");
			
			
			driver.findElement(btnSubmitLocator).click();
		
		}
	}
	
	

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
