package main;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

//import touchactions libraries
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
//import time library
import static java.time.Duration.ofSeconds;

public class main extends Capabilities {

	//declare class properties 
	private static AndroidDriver<AndroidElement> driver;
	
	public static void main(String[] args) throws MalformedURLException {
		// TODO start apllication with appium
	
		driver = baseCapabilities();
//		driver.resetApp();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
