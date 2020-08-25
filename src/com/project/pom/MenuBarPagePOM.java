package com.project.pom;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MenuBarPagePOM {
		private AndroidDriver<AndroidElement> driver; 
		private AndroidTouchAction t1;
			
			public MenuBarPagePOM(AndroidDriver<AndroidElement> driver) {
				this.driver =  driver; 
				PageFactory.initElements(new AppiumFieldDecorator(driver), this);
			}
			
			@AndroidFindBy(xpath="//android.view.View[@text = 'My account']")
			private AndroidElement myAccount;
			
			public void MyAccountButton() {
				t1 = new AndroidTouchAction(this.driver);
				t1.tap(tapOptions().withElement(element(this.myAccount))).perform();
				
			}

}
