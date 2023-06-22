package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Inner_iframe {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.automationtesting.in/Frames.html");

        driver.findElement(By.xpath("//a[contains(text(),'Iframe with in an Iframe')]")).click();

        // <-----Switch to outer iframe----->
        WebElement outerFrame = driver.findElement(By.xpath("//*[@id='Multiple']/iframe"));
        driver.switchTo().frame(outerFrame); //Assigned frame as a WebElement

        // <-----Switch to inner iframe----->
        WebElement innerFrame = driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
        driver.switchTo().frame(innerFrame);

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello World");


    }
    
}
