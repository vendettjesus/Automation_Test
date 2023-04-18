package com.qualitystream.tutorial;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenTesting_SWD_Test {
	
	private WebDriver driver;
	private ReadExcelFile readFile;
	private WriteExcelFile writeFile;
	private By searchBoxLocator = By.id("search_query_top");
	private By searchBtnLocator = By.name("submit_search");
	private By resultTextLocator = By.cssSelector("span.heading-counter");
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		readFile = new ReadExcelFile();
		writeFile = new WriteExcelFile();
		
		driver.get("http://automationpractice.pl/index.php");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws IOException {
		String filepath = "C:\\Users\\jesus\\Desktop\\Test.xlsx";
		
		String searchText = readFile.getCellValue(filepath, "Sheet1", 0, 0);
		
		driver.findElement(searchBoxLocator).sendKeys(searchText);
		driver.findElement(searchBtnLocator).click();
		driver.findElement(searchBoxLocator).clear();
		String resultText = driver.findElement(resultTextLocator).getText();
		
		System.out.println("Page result text: " + resultText);
		
		readFile.readExcel(filepath, "Sheet1");
		
		writeFile.writeCellValue(filepath, "Sheet1", 0, 1, resultText);
		
		readFile.readExcel(filepath, "Sheet1");
		
		
		
		String searchText2 = readFile.getCellValue(filepath, "Sheet1", 1, 0);
		
		driver.findElement(searchBoxLocator).sendKeys(searchText2);
		driver.findElement(searchBtnLocator).click();
		driver.findElement(searchBoxLocator).clear();
		String resultText2 = driver.findElement(resultTextLocator).getText();
		
		System.out.println("Page result text: " + resultText2);
		
		readFile.readExcel(filepath, "Sheet1");
		
		writeFile.writeCellValue(filepath, "Sheet1", 1, 1, resultText2);
		
		readFile.readExcel(filepath, "Sheet1");
		
		
		String searchText3 = readFile.getCellValue(filepath, "Sheet1", 2, 0);
		
		driver.findElement(searchBoxLocator).sendKeys(searchText3);
		driver.findElement(searchBtnLocator).click();
		String resultText3 = driver.findElement(resultTextLocator).getText();
		
		System.out.println("Page result text: " + resultText3);
		
		readFile.readExcel(filepath, "Sheet1");
		
		writeFile.writeCellValue(filepath, "Sheet1", 2, 1, resultText3);
		
		readFile.readExcel(filepath, "Sheet1");
	}

}
