package Gspatial;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tooltip
{
	@Test
	public void tooltip() throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://auth.ambeedata.com/users/login?redirectUrl=https://dashboard.gspatial.ai");
	    String parentwindow = driver.getWindowHandle();
		driver.findElement(By.id("email")).sendKeys("polavaishnavi.ise.rymec@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Ambee@13");
		driver.findElement(By.id("submit-btn")).click();
		Set <String> handle = driver.getWindowHandles();
		for(String childwindow:handle)
		{
			System.out.print(childwindow);
			if(childwindow.equals(parentwindow))
			{
				driver.switchTo().window(childwindow);
				driver.findElement(By.xpath("//div[@title='Dashboard Walkthrough']")).click();
				driver.findElement(By.xpath("//button[text()='Take a tour']")).click();
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				Thread.sleep(1000);
				driver.close();
				
			}
		}
	}

}
