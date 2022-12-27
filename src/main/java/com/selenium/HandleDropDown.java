package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDown {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.opencart.com/index.php?route=account/register");

		WebElement countryDrpDwnEle = driver.findElement(By.id("input-country"));

		Select countryDrpDwn = new Select(countryDrpDwnEle);

		/*
		countryDrpDwn.selectByVisibleText("Bangladesh"); //using selectByVisibleText()
		countryDrpDwn.selectByValue("18");              //using selectByValue()
		countryDrpDwn.selectByIndex(18);                //using slectByIndex()
		*/

		//Selecting option from DropDown without using methods

		List<WebElement> allOptions = countryDrpDwn.getOptions();

		for (WebElement option : allOptions) {
			if (option.getText().equals("Bangladesh")) {
				option.click();
				break;
			}
		}

	}

}
