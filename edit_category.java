package Gspatial;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class edit_category
{
	@Test
	public void edit() throws InterruptedException
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
			driver.findElement(By.xpath("//button[text()='Skip']")).click();   // skip button
			driver.findElement(By.xpath("/html/body/app-root/div/div/dashboard/slider/div/div[1]/div/div[2]/div/div[2]/div[1]/div[1]/button")).click();  // cart Icon button
            driver.findElement(By.xpath("/html/body/app-root/div/div/dashboard/slider/div/div[2]/div/cart/div/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/img")).click(); // edit category 
            driver.findElement(By.xpath("//div[@class='p-2 txt-medium txt-12 txt-c-f0']//small[text()=' Air Quality ']")).click();
            driver.findElement(By.xpath("//small[text()='Location']")).click();
            WebElement location = driver.findElement(By.id("input"));
			Thread.sleep(1000);
			location.sendKeys("u");
			Thread.sleep(500);
	     	
			for(int i=0;i<=4;i++)
			{
				location.sendKeys(Keys.ARROW_DOWN);
			}
			Thread.sleep(2000);
			location.sendKeys(Keys.ENTER);
			Thread.sleep(2000);       
			
            driver.findElement(By.xpath("//small[@class='txt-c-44 txt-bold txt-14 one-line']")).click(); //Time Range
            driver.findElement(By.cssSelector(".txt-14")).click();
            driver.findElement(By.xpath("//small[text()='Add to Cart']")).click();  // Add to cart button
            driver.switchTo().alert().dismiss();
            driver.findElement(By.xpath("/html/body/modal-container/div[2]/div/div/div[2]/button[2]/small")).click();
            //Javascript code for scroll down
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window,scrollBy(0,400)");
            driver.findElement(By.xpath("//small[text()='Go to Cart']")).click(); //Go to cart button
            Thread.sleep(1000);
            driver.findElement(By.xpath("//small[text()=' Console ']")).click(); // Console button 
            Thread.sleep(1000);
            driver.close();
		}
	}
}
}
