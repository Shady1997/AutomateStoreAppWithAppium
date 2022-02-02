package main;

import java.util.ArrayList;
import java.util.List;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pom.GeneralStoreHomePage;
import pom.ProductsPage;

public class ClassProperties {
	// declare class properties
	protected static AndroidDriver<AndroidElement> driver;
	public static GeneralStoreHomePage homePage;
	public static ProductsPage productPage;
	public static List<String> names = new ArrayList<String>();
	public static List<AndroidElement> elements = new ArrayList<AndroidElement>();
	public static List<AndroidElement> elementPrices = new ArrayList<AndroidElement>();
	protected static TouchAction touchAction;
	public static double totalPrice = 0;
}
