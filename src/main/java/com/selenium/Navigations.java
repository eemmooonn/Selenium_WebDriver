package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigations {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.daraz.com.bd/");
		driver.get("https://bikroy.com/");
		
		driver.navigate().back();  //daraz
		driver.navigate().forward(); //bikroy
		driver.navigate().refresh();  //bikroy
		
		driver.navigate().to("https://mkbhd.com/");  //mkbhd
		
		driver.navigate().back(); //bikroy
		driver.navigate().back(); //daraz
		
	}

}
