package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDownWithoutSelectClass {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.hdfcbank.com/");
		
		
		//For Selecting "Product Type" from dropdown
		driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click();
		List<WebElement> productTypeOptions=driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']//li"));
		System.out.println("All the Product Type options: "+productTypeOptions.size());
		
		for(WebElement Option:productTypeOptions)
		{
			if(Option.getText().equals("Vehicle Insurance"))
			{
				Option.click();
				break;
			}
		}
		
		
		
		//For Selecting "Product" from dropdown
		driver.findElement(By.xpath("//div[@class='drp2']//div[@class='dropdown']")).click();
		List<WebElement> productOptions=driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']//li"));
		System.out.println("All the product options: "+productOptions.size());
		
		for(WebElement Option:productOptions)
		{
			if(Option.getText().equals("Two Wheeler Insurance"))
			{
				Option.click();
				break;
			}
		}
		

		
	}

}
