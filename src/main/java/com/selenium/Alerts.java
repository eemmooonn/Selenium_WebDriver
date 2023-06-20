package com.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // <-----Alert Window with "OK" Button----->
        /* 
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
        Thread.sleep(3000); //For Delay 
        driver.switchTo().alert().accept(); //It will close the alert window by clicking OK Button
        */

        // <-----Alert Window with "OK" & "Cancel" Button----->
        /* 
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
        Thread.sleep(3000); //For Delay
        //driver.switchTo().alert().accept(); //It will close the alert window by clicking "OK" Button
        driver.switchTo().alert().dismiss(); //It will close the alert window by clicking "Cancel" Button
        */

        // <-----Alert Window with "Input Box", "OK" & "Cancel" Button, Capture Text from Alert----->
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
        Alert alertWindow = driver.switchTo().alert();

        System.out.println("The Message Displayed on Alert Window: "+alertWindow.getText());
        Thread.sleep(2000); //For Delay
        alertWindow.sendKeys("Hello World"); //This will Send the Text to Alert Input Box
        Thread.sleep(2000); //For Delay
        alertWindow.accept();//It will close the alert window by clicking "OK" Button
        



    }
}
