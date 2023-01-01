package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckBox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://itera-qa.azurewebsites.net/home/automation");

		///Select Specific Check-Box///
		//driver.findElement(By.id("monday")).click();

		List<WebElement> allCheckBoxOption = driver
				.findElements(By.xpath("//input[@type='checkbox' and contains(@id, 'day')]"));

		/*
		///Select All Check-Boxes///
		
		//Using for loop
		for(int i=0; i<allCheckBoxOption.size(); i++)
		{
			allCheckBoxOption.get(i).click();		
		}
		
		//Using for..each loop
		for(WebElement checkBoxOption:allCheckBoxOption)
		{
			checkBoxOption.click();
		}*/

		/* 
		///Select Multiple Check-Boxes by Choice (Tuesday and Saturday)///
		String checkBoxText;
		
		for (WebElement checkBoxOption : allCheckBoxOption) {
			checkBoxText = checkBoxOption.getAttribute("id");
		
			if (checkBoxText.equals("tuesday") || checkBoxText.equals("saturday")) {
		
				checkBoxOption.click();
			}
		}*/

		/* 
		///Select Last Two Check-Box///
		int size = allCheckBoxOption.size();
		
		for (int i = size - 2; i < size; i++) {
			allCheckBoxOption.get(i).click();
		}*/

		/*
		///Select First Two Check-Box///
		int size = allCheckBoxOption.size();
		for (int i = 0; i < 2; i++) {
			allCheckBoxOption.get(i).click();
		}*/

	}

}
