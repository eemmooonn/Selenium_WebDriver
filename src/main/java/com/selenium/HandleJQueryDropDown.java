package com.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleJQueryDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		driver.findElement(By.xpath("//input[@id='justAnInputBox']")).click();
		
		//selectChoiceValues(driver, "choice 1");
		//selectChoiceValues(driver, "choice 1", "choice 2", "choice 2 2", "choice 6 2", "choice 6 2 3", "choice 7");
		selectChoiceValues(driver, "all");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Thread.sleep(5000);
		driver.close();
		

	}
	
	public static void selectChoiceValues(WebDriver driver, String... values)
	{
		List <WebElement> allChoices=driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		
		
		if(!values[0].equalsIgnoreCase("all"))
		{
			for(WebElement choice:allChoices)
			{
				for(String value:values)
				{
					if(choice.getText().equals(value))
					{
						choice.click();
						break;
					}
					
				}
			}
			
		}
		else
		{
			try
			{
				for(WebElement choice:allChoices)
				{
					choice.click();
				}
			}
			catch(Exception e)
			{
				
			}
			
			
				
		}
		
		
	}

}
