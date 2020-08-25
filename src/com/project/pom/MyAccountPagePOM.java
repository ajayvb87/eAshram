package com.project.pom;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyAccountPagePOM {

	private AndroidDriver<AndroidElement> driver;
	private AndroidTouchAction t1;

	public MyAccountPagePOM(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.view.View[@text = 'Logout']")
	private AndroidElement LogoutButton;

	@AndroidFindBy(xpath = "//android.view.View[@text = 'My Orders']")
	private AndroidElement MyOrders;

	@AndroidFindBy(xpath = "//android.view.View[@text = 'Track Order']")
	private AndroidElement TrackOrder;
	
	@AndroidFindBy(xpath = "//android.view.View[@bounds = '[15,117][78,206]']")
	private AndroidElement Back;
	
	public void LogMeOutButton() {
		t1 = new AndroidTouchAction(this.driver);
		t1.tap(tapOptions().withElement(element(this.LogoutButton))).perform();
		
	}
	
	public void ShowMyOrdersButton() {
		t1 = new AndroidTouchAction(this.driver);
		t1.tap(tapOptions().withElement(element(this.MyOrders))).perform();
		
	}
	
	public void TrackMyOrdersButton() {
		t1 = new AndroidTouchAction(this.driver);
		t1.tap(tapOptions().withElement(element(this.TrackOrder))).perform();
		
	}
	
	public void Go_back_Button() {
		t1 = new AndroidTouchAction(this.driver);
		t1.tap(tapOptions().withElement(element(this.Back))).perform();
		
	}

}
