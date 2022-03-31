package Assignment.week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditLead extends BasicClassExcel {
	
	@BeforeTest
	public void setData() {
		excelFilePath = "./testData/tc001.xlsx";
	}
	
	@Test(dataProvider = "Dynamic_Data")
	public void runTC004(String username, String password, String companyName, String  firstName, String secondName) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(secondName);
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("SalesForce");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Learn Automation testing");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("sanjulasundaravel1117@gmail.com");
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select location = new Select(state);
		location.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_description")).clear();
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Update the Lead form");
		driver.findElement(By.className("smallSubmit")).click();
		String title = driver.getTitle();
		System.out.println("Title of the page is "+title);
		
	}

}
