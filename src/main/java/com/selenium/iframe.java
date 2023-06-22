package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iframe {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");

        // <-----1st iframe----->
        driver.switchTo().frame("packageListFrame"); // Here "name" of the frame is "packageListFrame" or we can use "id" if available
                                                              // or we can pass Web Element or Index of a iframe
        driver.findElement(By.linkText("org.openqa.selenium")).click();
        driver.switchTo().defaultContent(); //It will go back to main page
        Thread.sleep(3000);

        // <-----2nd iframe----->
        driver.switchTo().frame("packageFrame"); // Here "name" of the frame is "packageFrame" or we can use "id" if available
                                                         // or we can pass Web Element or Index of a iframe
        driver.findElement(By.linkText("WebDriver")).click();
        driver.switchTo().defaultContent(); //It will go back to main page
        Thread.sleep(3000);

        // <-----3rd iframe----->
        driver.switchTo().frame("classFrame"); // Here "name" of the frame is "classFrame" or we can use "id" if available
                                                        // or we can pass Web Element or Index of a iframe
        driver.findElement(By.xpath("//body[1]/header[1]/nav[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
        driver.switchTo().defaultContent(); //It will go back to main page



    }
}
