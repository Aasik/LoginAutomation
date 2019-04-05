package loginAutomation;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginAutomation {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LoginAutomation obj = new LoginAutomation();
		obj.LoginAutomation();

	}
	
	public void LoginAutomation() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		//Open Chrome browser
		WebDriver driver = new ChromeDriver();
		
		//Maximize the Browser window
		driver.manage().window().maximize();
		
		//delete All the cookies
		driver.manage().deleteAllCookies();
		
		//sets an amount of time to wait for a page load to complete before throwing an error
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		
		//to tell webdrive to poll the DOM for a certain amount of time when trying to find an element if they are not immediately available
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//pass the URL
		driver.get("http://newtours.demoaut.com/");
		
		//Type the value admin in uername textfield
		driver.findElement(By.xpath("//input[@name=\"userName\"]")).sendKeys("admin");
		
		//Type the value merury in password textfield
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("mercury");
		
		//Click on Login button
		driver.findElement(By.xpath("//input[@name=\"login\"]")).click();
		
		//take a screenshot after clicked on the login  button
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			//copy the screenshot to a desired location using copyFile/method
			FileUtils.copyFile(src, new File("D:\\Selenium"+System.currentTimeMillis()+".png"));
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
				
		
	}

}
