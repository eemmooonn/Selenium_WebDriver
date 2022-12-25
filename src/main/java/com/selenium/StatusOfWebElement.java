package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusOfWebElement {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://member.daraz.com.bd/user/register");
		
		
		WebElement searchStore = driver.findElement(By.xpath("//input[@id='q']"));
		
		// isDisplayed()
		System.out.println("Display Status: "+searchStore.isDisplayed());
		
		// isEnabled()
		System.out.println("Enabled Status: "+searchStore.isEnabled());
		
		// isSelected()  -- radio buttons, check boxes, dropdown
		
		WebElement offerCheckBox = driver.findElement(By.xpath("//input[@id='enableSmsNewsletter']"));
		
		System.out.println("Check Box: "+offerCheckBox.isSelected());
		
		offerCheckBox.click();
		
		System.out.println("Check Box: "+offerCheckBox.isSelected());
		
		
		
		
	}

}
