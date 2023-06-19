package com.selenium;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrokenLinks {
    public static void main(String[] args) throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.deadlinkcity.com/");

        List<WebElement> Links = driver.findElements(By.tagName("a"));

        int noOfBrokenLink=0;
        int noOfValidLink=0;
        int noOfEmptyLink=0;

        for (WebElement element : Links) 
        {

            String urlString = element.getAttribute("href");

            if (urlString.isEmpty() || urlString == null) 
            {
                System.out.println("URL is Empty!");
                noOfEmptyLink++;
                continue;
            } 

            URL link = new URL(urlString);

            try 
            {
                HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
                httpConn.connect();

                if (httpConn.getResponseCode()>=400) 
                {
                    System.out.println("Response Code: "+httpConn.getResponseCode()+"\n"+"URL: "+urlString+"\n"+"This Link is Broken!");
                    noOfBrokenLink++;

                } 
                else 
                {
                    System.out.println("Response Code: "+httpConn.getResponseCode()+"\n"+"URL: "+urlString+"\n"+"This Link is Valid!");
                    noOfValidLink++;
                }
            } 
            catch (Exception e) 
            {
              
            }
            System.out.println();

        }
        System.out.println("No of Broken Link: "+noOfBrokenLink);
        System.out.println("No of Valid Link: "+noOfValidLink);
        System.out.println("No of Empty Link: "+noOfEmptyLink);
    }
}
