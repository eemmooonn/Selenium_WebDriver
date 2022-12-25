package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void main(String[] args) {

		////// Using Driver Path///

		// Chrome Browser
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Selenium Web Driver\\ChromeDriver\\chromedriver.exe");
		 * WebDriver driver = new ChromeDriver(); // or ChromeDriver driver = new
		 * ChromeDriver();
		 * driver.get("https://www.mkbhd.com");
		 */

		// Edge Browser
		/*
		 * System.setProperty("webdriver.edge.driver",
		 * "C:\\Selenium Web Driver\\EdgeDriver\\msedgedriver.exe");
		 * WebDriver driver = new EdgeDriver();
		 * driver.get("https://mkbhd.com");
		 */

		/// Using WebDriverManager///

		// Chrome Browser
		/*
		 * WebDriverManager.chromedriver().setup();
		 * WebDriver driver = new ChromeDriver();
		 * driver.get("https://mkbhd.com");
		 */

		// Edge Browser
		/*
		 * WebDriverManager.edgedriver().setup();
		 * WebDriver driver = new EdgeDriver();
		 * driver.get("https://mkbhd.com");
		 */

		///// Capture Title, Current URL and Page Source of a page ////
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://mkbhd.com"); // For URL Open

		System.out.println("Title of the page: " + driver.getTitle()); // Capture the Title of the page

		System.out.println("Current URL of the page: " + driver.getCurrentUrl()); // Capture the Current URL of the page

		System.out.println("Page Surce: \n" + driver.getPageSource()); // Capture the Page Source of the page
	}

}
