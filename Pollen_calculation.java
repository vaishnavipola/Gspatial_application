package Gspatial;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pollen_calculation 
{
	@Test
	public void pollen_calc() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://auth.ambeedata.com/users/login?redirectUrl=https://dashboard.gspatial.ai");
	    String parentwindow = driver.getWindowHandle();
		driver.findElement(By.id("email")).sendKeys("polavaishnavi.1813@gmail.com");
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
				List<WebElement> locations = driver.findElements(By.xpath("//div[@class='offset-md-2 col-md-6 mt-3']"));
				int no_of_locations = locations.size();
				System.out.printf("Total no of locations selected:"+no_of_locations);
				int no_of_years = 1;
				int Pollen_cal = 15*no_of_locations + 5*no_of_years;
				System.out.printf("Total cart value for pollen :"+Pollen_cal);
				driver.close();
			}
		}
	}
}
