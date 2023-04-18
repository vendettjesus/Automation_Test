package com.reportExample.qs;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class SearchSummerDresses {
	WebDriver driver;
	By searchBoxLocator = By.id("search_query_top");
	By resultsLocator = By.cssSelector("span.heading-counter");

	@BeforeClass
	public void beforeClass() {
		ChromeOptions cops = new ChromeOptions();
		cops.addArguments("--remote-allow-origins=*");

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver(cops);
		driver.manage().window().maximize();
		driver.get("http://automationpractice.pl/index.php");
	}

	@Test
	public void search_SummerDresses() {
		WebElement searchbox = driver.findElement(searchBoxLocator);
		searchbox.clear();
		searchbox.sendKeys("summer dresses");
		searchbox.submit();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.presenceOfElementLocated(resultsLocator));

		System.out.println("This is the result number: " + driver.findElement(resultsLocator).getText());
		
		assertEquals(driver.findElement(resultsLocator).getText(), "4 results have been found.");
		

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}


}
