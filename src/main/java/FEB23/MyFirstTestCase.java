package FEB23;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class MyFirstTestCase {
	
	WebDriver driver;
	@BeforeSuite
	public void Login() throws InterruptedException
	{
		driver=new ChromeDriver ();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
@Test
public void Update() throws InterruptedException
{
	driver.findElement(By.xpath("//a[@id='login_Layer']")).click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")).sendKeys("sadhulaxmidevi98@gmail.com");
	driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("Amulu@89");
	driver.findElement(By.xpath("//button[text()='Login']")).click();
	
	driver.findElement(By.linkText("View profile")).click();
	 List<WebElement> chatboxList = driver.findElements(By.xpath("//div[@class='crossIcon chatBot chatBot-ic-cross']"));
     if (!chatboxList.isEmpty() && chatboxList.get(0).isDisplayed()) {
         // Element is found and visible, so click it
         chatboxList.get(0).click();
         System.out.println("Chatbox clicked.");
     }
	driver.findElement(By.xpath("//em[text()='editOneTheme']")).click();
	Thread.sleep(2000);
	WebElement ele=driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']"));
	ele.clear();
	ele.sendKeys("S.laxmidevi");
	driver.findElement(By.id("saveBasicDetailsBtn")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//img[@alt='naukri user profile img']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div//a[text()='Logout']")).click();
}

@AfterTest
public void Teardown()
{
	driver.quit();
}
    
}

