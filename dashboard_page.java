package Gspatial;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dashboard_page 
{
	@Test
	public void dashboard() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://auth.ambeedata.com/users/login?redirectUrl=https://dashboard.gspatial.ai");
	    String parentwindow = driver.getWindowHandle();
		driver.findElement(By.id("email")).sendKeys("Vaishnavi@getambee.com");
		driver.findElement(By.id("password")).sendKeys("Vaishnavi@286876");
		driver.findElement(By.id("submit-btn")).click();
		Set <String> handle = driver.getWindowHandles();
		for(String childwindow:handle)
		{
			System.out.print(childwindow);
			if(childwindow.equals(parentwindow))
			{
				driver.switchTo().window(childwindow);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[text()='Skip']")).click();
				Thread.sleep(3000);
				driver.close();
			}
		}
	}
}
	
		
