package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");

		//Using Exact Link Text ---> linkText()
		//driver.findElement(By.linkText("Best Sellers")).click();

		//Using Partial Link text ---> partialLinkText()
		//driver.findElement(By.partialLinkText("Sellers")).click();

		// <----Capture All The Links of a Web Page--->
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println("Total Links: " + Links.size());

		// >>>Print All The Link Text & Actual href Link<<<

		// <-----Using for loop----->
		/*
		for(int i=0; i<Links.size(); i++)
		{
			System.out.println("Link Text: "+Links.get(i).getText()); //get the link text
			System.out.println("href link: "+Links.get(i).getAttribute("href")); //get the href link	
		}
		*/

		// <-----Using for...each loop----->

		for (WebElement Link : Links) {
			System.out.println("Link Text: " + Link.getText()); //get the link text
			System.out.println("href link: " + Link.getAttribute("href")); //get the href link	
		}

	}
}
