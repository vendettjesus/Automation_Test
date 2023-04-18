package com.web.elements.packg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.project.pom.Base;

public class DropdownList_Page extends Base {
	
	//dropdownlist clásico - https://demo.guru99.com/test/newtours/
	By dropdownList_Passengers = By.name("passCount");
	By dropdownList_DepartingFrom = By.name("fromPort");
	
	By userLocator = By.name("userName");
	By passLocator = By.name("password");
	By signInBtnLocator = By.name("login");
	
	//dropdownlist bootstrap y react - https://react-bootstrap.github.io/components/dropdowns/
	
	public DropdownList_Page(WebDriver driver) {
		super(driver);
		//TODO Auto-generated constructor stub
	}
	
	public void signIn() {
		if (isDisplayed(userLocator)) {
			 type("qualityadmin", userLocator);
			 type("pass1", passLocator);
			 click(signInBtnLocator);
		} else {
			System.out.println("username textbox was not present");
		}
	}
	
	public String selectDropdownList_Passengers() {
		WebElement dropdownList = findElement(dropdownList_Passengers);
		List<WebElement> options = dropdownList.findElements(By.tagName("option"));
		for (int i = 0; i < options.size(); i++) {
			if(getText(options.get(i)).equals("4")) {
				click(options.get(i));
			}
		}
		
		String selectedOption = "";
		for (int i = 0; i < options.size(); i++) {
			if(options.get(i).isSelected())
				selectedOption = getText(options.get(i));
		}
		
		return selectedOption;
	}
	
	public String selectDropdownList_DepartingFrom() {
		Select selectList = new Select(findElement(dropdownList_DepartingFrom));
		selectList.selectByVisibleText("Paris");
		return getText(selectList.getFirstSelectedOption());
	}
}
