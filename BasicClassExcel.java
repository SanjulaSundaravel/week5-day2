package Assignment.week5.day2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicClassExcel {
	
	public ChromeDriver driver;
	public String excelFilePath;
	
	
	@Parameters({"URL"})
	@BeforeMethod
	public void beforeMethod(String url) {
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		    driver.get(url);
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	
	@DataProvider(name="Dynamic_Data")
	public String[][] testData() throws IOException
	{
		String[][] data = ReadExcel.getData(excelFilePath);
		return data;
		
	}
	
	

}
