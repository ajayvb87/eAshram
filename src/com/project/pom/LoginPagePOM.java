package com.project.pom;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPagePOM {

	private AndroidDriver<AndroidElement> driver;
	private AndroidTouchAction t1;

	public LoginPagePOM(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Create an account']")
	private AndroidElement CreateAnAccount;

	@AndroidFindBy(xpath = "//android.widget.EditText[@bounds = '[175,610][1008,692]']")
	private AndroidElement userName;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text = 'Enter Password']")
	private AndroidElement passCode;

	@AndroidFindBy(xpath = "//android.widget.Button[@text = 'Login']")
	private AndroidElement LoginSubmit;

	public void CreateAccbutton() {
		t1 = new AndroidTouchAction(this.driver);
		t1.tap(tapOptions().withElement(element(this.CreateAnAccount))).perform();

	}

	public void enterUsername(String usrName) {

		this.userName.setValue(usrName);

	}

	public void enterPassword(String pasCode) {

		this.passCode.setValue(pasCode);

	}

	public void Submitbutton() {
		t1 = new AndroidTouchAction(this.driver);
		t1.tap(tapOptions().withElement(element(this.LoginSubmit))).perform();

	}

}
