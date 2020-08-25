package com.project.pom;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BeveragesPagePOM {
	
	private AndroidDriver<AndroidElement> driver; 
	private AndroidTouchAction t1;
		
		public BeveragesPagePOM(AndroidDriver<AndroidElement> driver) {
			this.driver =  driver; 
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
		
		
		@AndroidFindBy(xpath="//android.widget.Image[@text = '1520699108Mangodrinks']")
		private AndroidElement Mango; 
		
		@AndroidFindBy(xpath="//android.view.View[@text = 'Add to cart']")
		private AndroidElement AddToCart; 
		
		@AndroidFindBy(xpath="//android.view.View[@text ='1']")
		private AndroidElement basketButton; 
		
		@AndroidFindBy(xpath="//android.view.View[@text ='Continue']")
		private AndroidElement Continue;
		
		
		@AndroidFindBy(xpath="//android.view.View[@text ='Make Payment']")
		private AndroidElement makePayment; 
		
		
		@AndroidFindBy(xpath="//android.widget.Spinner[@text ='Select State']")
		private AndroidElement StateSelection; 
		
		@AndroidFindBy(xpath="//android.widget.Spinner[@text ='Select city']")
		private AndroidElement CitySelection; 
		
		
		//@AndroidFindBy(xpath="//android.widget.EditText[@bounds ='[157,1222][1008,1301]']")
		//@AndroidFindBy(xpath="//android.widget.EditText[@bounds = '[52,1185][1029,1337]']")
		//@AndroidFindBy(xpath="//android.view.View[@bounds='[23,1156][1057,1366]']/android.view.View[@bounds='[52,1185][1029,1337]']/android.widget.EditText[@bounds = '[157,1222][1008,1301]']")
		
		@AndroidFindBy(xpath="android.widget.Spinner[@text ='Select city']/parent::android.view.View[@bounds='[52,1322][1029,1474]']/parent::android.view.View[@bounds='[23,1293][1057,1503]']/following-sibling::android.view.View[@enabled='true']/android.view.View[@enabled='true']/android.widget.EditText[@NAF='true']")
		private AndroidElement PlanetCity; 
		
		
		//@AndroidFindBy(xpath="//android.widget.EditText[@bounds ='[162,1413][1008,1492]']")
		@AndroidFindBy(xpath="//android.widget.EditText[@bounds ='[52,1390][1029,1513]']")
		private AndroidElement EarthAddress; 
		
		//@AndroidFindBy(xpath="//android.widget.Spinner[@bounds ='[162,1589][1008,1668]']")
		@AndroidFindBy(xpath="//android.widget.Spinner[@bounds ='[52,1566][1029,1692]']")
		private AndroidElement IndiaPost; 
		
		//@AndroidFindBy(xpath="//android.widget.Spinner[@bounds ='[168,1781][1008,1860]']")
		@AndroidFindBy(xpath="//android.widget.Spinner[@bounds ='[52,1744][1029,1896]']")
		private AndroidElement PinCode; 
		
		@AndroidFindBy(xpath="//android.widget.Button[@text ='Save Shipping Address']")
		private AndroidElement SaveShipAddress; 
		
		
		
		public void drinkButton() {
			t1 = new AndroidTouchAction(this.driver);
			t1.tap(tapOptions().withElement(element(this.Mango))).perform();
			
		}
		
		
		public void ClickAddToCart() {
			t1 = new AndroidTouchAction(this.driver);
			t1.tap(tapOptions().withElement(element(this.AddToCart))).perform();
			
		}
		
		public void basketClick() {
			t1 = new AndroidTouchAction(this.driver);
			t1.tap(tapOptions().withElement(element(this.basketButton))).perform();
			
		}
		
		public void ContinueButton() {
			t1 = new AndroidTouchAction(this.driver);
			t1.tap(tapOptions().withElement(element(this.Continue))).perform();
			
		}
		
		public void PaymentButton() {
			t1 = new AndroidTouchAction(this.driver);
			t1.tap(tapOptions().withElement(element(this.makePayment))).perform();
			
		}

		public void SelectStateButton() {
			t1 = new AndroidTouchAction(this.driver);
			t1.tap(tapOptions().withElement(element(this.StateSelection))).perform();
			
		}

		public void SelectCityButton() {
			t1 = new AndroidTouchAction(this.driver);
			t1.tap(tapOptions().withElement(element(this.CitySelection))).perform();
			
		}
		
		public void ScrollingStates() {
		this.driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Karnataka\"));");

		this.driver.findElement(By.xpath("//*[@text='Karnataka']")).click();
		}
		
		public void ScrollingCity() {
			this.driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Mysore\"));");

			this.driver.findElement(By.xpath("//*[@text='Mysore']")).click();}
		
		
		public void enterCity(String City) {

			this.PlanetCity.setValue(City);

		}
		
		public void enterAddress(String Add) {

			this.EarthAddress.setValue(Add);

		}
		
		public void enterIPost(String IPost) {

			this.IndiaPost.setValue(IPost);

		}
		public void enterPincode(String pinCodeNumber) {

			this.PinCode.setValue(pinCodeNumber);

		}
		
		
		public void SaveShipAddButton() {
			t1 = new AndroidTouchAction(this.driver);
			t1.tap(tapOptions().withElement(element(this.SaveShipAddress))).perform();
			
		}
		
		public void planetClick() {
			PlanetCity.click();
		}
		
		public void TapCityEditBox() {
			t1 = new AndroidTouchAction(this.driver);
			t1.tap(tapOptions().withElement(element(this.PlanetCity))).perform();
		}
		
		public void TapAddressEditBox() {
			t1 = new AndroidTouchAction(this.driver);
			t1.tap(tapOptions().withElement(element(this.EarthAddress))).perform();
			
			
		}
		
		public void TapPostEditBox() {
			t1 = new AndroidTouchAction(this.driver);
			t1.tap(tapOptions().withElement(element(this.IndiaPost))).perform();
			
		}
		
		public void TapPinCodeEditBox() {
			t1 = new AndroidTouchAction(this.driver);
			t1.tap(tapOptions().withElement(element(this.PinCode))).perform();
			
		}
		
		public void AndroidKeyPress(int i) {
			this.driver.pressKeyCode(i);
		}
		
		

}
