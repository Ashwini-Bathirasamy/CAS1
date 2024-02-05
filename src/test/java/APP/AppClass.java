package APP;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
 
public class AppClass {
 
	
	public static WebDriver driver;
	public void createDriver() {
		// Launch browser with URL
		driver = DriverSetup.getWebDriver();
		//driver.navigate().to("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
	}
	public void AppSearchValidation() throws IOException {
		driver.manage(). timeouts(). implicitlyWait(Duration.ofSeconds(15));
		//WebElement ele = driver.findElement(By.id("QuicklinksItemTitle"));
		//ele.click();
		driver.navigate().to("https://onecognizant.cognizant.com/Home?GlobalAppId=926");
		WebElement element =driver.findElement(By.xpath("//div[@class='viewAllHotAppsBtn']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		List<WebElement> li= driver.findElements(By.xpath("//div[@class ='aZHolder']/div"));
		List<String> str= new ArrayList<String>();
		for(WebElement e: li) {
			if(e.getAttribute("role")!=null) {
				continue;
			}
			else 
				str.add(e.getText());
		}
		for(String s:str)
		System.out.println(s+" is disabled");
		li.get(2).click();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		//File trg = new File("C:\\Users\\2304149\\eclipse-workspace\\AppValidation\\src\\test\\resources\\screenshots\\image.png");
		FileUtils.copyFile(src, new File("C:\\Users\\2304149\\eclipse-workspace\\AppValidation\\src\\test\\resources\\Screen\\image.png"));

	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		AppClass abc= new AppClass();
		abc.createDriver();
		abc.AppSearchValidation();
 
	}
 
}