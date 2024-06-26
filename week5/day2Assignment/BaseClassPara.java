package week5.day2Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClassPara {
	
	public RemoteWebDriver driver;

	@Parameters({"url","username","password","browser"})
	@BeforeMethod
	
	public void preCondition(String url, String uName, String pWord, String browser) {
    
	ChromeOptions options = new ChromeOptions();
	
	if(browser.equalsIgnoreCase("chrome")) {
		 driver = new ChromeDriver(options);
	}
	else if (browser.equalsIgnoreCase("edge")) {
		 driver = new ChromeDriver(options);
	}
	
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.findElement(By.id("username")).sendKeys(uName);
	driver.findElement(By.id("password")).sendKeys(pWord);
	driver.findElement(By.className("decorativeSubmit")).click();
	driver.findElement(By.partialLinkText("CRM")).click();
	}
	
	
@AfterMethod
public void postCondition(){
	driver.close();

}
}