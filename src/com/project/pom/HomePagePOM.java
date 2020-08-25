package com.project.pom;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePagePOM {

	private AndroidDriver<AndroidElement> driver;
	private AndroidTouchAction t1;
	private int count;

	public HomePagePOM(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Beverages']")
	private AndroidElement Beverages;

	// @AndroidFindBy(xpath = "//android.widget.Image[@text =
	// '1520698861Appledrink']")
	// private AndroidElement AppleDrink;

	// @AndroidFindBy(xpath = "//android.widget.Image[@text =
	// '1520698861Appledrink']")
	// private AndroidElement Palash;

	/*
	 * public void Beverahugesbutton(String text) {
	 * 
	 * List<AndroidElement> li =
	 * this.driver.findElementsByClassName("android.view.View");
	 * System.out.println(li.size());
	 * 
	 * for (int i = 0; i < li.size(); i++) {
	 * System.out.println(li.get(i).getText());
	 * 
	 * if (li.get(i).getText().contains(text)) { li.get(i).click(); } }
	 * 
	 * }
	 */

	public void Beveragesbutton() {
		t1 = new AndroidTouchAction(this.driver);
		t1.tap(tapOptions().withElement(element(this.Beverages))).perform();

	}

	/*
	 * public void ClickProduct() { t1 = new AndroidTouchAction(this.driver);
	 * t1.tap(tapOptions().withElement(element(this.AppleDrink))).perform();
	 * 
	 * }
	 */

	public void AndroidScrollingClick(String text) throws InterruptedException {
		
		
		
		this.driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))").click();

		
		
		//----------------------------------------------------------
		//this.driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))").click();
    
		
		//---------------------------------------------------
		
		
						//does not Scroll
		
		// driver1.findElementByAndroidUIAutomator("new UiScrollable(new
		// UiSelector()).scrollIntoView(new UiSelector().text(\""+text+"\"));").click();
//	this.driver.findElementByAndroidUIAutomator(
	//"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector()."
	//+ "textContains(\""+ text + "\").instance(0))").click();
		
		//-------------------------------------------------------
								
						//Does not scroll
		//this.driver.findElementByAndroidUIAutomator(
			//	"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\""
				//		+ text + "\").instance(16))")
				//.click();
		//----------------------------------------------------------
		
		
		//this.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + text + "\").instance(16))"));
		
		//--------------------------------------------------------------
		
		//Scroll works but fails to click
		//this.driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"text\"))");
		//Thread.sleep(4000);
		
		//this.driver.findElement(By.xpath(properties.)).click();
		
		//----------------------------------------------------------------
		//this.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"" + text + "\").instance(0))"));

		//-----------------------------------------------------------------
									//Scrolls
		//this.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"android:id/content\")).scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))")).click();
		
	//-------------------------------------------------------------------------	
	//Generic function for Scroll
	//public void scrollUsingTouchActions_ByElements(MobileElement Palash) {
		//TouchAction actions = new TouchAction(driver);
		//actions.press(startElement).waitAction(Duration.ofSeconds(2)).moveTo(endElement).release().perform();
	//}
		
	//---------------------------------------------------------------------------	
						//Scrolls
		
		//MobileElement element = this.driver.findElement(MobileBy.AndroidUIAutomator(
		  //      "new UiScrollable(new UiSelector().resourceId(\"android:id/content\")).getChildByText("
		    //    + "new UiSelector().className(\"android.view.View\"),\"" + text + "\")"));

	//------------------------------------------------------------------------------
		
		
		//MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
		  //      "new UiScrollable(new UiSelector().resourceId(\"android:id/content\")).getChildByText("
		    //    + "new UiSelector().className(\"android.widget.FrameLayout\"), \"Games We Are Playing\")"));

		
		//Perform the action on the element
		//element.click();
	
		//--------------------------------------------------------------------------------

		/*
		 * count= this.driver.findElements(By.className("android.view.View")).size();
		 * 
		 * System.out.println(count);
		 * 
		 * for(int i=0;i<count;i++)
		 * 
		 * {
		 * 
		 * String
		 * name=this.driver.findElements(By.className("android.view.View")).get(i).
		 * getText();
		 * 
		 * 
		 * if(name.contains("Palash Sharbat"))
		 * 
		 * {
		 * 
		 * this.driver.findElements(By.className("android.view.View")).get(i).click();
		 * 
		 * 
		 * break;
		 * 
		 * }
		 */

	}
	


	
	 //---------------------------------------------------------------------------------------
		  public void selectProd(String text) { List<AndroidElement>
		  nuDrinks=driver.findElementsByXPath("//android.widget.Image[@index='0']");
		  
		  for(int i=0;i<nuDrinks.size();i++) {
		  if(nuDrinks.get(i).getText().equalsIgnoreCase(text)) {
		  nuDrinks.get(i).click(); } }
		  
		  
		  }
	//-----------------------------------------------------------------------------------------


}	 


