package Gspatial;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pollen_module 
{
	@Test
	public void pollen() throws InterruptedException
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
				driver.findElement(By.xpath("//div[@class='p-2 txt-medium txt-12 txt-c-f0']//small[text()=' Pollen ']")).click(); // Pollen button
                driver.findElement(By.xpath("//small[text()='Location']")).click();     //location button
				
				// This is for selecting 1st option from the auto suggestion  
				WebElement location = driver.findElement(By.id("input"));
				Thread.sleep(1000);
				location.sendKeys("kolkata");
				Thread.sleep(500);
		     	
				for(int i=0;i<=2;i++)
				{
					location.sendKeys(Keys.ARROW_DOWN);
				}
				Thread.sleep(2000);
				location.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//small[@class='txt-c-44 txt-bold txt-14 one-line']")).click(); //timerange button
				WebElement timestamp = driver.findElement(By.cssSelector("select.txt-c-bd"));
				Select timedropdown = new Select(timestamp);
                timedropdown.selectByValue("UTC");
                
                //Calender date pickers for start
                driver.findElement(By.xpath("//input[@placeholder='Start']")).click();  // start
                String Start_month = "January";
                String Start_year = "2023";
                
                while(true)
                {
                	String month = driver.findElement(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[2]/span")).getText();
                	System.out.println(month);
                    String year = driver.findElement(By.xpath("//span[text()='2022']")).getText();
                    System.out.println(year);
                    if(month.equals(Start_month)&&year.equals(Start_year))
                    {
                    	break;
                    }
                    else
                    {
                    	for(int i=1;i<=2;i++)
                    	{
                    		driver.findElement(By.xpath("//span[text()='‹']")).click();
                    	}
                    	   
                    }
                    driver.findElement(By.xpath("//span[contains(text(),'21')]")).click();
              
                    //calender for end_date
                    driver.findElement(By.xpath("//input[@placeholder='End']")).click();
                    String End_month = "February";
                    String End_year = "2023";
                    while(true)
                    {
                  	  String month1 = driver.findElement(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[2]/span")).getText();
                   	  System.out.println(month1);
                      String year1 = driver.findElement(By.xpath("//span[text()='2022']")).getText();
                      System.out.println(year1);
                      driver.findElement(By.xpath("//span[contains(text(),'25')]")).click(); 
                      
                      driver.findElement(By.xpath("//small[text()='Filters']")).click();    // filter button
                      driver.findElement(By.xpath("//small[text()='Add to Cart']")).click(); // Add to cart button
                      
                      //Javascript code for scroll down
                      JavascriptExecutor js = (JavascriptExecutor) driver;
                      js.executeScript("window,scrollBy(0,400)");
                      Thread.sleep(1000);
                      driver.findElement(By.cssSelector("step-button.ng-tns-c79-1 > button:nth-child(1) > span:nth-child(1) > small:nth-child(1)")).click(); // Go to cart button
                      Thread.sleep(2000);
                      driver.findElement(By.xpath("//small[text()=' Console ']")).click(); // Console button 
                      Thread.sleep(1000);
                      driver.close();
                     }
                        
                 }
             }
	     }
	}
}


