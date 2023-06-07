package com.selenium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindows {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.opencart.com/index.php?route=cms/demo");

        /* 
        ///getWindowHandle()///
        String windowId = driver.getWindowHandle(); //Return the ID of the single browser window.
        System.out.println("Window ID: " + windowId);
        */

        ///getWindowsHandles()///
        driver.findElement(By.xpath("//span[text()='View Store Front']")).click(); //Opens Another
        																		   //Browser Window
        
        Set<String> windowIDs = driver.getWindowHandles(); //Returns IDs of multiple browser windows

        //<---  First Method -- iterator() --->
        /*Iterator<String> it = windowIDs.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();

        System.out.println("Parent Window ID: " + parentWindowId);
        System.out.println("Child Window ID: " + childWindowId);
        */
        
        
        //<---  Second Method -- List/ArrayList --->
        List<String> windowIDsList = new ArrayList<String>(windowIDs); //Converting Set --> List
        
        /*
        String parentWindowId = windowIDsList.get(0); //Parent Window ID
        String childWindowId = windowIDsList.get(1);  //Child Window ID

        System.out.println("Parent Window ID: " + parentWindowId);
        System.out.println("Child Window ID: " + childWindowId); 
        */
        
        /*
        //<---  Use Window ID's for Switching  ---> 
        
        Thread.sleep(5000); //Delay for Visualize the Switching
        
        driver.switchTo().window(parentWindowId);
        System.out.println("Title of the Parent Window: "+driver.getTitle());
        
        Thread.sleep(3000); //Delay for Visualize the Switching
        
        driver.switchTo().window(childWindowId);
        System.out.println("Title of the Child Window: "+driver.getTitle());
        */
        
        
        //<---   Overall Simplification using for...each Loop   --->
        /*
        for(String windowID:windowIDsList) // Here I used converted "windowIDsList" from above↑
        {
        	System.out.println("Window ID: "+windowID); 
        	driver.switchTo().window(windowID);  // or String title = driver.switchTo().window(windowID).getTitle();
        	                                     // for directly capturing the Title
        	System.out.println("Title: "+driver.getTitle());
       
        	System.out.println();
        	Thread.sleep(3000);
        }
        */
        
        //<--- Window Close --->
    
        //driver.close(); //This will close the single window whichever
        				  //the driver is currently pointing
        
        //driver.quit();  //This will close all the windows
        
        for(String windowID:windowIDsList) // Here I used converted "windowIDsList" from above↑
        {
        	System.out.println("Window ID: "+windowID);
        	String title = driver.switchTo().window(windowID).getTitle();       
        	System.out.println("Title: "+title);
        	
        	if(title.equals("Your Store"))
        	{
        		driver.close();  //if the title matches the mentioned title 
        						//then only that specific window will be closed
        	}
        	
        	Thread.sleep(3000);
        }

    }

}
