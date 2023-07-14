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

public class FLuentWaitUsingMethod {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        
        //https://www.selenium.dev/documentation/webdriver/waits/#fluentwait

        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);


        By eleLocator = By.xpath("//h3[text()='Selenium']");

        WebElement element = waitForElementWithFluentWait(driver, eleLocator);
        element.click();
        
        

    }
    public static WebElement waitForElementWithFluentWait(WebDriver driver, final By locator){
        //FluentWait Declartion
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                                .withTimeout(Duration.ofSeconds(30))
                                .pollingEvery(Duration.ofSeconds(2))
                                .ignoring(NoSuchElementException.class);
        
        //Usage of Fluent Wait
        WebElement element = wait.until(Driver -> {
            return driver.findElement(locator);
        }
        );

        return element;
    }
    
}
