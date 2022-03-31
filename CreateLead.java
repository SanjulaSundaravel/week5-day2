package Assignment.week5.day2;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLead extends BasicClassExcel {
	
	@BeforeTest
	public void setData() {
		excelFilePath = "./testData/tc001.xlsx";
	}
	
	

	  @Test(dataProvider = "Dynamic_Data")
			public void runTC001(String username, String password, String companyName, String  firstName, String secondName) {
				
				driver.findElement(By.id("username")).sendKeys(username);
				driver.findElement(By.id("password")).sendKeys(password);
				driver.findElement(By.className("decorativeSubmit")).click();
				driver.findElement(By.linkText("CRM/SFA")).click();
				driver.findElement(By.linkText("Leads")).click();
				driver.findElement(By.linkText("Create Lead")).click();
				driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
				driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
				driver.findElement(By.id("createLeadForm_lastName")).sendKeys(secondName);
				driver.findElement(By.className("smallSubmit")).click();
	  }

}
	  
