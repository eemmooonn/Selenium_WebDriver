package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropDowns_GoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Automation");

		Thread.sleep(2000);

		List<WebElement> suggestionList = driver.findElements(By.xpath("//div[@class='wM6W7d']/span"));

		System.out.println("Number of Suggestions: " + suggestionList.size());

		for (WebElement suggestion : suggestionList) {
			System.out.println(suggestion.getText());
			if (suggestion.getText().contains("automation testing")) {
				suggestion.click();
				break;
			}
		}

		Thread.sleep(3000);
		driver.close();

	}

}
