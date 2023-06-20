package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PermissionPopUpNotification {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions(); //For "Edge Browser"---> EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-notifications"); //This will disable all the "Notifications Popup"

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options); //We have to use "options" here, otherwise it won't work!
        driver.manage().window().maximize();

        driver.get("https://www.redbus.in/");
        

        /* 
        // <-----For Edge Browser----->

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-notifications");

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://www.redbus.in/");
        */
    }
}
