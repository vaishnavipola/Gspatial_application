package Gspatial;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class cart_delete_button 
{
	@Test
	public void cart_delete() throws InterruptedException
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
			System.out.printf("Handle is: "+childwindow);
			if(childwindow.equals(parentwindow))
			{
				driver.switchTo().window(childwindow);
				driver.findElement(By.xpath("//button[text()='Skip']")).click();   // skip button
				driver.findElement(By.xpath("/html/body/app-root/div/div/dashboard/slider/div/div[1]/div/div[2]/div/div[2]/div[1]/div[1]/button")).click();  // cart Icon button
				driver.findElement(By.xpath("//img[@class='ms-3 mt-1 img-fluid cursor']")).click(); //delete icon in cart
				Thread.sleep(1000);
				driver.switchTo().alert().accept();
				//driver.findElement(By.id("//small[text()='Proceed']")).click();
				
			}
		}
	}

}
