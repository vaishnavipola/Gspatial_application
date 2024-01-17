package Gspatial;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class edit_parameters_filters 
{
	@Test
	public void parameters_filters()
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://auth.ambeedata.com/users/login?redirectUrl=https://dashboard.gspatial.ai");
	    String parentwindow = driver.getWindowHandle();
		driver.findElement(By.id("email")).sendKeys("vaishnavi@getambee.com");
		driver.findElement(By.id("password")).sendKeys("Ambee@2023");
		driver.findElement(By.id("submit-btn")).click();
		Set <String> handle = driver.getWindowHandles();
		for(String childwindow:handle)
		{
			System.out.print(childwindow);
			if(childwindow.equals(parentwindow))
			{
				driver.switchTo().window(childwindow);
				driver.findElement(By.xpath("//button[text()='Skip']")).click();   // skip button
				driver.findElement(By.xpath("/html/body/app-root/div/div/dashboard/slider/div/div[1]/div/div[2]/div/div[2]/div[1]/div[1]/button")).click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window, scrollBy(0,400)");
	         	driver.findElement(By.xpath("/html/body/app-root/div/div/dashboard/slider/div/div[2]/div/cart/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div[3]/div[2]/img")).click(); // edit_parameter_button
	            List <WebElement> radio_buttons = driver.findElements(By.xpath("//label[@class='form-check-label txt-c-ee txt-18 txt-semibold']"));  // checkbsoxes xpath
	        	int r = radio_buttons.size();
	        	System.out.printf("No_of_checkboxes:"+r);
	        	
			}
		}
	}

}
