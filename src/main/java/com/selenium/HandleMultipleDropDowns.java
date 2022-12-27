package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleDropDowns {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.orangehrm.com/contact-sales/");

        /* 
        
        ////Approach 1
        Select noOfEmployeesDrpDwn = new Select(driver.findElement(By.name("NoOfEmployees")));
        noOfEmployeesDrpDwn.selectByVisibleText("101 - 150");
        
        Select countryDrpDwn = new Select(driver.findElement(By.name("Country")));
        countryDrpDwn.selectByVisibleText("Bangladesh");
        */

        /////Approach 2

        WebElement employeeElement = driver.findElement(By.name("NoOfEmployees"));
        WebElement countryElement = driver.findElement(By.name("Country"));

        selectOptionFromDropDown(employeeElement, "101 - 150");
        selectOptionFromDropDown(countryElement, "Bangladesh");

        Thread.sleep(5000);

        driver.close();

    }

    public static void selectOptionFromDropDown(WebElement element, String value) {
        Select drpDwn = new Select(element);

        List<WebElement> allOptions = drpDwn.getOptions();

        for (WebElement option : allOptions) {
            if (option.getText().equals(value)) {
                option.click();
                break;
            }
        }

    }

}
