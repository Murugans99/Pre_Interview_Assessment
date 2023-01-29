package com.Pre_Interview_Assessment.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private static WebDriver driver;

	public HomePage(WebDriver driver1) {
		HomePage.driver = driver1;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "main")
	private WebElement search_box;

	
	@FindBy(id = "searchPostcodeButton")
	private WebElement search_btn;
	
	@FindBy(xpath = "//p[contains(text(), '5862 Hagley Road, ')]//ancestor::li[@aria-label='go to homepage for Contact Group 5th Floor,  Lyndon House 5862 Hagley Road,  Birmingham,  B16 8PE']")
	private WebElement contact_group;
	

	public WebElement getSearch_box() {
		return search_box;
	}

	public WebElement getSearch_btn() {
		return search_btn;
	}
	
	public WebElement getContact_group() {
		return contact_group;
	}
	
	

}
