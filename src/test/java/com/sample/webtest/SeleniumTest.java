package com.sample.webtest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public class SeleniumTest {
	WebDriver driver;

	@Test(priority = 0)
	public void test_AmazonLogin() throws InterruptedException {
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		WebElement menu = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(menu).moveToElement(driver.findElement(By.xpath("//*[@id='nav-flyout-ya-signin']/a")))
				.click().build().perform();
		driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys("Venkat");
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void test_OpenCartLogin() throws InterruptedException {
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys("Venkat");
		Thread.sleep(3000);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
