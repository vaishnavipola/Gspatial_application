package Gspatial;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class edit_timeline 
{
	@Test
	public void timeline() throws InterruptedException
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
				driver.findElement(By.xpath("/html/body/app-root/div/div/dashboard/slider/div/div[1]/div/div[2]/div/div[2]/div[1]/div[1]/button")).click();  // cart Icon button
                driver.findElement(By.xpath("/html/body/app-root/div/div/dashboard/slider/div/div[2]/div/cart/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/img")).click(); //edit timeline button
              //To select the time range (i.e., start and end)
				WebElement strcur_up = driver.findElement(By.xpath("//div[@style='margin-bottom: -13px;']"));
				for(int i=0;i<=6;i++)
				{
					strcur_up.click();
				}
				
				WebElement endcur_dwn = driver.findElement(By.xpath("/html/body/app-root/div/div/dashboard/slider/div/div[1]/div/div[2]/div/div[1]/selection/div[1]/div[2]/time-range/div/div[1]/div[3]/div/div[2]/div/div/div/div[2]/img"));
				for(int j=0;j<=4;j++)
				{
					endcur_dwn.click();
				}
				
				//Dropdown to select the timestamp (eg: UTC , Greenwich)
				
				WebElement timestamp = driver.findElement(By.cssSelector("select.txt-c-bd"));
				Select timedropdown = new Select(timestamp);
                timedropdown.selectByValue("Asia/Gaza");
                
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
                    	for(int i=1;i<=7;i++)
                    	{
                    		driver.findElement(By.xpath("//span[text()='‹']")).click();
                    	}
                    	   
                    }
                    driver.findElement(By.xpath("//span[contains(text(),'21')]")).click();
//               
                    //calender for end_date
                    driver.findElement(By.xpath("//input[@placeholder='End']")).click();
                    String End_month = "February";
                    String End_year = "2023";
                    while(true)
                    {
                  	  String month1 = driver.findElement(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[2]/span")).getText();
                    	  System.out.println(month1);
                        String year1 = driver.findElement(By.xpath("//span[text()='2023']")).getText();
                        System.out.println(year1);
                        if(month1.equals(End_month)&&year1.equals(End_year))
                        {
                        	break;
                        }
                        else
                        {
                        	driver.findElement(By.xpath("//span[text()='‹']")).click();
                        }
                     }
                    driver.findElement(By.xpath("//span[contains(text(),'28')]")).click();
                    driver.findElement(By.xpath("//small[text()='Filters']")).click();    // filter button
                    driver.findElement(By.xpath("//small[text()='Add to Cart']")).click(); // Add to cart button
                    
                 // Javascript for scroll down 
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("window,scrollBy(0,400)");
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("//small[text()='Go to Cart']")).click(); // Go to cart button
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//small[text()=' Console ']")).click(); // Console button 
                    Thread.sleep(1000);
                    driver.close();
                  }
             }
		}
	}
}

