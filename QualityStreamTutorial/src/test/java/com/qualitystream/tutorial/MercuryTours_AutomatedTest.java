package com.qualitystream.tutorial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours_AutomatedTest {
	
	private WebDriver driver;
	By registerLinkLocator = By.linkText("REGISTER");
	By authLinkLocator = By.linkText("SIGN-ON");
	By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']") ;
	
	By authPageLocator = By.xpath("//img[@src='images/mast_signon.gif']");
	
	By usernameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPasswordLocator = By.name("confirmPassword");
	
	By authUserLocator = By.name("userName");
	By passLocator = By.name("password");
 	
	By registerBtnLocator =  By.name("submit");
	By submitBtnLocator = By.name("submit");
	
	
	
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/newtours/");
	}
	
	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void registerUser() throws InterruptedException {
		driver.findElement(registerLinkLocator).click();
		Thread.sleep(2000);
		if(driver.findElement(registerLinkLocator).isDisplayed()) {
			driver.findElement(usernameLocator).sendKeys("qualityadmin");
			driver.findElement(passwordLocator).sendKeys("pass1");
			driver.findElement(confirmPasswordLocator).sendKeys("pass1");
			
			driver.findElement(registerBtnLocator).click();
		}
		else {
			System.out.print("Register pages was not found");
		}

//		List<WebElement> fonts = driver.findElements(By.tagName("font"));
//		
//		assertEquals("Note: Your user name is qualityadmin.", fonts.get(5).getText());
		
	}
	
	@Test
	public void authUser() throws InterruptedException {
		driver.findElement(authLinkLocator).click();
		Thread.sleep(2000);
		if(driver.findElement(authLinkLocator).isDisplayed()) {
			driver.findElement(authUserLocator).sendKeys("qualityadmin");
			driver.findElement(passLocator).sendKeys("pass1");
			
			
			driver.findElement(submitBtnLocator).click();
		}
	}

}
