package com.project.pom;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegistrationPagePOM {
	
	
	private AndroidDriver<AndroidElement> driver; 
	private AndroidTouchAction t1;
		
		public RegistrationPagePOM(AndroidDriver<AndroidElement> driver) {
			this.driver =  driver; 
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
		
		@AndroidFindBy(xpath="//android.widget.EditText[@bounds = '[175,545][1008,623]']")
		private AndroidElement firstName; 
		
		@AndroidFindBy(xpath="//android.widget.EditText[@bounds = '[175,749][1008,828]']")
		private AndroidElement lastName;
		
		@AndroidFindBy(xpath="//android.widget.EditText[@bounds = '[181,954][1008,1035]']")
		private AndroidElement email; 
		
		@AndroidFindBy(xpath="//android.widget.EditText[@bounds = '[175,1161][1008,1240]']")
		private AndroidElement enterPassword; 
		
		@AndroidFindBy(xpath="//android.widget.EditText[@bounds = '[175,1366][1008,1445]']")
		private AndroidElement confirmPassword;
		
		@AndroidFindBy(xpath="//android.widget.EditText[@bounds = '[173,1571][1008,1650]']")
		private AndroidElement enterMobileNumber; 
		
		@AndroidFindBy(xpath="//android.widget.Button[@text = 'SUBMIT']")
		private AndroidElement submitButton;
		
		
		public void firstNameBox(String value) {
			this.firstName.setValue(value);
		}
		
		public void lastNameBox(String value) {
			this.lastName.setValue(value);
		}	
		
		public void emailBox(String value) {
			this.email.setValue(value);
		}	
		public void enterPasswordBox(String value) {
			this.enterPassword.setValue(value);
		}	
		public void confirmPasswordBox(String value) {
			this.confirmPassword.setValue(value);
		}	
		public void enterMobileNumberBox(String value) {
			this.enterMobileNumber.setValue(value);
		}	
		
		public void Submitbutton() {
			t1 = new AndroidTouchAction(this.driver);
			t1.tap(tapOptions().withElement(element(this.submitButton))).perform();
			
		}
		

}
