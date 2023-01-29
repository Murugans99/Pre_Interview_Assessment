package com.Pre_Interview_Assessment.runner;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Pre_Interview_Assessment.baseclass.Baseclass;
import com.Pre_Interview_Assessment.pom.HomePage;
import com.Pre_Interview_Assessment.pom.NewsPage;

public class TestRunner extends Baseclass {
	
	HomePage home_page = null;
	NewsPage news_page = null;
	
	@BeforeSuite
	private void Browserlaunch() {
		System.out.println("browser Launch");
		driver = browserlaunch();
		launchUrl("https://osa-web.t-cg.co.uk/");
		implicityWait();
	}
	
	
	@Test
	private void search_school() throws InterruptedException {
		home_page = new HomePage(driver);
		inputValuestoWebelement(home_page.getSearch_box(), "B16 8PE");
		implicityWait();
		clickonWebelement(home_page.getSearch_btn());
		
	}
	@Test(dependsOnMethods = "search_school")
	private void news_contactGroup(){
		home_page = new HomePage(driver);
		news_page = new NewsPage(driver);
		waitforElementVisiblity(home_page.getContact_group());
		clickonWebelement(home_page.getContact_group());
		implicityWait();
		Assert.assertEquals(true, elementIsDisplayed(news_page.getNews_july()));
	}
	@Test(dependsOnMethods = "news_contactGroup")
	private void qatest_contactGroup() throws IOException {
		implicityWait();
		navigateTo("https://osa-web.t-cg.co.uk/qatest");
		implicityWait();
		takeScreenShot("qatest_error_page1");
		
		try {
			clickonWebelement(news_page.getNews_Tab());
		}
		catch (Exception e) {
			
		}
		implicityWait();
		Assert.assertEquals(true, elementIsDisplayed(news_page.getNews_july()));
		
	}
	
	@AfterSuite
	private void browser_quit() {
		driver.quit();
	}

}
