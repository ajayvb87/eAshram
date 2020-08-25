package com.project.tests;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.project.dataproviders.LoginDataProviders;
import com.project.generics.AssertMethods;
import com.project.generics.ScreenShot;
import com.project.pom.HomePagePOM;
import com.project.pom.LandingPagePOM;
import com.project.pom.LoginPagePOM;
import com.project.pom.MenuBarPagePOM;
import com.project.pom.MyAccountPagePOM;
import com.project.utility.DriverFactory;
import com.project.utility.DriverNames;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;

public class ScrollTest {
	
	
	private AndroidDriver<AndroidElement> driver;
	private LandingPagePOM landingpagePOM;
	private LoginPagePOM loginpagePOM;
	private MenuBarPagePOM menuBarPagePOM;
	private ScreenShot screenShot;
	private AssertMethods assertmeth;
	private static Properties properties;
	private HomePagePOM homePagePOM;
	private MyAccountPagePOM MyAccPagePOM;
	private AndroidTouchAction t1;

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
				
				// The My account Page is instantiated is instantiated
				MyAccPagePOM=new MyAccountPagePOM(driver);

				// The Home page is instantiated
				homePagePOM = new HomePagePOM(driver);
			}

	@Test
	public void ScrollTesting()
			throws InterruptedException {
		Thread.sleep(3000);

		// Tap on left top three horizontal lines
		landingpagePOM.MenuButton();
		
		// Tapping on Beverages
				homePagePOM.Beveragesbutton();
				Thread.sleep(10000);
		
		//MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
			//	"new UiScrollable(new UiSelector().resourceId(\"com.android.vending:id/data_view\")).scrollIntoView("
				//+ "new UiSelector().textContains(\"Palash\").instance(2))"));
		
		MobileElement elementtt=driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Palash\").instance(16))");
				
		
		//Perform the action on the element
		//System.out.println(elementtt.getAttribute("text")); //This line should print Recommended for You
		
		//elementtt.click();
		
		t1.tap(tapOptions().withElement(element(elementtt))).perform();
		
		

		Thread.sleep(2000);

}
}