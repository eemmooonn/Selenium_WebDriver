package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDownWithoutSelectClassUsingMethod {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize(); //Will maximize the browser window

		driver.get("https://www.hdfcbank.com/");

		//For Selecting "Product Type" from dropdown
		driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click();
		List<WebElement> productTypeOptions = driver
				.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']//li"));
		System.out.println("All the Product Type options: " + productTypeOptions.size());

		selectOptionFromDropDown(productTypeOptions, "Vehicle Insurance"); //Calling the method

		//For Selecting "Product" from dropdown
		driver.findElement(By.xpath("//div[@class='drp2']//div[@class='dropdown']")).click();
		List<WebElement> productOptions = driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']//li"));
		System.out.println("All the product options: " + productOptions.size());

		selectOptionFromDropDown(productOptions, "Two Wheeler Insurance"); //calling the method

		Thread.sleep(5000);

		driver.close();

	}

	public static void selectOptionFromDropDown(List<WebElement> options, String value) {
		for (WebElement option : options) {
			if (option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}

}
