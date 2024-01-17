package Gspatial;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserProfile 
{
	WebDriver driver;
	@Test
	public void user() throws InterruptedException
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
				//Thread.sleep(1000);
				driver.findElement(By.xpath("//button[text()='Skip']")).click();   //Skip button
				driver.findElement(By.xpath("//small[text()='User Profile']")).click();
				//driver.findElement(By.xpath("//small[text()=' Order History ']")).click();
				
				//user_profile Information
				driver.findElement(By.xpath("//small[text()=' User Profile ']")).click();
				WebElement full_name = driver.findElement(By.xpath("/html/body/app-root/div/div/menu/div/div[3]/div[2]/account-details/div/form[1]/div[1]/div[2]/input"));
				full_name.clear();
				full_name.sendKeys("Vaishnavi");
				Thread.sleep(1000);
				driver.findElement(By.xpath("/html/body/app-root/div/div/menu/div/div[3]/div[2]/account-details/div/form[1]/div[2]/div[2]/input")).sendKeys("polavaishnavi.ise.rymec@gmail.com");
				driver.findElement(By.xpath("//small[text()='Save']")).click();
				driver.findElement(By.xpath("//small[text()=' Payment History ']")).click();
				
				//Privacy_center
				driver.findElement(By.xpath("//small[text()=' Privacy Center ']")).click();
				List <WebElement> Privacy_checkboxes = driver.findElements(By.xpath("//button[@class='btn']"));
				int count = Privacy_checkboxes.size();
				System.out.printf("Total no of checkboxes:"+count);
				for(int i=0;i<=count-1;i++)
				{
					Privacy_checkboxes.get(i).click();
					Thread.sleep(1000);
				}
				driver.findElement(By.xpath("//span[text()='Save Settings']")).click();
				
				//Billing_Management button 
				driver.findElement(By.xpath("//small[text()=' Billing Management ']")).click();
				WebElement name = driver.findElement(By.xpath("//input[@placeholder='Enter Name']"));
				name.clear();
				name.sendKeys("Vaishnavi");
				
				WebElement address = driver.findElement(By.xpath("//input[@placeholder='Enter address']"));
				address.clear();
				address.sendKeys("Gandhi nagar");
				
				WebElement city = driver.findElement(By.xpath("//input[@placeholder='Enter city']"));
				city.clear();
				city.sendKeys("Banglore");
				
				WebElement state = driver.findElement(By.xpath("//input[@placeholder='Enter state']"));
				state.clear();
				state.sendKeys("Karnataka");
				
				WebElement country = driver.findElement(By.xpath("//input[@placeholder='Enter country']"));
				country.clear();
				country.sendKeys("INDIA");
				
				WebElement postalcode = driver.findElement(By.xpath("//input[@placeholder='Enter postalcode']"));
				postalcode.clear();
				postalcode.sendKeys("5600087");
				
				WebElement phone = driver.findElement(By.xpath("//input[@placeholder='+91XXXXXXXXXX']"));
				phone.clear();
				phone.sendKeys("8356287676");
				Thread.sleep(1000);
				//driver.findElement(By.xpath("/html/body/app-root/div/div/menu/div/div[3]/div[2]/billing-info/div/div/div/invoice-information/div/form/div[8]/div/button")).click(); //Save button
				
				//console button
				driver.findElement(By.xpath("//small[text()=' Console ']")).click();
				Thread.sleep(1000);
				
				//Resource 
				//driver.findElement(By.xpath("//button[@class='btn m-auto']")).click();
				//driver.findElement(By.xpath("/html/body/app-root/div/div/dashboard/slider/div/div[1]/div/div[1]/map/div/div/div/div")).click();
				
				//Download sample file
				driver.findElement(By.xpath("/html/body/app-root/div/div/dashboard/slider/div/div[1]/div/div[2]/div/div[2]/div[1]/div[4]/a/img")).click();
				//driver.findElement(By.xpath("//small[text()=' Console ']")).click();
				Thread.sleep(1000);
				driver.close();
				
			}
			
		}
	}

}

