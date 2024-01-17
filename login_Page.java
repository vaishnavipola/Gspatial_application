package Gspatial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class login_Page
{
	@BeforeTest
	public void login1() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://auth.ambeedata.com/users/login?redirectUrl=https://dashboard.gspatial.ai");
	    driver.manage().window().maximize();
	    driver.findElement(By.id("email")).sendKeys("vaishnavi@getambee.com");
	    driver.findElement(By.id("password")).sendKeys("Vaishnavi@286876");
	    driver.findElement(By.id("submit-btn")).click();
	    Thread.sleep(3000);
	    driver.close();
	}
	
	public void login()
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://auth.ambeedata.com/users/login?redirectUrl=https://dashboard.gspatial.ai");
	    String parentwindow = driver.getWindowHandle();
		driver.findElement(By.id("email")).sendKeys("vaishnavi@getambee.com");
		driver.findElement(By.id("password")).sendKeys("Ambee@2023");
		driver.findElement(By.id("submit-btn")).click();
	}
}
