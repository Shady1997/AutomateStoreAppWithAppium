package main;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Capabilities {

	public static AndroidDriver<AndroidElement> baseCapabilities () throws MalformedURLException {
		// TODO Auto-generated method stub
		File appDir=new File("src");
		File app=new File(appDir,"store.apk");
		DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "shady1");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
//		desiredCapabilities.setCapability("noReset", true);
//		desiredCapabilities.setCapability("fullReset", false);
		AndroidDriver<AndroidElement> driver =new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
		return driver;
	}

}
