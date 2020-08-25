package com.project.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.project.dataproviders.LoginDataProviders;
import com.project.utility.DriverFactory;
import com.project.utility.DriverNames;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Xperia {

	private AndroidDriver<AndroidElement> driver;

	@Test
	public void setUp() throws Exception {

		for (int i = 0; i < 10; i++) {
			// The package and activity capability is called
			driver = DriverFactory.getDriverPac(DriverNames.ANDROID);

			Thread.sleep(3000);

			driver.findElement(By.xpath("//android.widget.TextView[@text='Display']")).click();

		}
	
	System.out.println("PASSSSSSS");
	}
}
