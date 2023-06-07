package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class findElementVsfindElements {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.daraz.com.bd/");

		// findElemnt() --> Return the single WebElement

		WebElement element = driver.findElement(By.xpath("//input[@id='q']"));
		element.sendKeys("iPhone 11");

		WebElement searchButton = driver.findElement(By.xpath("//button[contains(text(),'SEARCH')]"));
		searchButton.click();

		WebElement elem = driver.findElement(By.xpath("//div[@class='drz-footer-inner']//li[@class='footer-li']")); // This xpath is for
																								// multiple elements,
																								// but it will capture
																								// only first element
		System.out.println("Element text is: " + elem.getText());

		/*
		 * WebElement
		 * elemException=driver.findElement(By.xpath("//button[contains(text(),'EMON')]"
		 * )); //This xpath find 0 elemnts, thats why it will through
		 * "NoSuchElementFoundException"
		 * System.out.println("Element text is: "+elemException.getText());
		 */

		// findElements() --> Return multiple WebElement

		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='drz-footer-inner']//li[@class='footer-li']"));
		System.out.println("Number of WebElements: " + elements.size());

		for (WebElement ele : elements) {
			System.out.println(ele.getText());
		}

		List<WebElement> elementsZero = driver.findElements(By.xpath("//button[contains(text(),'EMON')]")); // This
																											// did't
																											// shows
																											// exception
																											// like
																											// findElement(),
																											// instead
																											// it
																											// returns 0
		System.out.println("Elemets Captured: " + elementsZero.size());

		driver.close();

	}

}
