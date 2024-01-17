package Gspatial;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Minimum_cart_value<parent> 
{
	
	@BeforeTest
	public void launch() throws Exception
	{
		login_Page lg = new login_Page();
		lg.login();
	}
	
	@Test
	public void cart_value() throws InterruptedException
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
			System.out.printf("Handle is: "+childwindow);
			if(childwindow.equals(parentwindow))
			{
				driver.switchTo().window(childwindow);
				driver.findElement(By.xpath("//button[text()='Skip']")).click();   // skip button
				driver.findElement(By.xpath("/html/body/app-root/div/div/dashboard/slider/div/div[1]/div/div[2]/div/div[2]/div[1]/div[1]/button")).click();  // cart Icon button
				Thread.sleep(1000);
				WebElement Cart_Value = driver.findElement(By.xpath("//div[@class='text-end']")); // cart value
				if(Cart_Value.isDisplayed())
				{
					System.out.println("Cart value is:\n"+Cart_Value.getText());  // shows the total cart values
				}
			}
		}
	}
}
