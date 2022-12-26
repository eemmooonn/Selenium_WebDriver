package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getTextVsgetAttribute {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://admin-demo.nopcommerce.com/login");

		WebElement emailBox = driver.findElement(By.xpath("//input[@id='Email']"));

		/*
		 * 
		 * //Enter and Clear text from input field
		 * 
		 * emailBox.clear(); //Clears text from the input field
		 * emailBox.sendKeys("test1@gmail.com"); //Enter texts to the input field
		 * emailBox.clear(); //Clears text from the input field
		 * emailBox.sendKeys("test2@gmail.com"); //Enter texts to the input field
		 * emailBox.clear(); //Clears text from the input field
		 */

		// Capture text from input field

		System.out.println("Result from getAttribute(): " + emailBox.getAttribute("value")); // This will get "value"
																								// attributes value

		System.out.println("Result from getText(): " + emailBox.getText()); // This will get nothing because for the
																			// particular element there is no inner text
																			// getText() only get inner text from an
																			// element
		WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
		System.out.println("Result from getText(): " + loginButton.getText()); // This will get "LOG IN" because this
																				// button has inner text.

		// driver.close();

	}

}
