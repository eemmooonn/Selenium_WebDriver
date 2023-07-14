package com.selenium;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class FLuentWait {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver Driver = new ChromeDriver();

        Driver.manage().window().maximize();
        

        //https://www.selenium.dev/documentation/webdriver/waits/#fluentwait

        //FluentWait Declartion
        Wait<WebDriver> wait = new FluentWait<WebDriver>(Driver)
                                .withTimeout(Duration.ofSeconds(30))
                                .pollingEvery(Duration.ofSeconds(5))
                                .ignoring(NoSuchElementException.class);

        
        Driver.get("https://www.google.com/");
        Driver.findElement(By.name("q")).sendKeys("Selenium");
        Driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

        
        //Usage of Fluent Wait
        WebElement element = wait.until(driver -> {
            return Driver.findElement(By.xpath("//h3[text()='Selenium']"));
        }
        );

        element.click();



    }
    
}
