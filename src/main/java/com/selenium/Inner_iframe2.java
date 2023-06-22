package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Inner_iframe2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe_height");

        driver.switchTo().frame("iframeResult"); //Used iframe "id" and switched to Outer Frame
        driver.switchTo().frame(0); //Used iframe "index" and switch to Inner Frame

        String innerText = driver.findElement(By.xpath("//h1[normalize-space()='Learn to Code']")).getText();
        System.out.println("Inner Frame Text: "+innerText);

        driver.switchTo().parentFrame(); // This will switch to outer frame/parent frame of that inner frame

        String outerText = driver.findElement(By.xpath("//h1[normalize-space()='The iframe height attribute']")).getText();
        System.out.println("Outer Frame Text: "+outerText);
        
    }
}
