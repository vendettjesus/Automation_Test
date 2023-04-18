package com.web.elements.packg;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class DropdownList_Test {
	
	private WebDriver driver;
	DropdownList_Page ddLPage;
	
	@Before
	public void setUp() throws Exception {
		ddLPage = new DropdownList_Page(driver);
		driver = ddLPage.chromeDriverConnection();
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ddLPage.visit("http://demo.guru99.com/test/newtours/reservation.php");
		//ddLPage.signIn();
		assertEquals(ddLPage.selectDropdownList_Passengers(),"4");
		assertEquals(ddLPage.selectDropdownList_DepartingFrom(),"Paris");
	}

}
