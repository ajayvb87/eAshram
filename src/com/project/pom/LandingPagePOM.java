package com.project.pom;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


import org.openqa.selenium.support.PageFactory;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class LandingPagePOM {
private AndroidDriver<AndroidElement> driver; 
private AndroidTouchAction t1;
	
	public LandingPagePOM(AndroidDriver<AndroidElement> driver) {
		this.driver =  driver; 
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//@AndroidFindBy(xpath="//android.view.View[@clickable='true']")
	
	
	//@AndroidFindBy(xpath="//android.view.View[@text = '.']")
	//@AndroidFindBy(xpath="//android.view.View[@index = '0' and @clickable='true']")
	//@AndroidFindBy(xpath="//android.widget.Image[@text = 'logo']//preceeding-sibling")
	
	//@AndroidFindBy(xpath="//android.view.View[contains(@text,'.')]")
	@AndroidFindBy(xpath="//android.view.View[@bounds='[0,88][107,230]']")
	private AndroidElement threeHorizontalLines; 
	
	@AndroidFindBy(xpath="//android.view.View[@text = 'My account']")
	private AndroidElement myAccount;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text = 'Already a customer? Sign in']")
	private AndroidElement alreadyCustomer; 
	
	
	public void MenuButton() {
		t1 = new AndroidTouchAction(this.driver);
		t1.tap(tapOptions().withElement(element(this.threeHorizontalLines))).perform();
		
	}
	
	//public void MyAccountButton() {
		//t1 = new AndroidTouchAction(this.driver);
		//t1.tap(tapOptions().withElement(element(this.myAccount))).perform();
		
	//}
	
}
