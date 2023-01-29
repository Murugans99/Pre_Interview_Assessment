package com.Pre_Interview_Assessment.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsPage {
	private static WebDriver driver;

	public NewsPage(WebDriver driver1) {
		NewsPage.driver = driver1;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[text()='News']")
	private WebElement news_tab;


	@FindBy(xpath = "//h2[text()='July 2022']")
	private WebElement news_july;
	
	public WebElement getNews_Tab() {
		return news_tab;
	}

	public WebElement getNews_july() {
		return news_july;
	}
	
	
}
