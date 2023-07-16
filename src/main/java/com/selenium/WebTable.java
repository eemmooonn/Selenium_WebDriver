package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.guru99.com/test/web-table-element.php");

        // <----How Many ROWs in a TABLE---->
        int numberOfRows = driver.findElements(By.xpath("//table[@class='dataTable']//tr")).size();
        System.out.println("Number of ROWs: "+numberOfRows); //27

        // <----How Many Columns in a TABLE---->
        int numberOfColumns = driver.findElements(By.xpath("//table[@class='dataTable']/thead//th")).size();
        System.out.println("Number of Columns: "+numberOfColumns); //5

        // <----How to get the Specific Row/Column data---->
        String tableData = driver.findElement(By.xpath("//table[@class='dataTable']/tbody//tr[6]/td[1]")).getText();
        System.out.println("Table Data: "+tableData);

        // <----Get all Data from the Table---->
        /*
        System.out.println("<----DATA FROM THE TABLE---->");
        for(int row=1; row<numberOfRows; row++){

            System.out.print(row+". ");
            for(int col=1; col<numberOfColumns; col++){
                String data = driver.findElement(By.xpath("//table[@class='dataTable']/tbody//tr["+row+"]/td["+col+"]")).getText();
                System.out.print(data+"     ");
            }
            System.out.println();
        }
        */

        // <----Get DATA based on the CONDITION---->
        for(int row=1; row<numberOfRows; row++)
        {
            String companyName = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+row+"]/td[1]")).getText();
            System.out.println(row+". "+companyName);
            if (companyName.equalsIgnoreCase("Central Bank")) {
                String group = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+row+"]/td[2]")).getText();
                String currentPrice = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+row+"]/td[4]")).getText();

                System.out.println("Company Name: "+companyName+"  "+"Group: "+group+"  "+"Current Price: "+currentPrice);

                break;

            }
        }


        driver.quit();
    }

    
}
