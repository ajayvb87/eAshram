package com.project.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.project.dataproviders.LoginDataProviders;
import com.project.generics.AssertMethods;
import com.project.generics.ScreenShot;
import com.project.pom.BeveragesPagePOM;
import com.project.pom.HomePagePOM;
import com.project.pom.LandingPagePOM;
import com.project.pom.LoginPagePOM;
import com.project.pom.MenuBarPagePOM;
import com.project.pom.MyAccountPagePOM;
import com.project.utility.DriverFactory;
import com.project.utility.DriverNames;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Add_Product_and_Checkout {

	private AndroidDriver<AndroidElement> driver;
	private LandingPagePOM landingpagePOM;
	private LoginPagePOM loginpagePOM;
	private MenuBarPagePOM menuBarPagePOM;
	private ScreenShot screenShot;
	private AssertMethods assertmeth;
	private static Properties properties;
	private HomePagePOM homePagePOM;
	private MyAccountPagePOM MyAccPagePOM;
	private BeveragesPagePOM beveragePagePOM;

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
		MyAccPagePOM = new MyAccountPagePOM(driver);

		// The Home page is instantiated
		homePagePOM = new HomePagePOM(driver);

		// The Beverage page is instantiated
		beveragePagePOM = new BeveragesPagePOM(driver);
	}

	// Login to the Application
	@Test(dataProvider = "inputs", dataProviderClass = LoginDataProviders.class)
	public void productCheckout(String userName, String passWord, String drink) throws InterruptedException {
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

		// Navigating back
		MyAccPagePOM.Go_back_Button();

		// Tapping on Beverages
		homePagePOM.Beveragesbutton();
		Thread.sleep(10000);

		// homePagePOM.AndroidScrollingClick();

		// Scrolling to drink in beverages
		// homePagePOM.AndroidScrollingClick(drink);

		// Tapping on Mango drink
		beveragePagePOM.drinkButton();

		// Validation for Add to Cart button - using Assert properties file
		assertmeth.assertText(properties.getProperty("addToCart"), properties.getProperty("AddtoCartxpath"),
				properties.getProperty("AddtoCartlocator"), properties.getProperty("AddtoCartmessage"));

		// Tapping on Add to Cart button
		beveragePagePOM.ClickAddToCart();

		// Tapping on Basket button
		beveragePagePOM.basketClick();

		// Tapping on Continue button
		beveragePagePOM.ContinueButton();

		// Validation for Make Payment button - using Assert properties file
		assertmeth.assertText(properties.getProperty("MakePaymentText"), properties.getProperty("MakePaymentxpath"),
				properties.getProperty("MakePaymentlocator"), properties.getProperty("MakePaymentmessage"));

		// Tapping on Make Payment button
		beveragePagePOM.PaymentButton();

		// State drop down list
		beveragePagePOM.SelectStateButton();

		// Selecting State
		beveragePagePOM.ScrollingStates();

		// City drop down
		beveragePagePOM.SelectCityButton();

		// Selecting City
		beveragePagePOM.ScrollingCity();
		Thread.sleep(2000);

		// Entering city if not listed
		beveragePagePOM.TapCityEditBox();
		driver.hideKeyboard();
		beveragePagePOM.enterCity("Planet");
		//beveragePagePOM.planetClick();
		

		// Entering address
		beveragePagePOM.TapAddressEditBox();
		driver.hideKeyboard();
		beveragePagePOM.enterAddress("Earth");
		

		// Entering Post
		beveragePagePOM.TapPostEditBox();
		driver.hideKeyboard();
		beveragePagePOM.enterIPost("IndiaPost");

		// Entering Pin code
		beveragePagePOM.TapPinCodeEditBox();
		driver.hideKeyboard();
		beveragePagePOM.enterPincode("560061");

	}

	/*
	 * @Test(dataProvider = "Product-inputs", dataProviderClass =
	 * LoginDataProviders.class) public void product_search_add(String drink) throws
	 * InterruptedException {
	 * 
	 * }
	 */

}
