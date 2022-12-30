package com.selenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckDropDownListSortedOrNot {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.twoplugs.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Live Posting')]")).click();
		WebElement dropDownElement = driver.findElement(By.name("category_id"));

		Select dropDownSelect = new Select(dropDownElement);

		List<WebElement> allOptions = dropDownSelect.getOptions();

		ArrayList<String> originalList = new ArrayList<String>();
		ArrayList<String> tempList = new ArrayList<String>();

		for (WebElement option : allOptions) {
			originalList.add(option.getText()); //adding all options to ArrayList named originalList
			tempList.add(option.getText()); //adding all options to ArrayList named tempList
		}

		System.out.println("Original Options List: " + originalList);
		System.out.println("Temporary Options List: " + tempList);

		Collections.sort(tempList); //Sorting

		System.out.println("Original Options List: " + originalList);
		System.out.println("Temporary Options List After Sorting: " + tempList);

		if (originalList.equals(tempList)) //Comparing the sorted options and original options
		{
			System.out.println("Drop-Down Options are Sorted!");
		} else {
			System.out.println("Drop-Down Options are Unsorted!");
		}

		Thread.sleep(3000);

		driver.close();
	}

}
