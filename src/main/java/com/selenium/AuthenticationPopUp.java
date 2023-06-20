package com.selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationPopUp {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        //driver.get("https://the-internet.herokuapp.com/basic_auth"); //This will show the popup for username & password

        // <-----Inject the "Username" & "Password" in the URL and Skip the PopUp----->
        // Syantax: driver.get("https://username:password@URL");
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

    }
    
}
