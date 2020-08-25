package com.project.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.project.generics.AssertMethods;
import com.project.generics.ScreenShot;
import com.project.pom.LandingPagePOM;
import com.project.utility.DriverFactory;
import com.project.utility.DriverNames;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Number_of_Menu_Items {
	private AndroidDriver<AndroidElement> driver;
	private LandingPagePOM landingpagePOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("D:\\Downloads\\AshramEstore\\resources\\Assert.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		// The package and activity capability is called
		driver = DriverFactory.getDriverPac(DriverNames.ANDROID);

		

		// The landing page is instantiated
		landingpagePOM = new LandingPagePOM(driver);


		// The Screenshot class is instantiated
		screenShot = new ScreenShot(driver);

		new AssertMethods(driver);
	}

	@Test
	public void menuItemsList() throws InterruptedException 
	{
		Thread.sleep(3000);

		// Tap on left top three horizontal lines
		landingpagePOM.MenuButton();
		
		//Capturing screenshot
		Thread.sleep(2000);
		screenShot.captureScreenShot();
		
		//List<MobileElement> menuItems = (List<MobileElement>) driver.findElementByXPath("//*[@class='android.view.View']");
		Thread.sleep(2000);
		
		//List<AndroidElement> menuItems = (List<AndroidElement>) driver.findElementsByXPath("//*[@class='android.view.View']");
		
		List<AndroidElement> menuItems = (List<AndroidElement>) driver.findElementsByXPath("//android.widget.TextView[@enabled='true']");
		
	
		for(int i=0;i<menuItems.size();i++) 
		{
			
			System.out.println("Item "+i+" "+menuItems.get(i).getText());
		}
		System.out.println("Total number of menu items is "+menuItems.size());
		
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult t) throws Exception {
		// Screenshot on Validation failure
		// if (t.getStatus() == t.FAILURE) {
		// screenShot.captureScreenShotFailure(t.getName());
		// }

		Thread.sleep(2000);
		driver.quit();

	}
}
