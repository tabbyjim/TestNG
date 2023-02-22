package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Duplicate_Category;
import util.BrowserFactory;

public class Duplicate_Category_Test {

	WebDriver driver;

	@Test
	public void ValidateUserShouldNotAbleToAddDuplicateCategory() {

		driver = BrowserFactory.init();

		Duplicate_Category duplicate_Category = PageFactory.initElements(driver, Duplicate_Category.class);

		String categoryname = "TestNG 2022";
		duplicate_Category.insertCategory(categoryname);
		duplicate_Category.clickOnAddCategoryButton();
		
		driver.getTitle();
		driver.getWindowHandle();
		String ActualAlertMessage = duplicate_Category.getErrorMessage();
	    String  expectedAlertMessage = "The category you want to add already exists: "+categoryname+".";
		ActualAlertMessage.contains(expectedAlertMessage);
		duplicate_Category.nevermindButton();
		


		
        BrowserFactory.tearDown();
	}
}
