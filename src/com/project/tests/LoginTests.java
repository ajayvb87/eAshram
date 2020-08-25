package com.project.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.project.dataproviders.LoginDataProviders;
import com.project.generics.AssertMethods;
import com.project.generics.ScreenShot;
import com.project.pom.LandingPagePOM;
import com.project.pom.LoginPagePOM;
import com.project.pom.MenuBarPagePOM;
import com.project.pom.MyAccountPagePOM;
import com.project.utility.DriverFactory;
import com.project.utility.DriverNames;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginTests {

	private AndroidDriver<AndroidElement> driver;
	private LandingPagePOM landingpagePOM;
	private LoginPagePOM loginpagePOM;
	private MenuBarPagePOM menuBarPagePOM;
	private ScreenShot screenShot;
	private AssertMethods assertmeth;
	private static Properties properties;
	private MyAccountPagePOM MyAccPagePOM;

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

		// The Login page is instantiated
		loginpagePOM = new LoginPagePOM(driver);

		// The landing page is instantiated
		landingpagePOM = new LandingPagePOM(driver);

		// The MenuBar Page is instantiated is instantiated
		menuBarPagePOM = new MenuBarPagePOM(driver);

		// The Screenshot class is instantiated
		screenShot = new ScreenShot(driver);

		// The assert method class is instantiated
		assertmeth = new AssertMethods(driver);

		// The My Account page is instantiated
		MyAccPagePOM = new MyAccountPagePOM(driver);
	}

	// Test to validate successful login with valid credentials
	@Test(dataProvider = "Login-inputs", dataProviderClass = LoginDataProviders.class)
	public void Login_With_Valid_Invalid_Credentials(String userName, String passWord) throws InterruptedException {
		Thread.sleep(3000);

		// Tap on left top three horizontal lines
		landingpagePOM.MenuButton();

		Thread.sleep(2000);

		// Tap on My Account option in the side menu items
		menuBarPagePOM.MyAccountButton();

		// Entering Username
		loginpagePOM.enterUsername(userName);

		Thread.sleep(1000);
		// Entering Password
		loginpagePOM.enterPassword(passWord);

		// Tapping on Submit
		loginpagePOM.Submitbutton();

		// Validation for Logout button - using Assert properties file
		assertmeth.assertText(properties.getProperty("LogOutOption"), properties.getProperty("LogOutxpath"),
				properties.getProperty("LogOutlocator"), properties.getProperty("LogOutmessage"));

		// Capturing Screenshot
		screenShot.captureScreenShot();

		// Logging out
		MyAccPagePOM.LogMeOutButton();
	}

	@AfterMethod
	public void tearDown(ITestResult t) throws Exception {
		// Screenshot on Validation failure
		if (t.getStatus() == t.FAILURE) {
			screenShot.captureScreenShotFailure(t.getName());
			// Capturing text of the alert message
			//String failMessage = driver.switchTo().alert().getText();
			//System.out.println(failMessage);
		}

		Thread.sleep(4000);
		driver.quit();

	}

}
