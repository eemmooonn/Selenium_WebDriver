package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoCompleteGooglePlaceDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.twoplugs.com/");
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		WebElement locationSearchBox = driver.findElement(By.xpath("//input[@id='autocomplete']"));

		locationSearchBox.clear();
		locationSearchBox.sendKeys("Barisal");

		String text;
		Thread.sleep(2000);

		do {
			locationSearchBox.sendKeys(Keys.ARROW_DOWN);
			text = locationSearchBox.getAttribute("value");

			if (text.equals("Barisal District, Bangladesh")) {
				locationSearchBox.sendKeys(Keys.ENTER);
				break;
			}
			Thread.sleep(2000);

		} while (!text.isEmpty());
	}

}
