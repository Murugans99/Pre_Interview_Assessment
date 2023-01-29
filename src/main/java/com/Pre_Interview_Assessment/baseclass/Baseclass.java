package com.Pre_Interview_Assessment.baseclass;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

		public static WebDriver driver;
		public static WebDriver browserlaunch() {
			
			driver = WebDriverManager.chromedriver().create();
			driver.manage().window().maximize();
			return driver;
		}
		
		public static void launchUrl(String url) {
			
				try {
					driver.get(url);
				} catch (Exception e) {
					 
					e.printStackTrace();
				}
			
			driver.get(url);
		}
		
		public static void inputValuestoWebelement(WebElement element, String value) {
			try {
				waitforElementVisiblity(element);
				if (elementIsDisplayed(element) && elementIsEnabled(element)) {
					element.sendKeys(value);
				}
			} catch (Exception e) {
				 
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
		
		public static boolean elementIsDisplayed(WebElement element) {
			boolean displayed = false;
			try {
				displayed = element.isDisplayed();
				return displayed;
			} catch (Exception e) {
				 
				e.printStackTrace();
			}

			return displayed;
		}

		public static boolean elementIsEnabled(WebElement element) {
			try {
				boolean enabled = element.isEnabled();
				return enabled;
			} catch (Exception e) {
				 
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
		
		public static void waitforElementVisiblity(WebElement element) {
			try {
				WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(30));
				wb.until(ExpectedConditions.visibilityOf(element));
			} catch (Exception e) {
				 
				e.printStackTrace();
			}
		}


		public static void navigateTo(String url) {
			driver.navigate().to(url);
			
		}
		

		public static void implicityWait( ) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		
		
		public static void clickonWebelement(WebElement element) {
			try {
				waitforElementVisiblity(element);
				if (elementIsDisplayed(element)) {
					element.click();
				}
			} catch (Exception e) {
				 
				e.printStackTrace();
			}
		}
		
		public static void takeScreenShot(String fileName) throws IOException {
			try {
				TakesScreenshot ts = (TakesScreenshot) driver;
				File src = ts.getScreenshotAs(OutputType.FILE);
				File des = new File(System.getProperty("user.dir") + "\\ScreenShot\\" + fileName + ".png");
				FileUtils.copyFile(src, des);
			} catch (WebDriverException e) {
				 
				e.printStackTrace();
			}
		}

		
		
		
	}



