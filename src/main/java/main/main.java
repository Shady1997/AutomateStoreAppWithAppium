package main;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import pageObjectModel.GeneralStoreHomePage;
import pageObjectModel.ProductsPage;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import touchactions libraries
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
//import time library
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class main extends Capabilities {

	// declare class properties
	private static AndroidDriver<AndroidElement> driver;
	public static GeneralStoreHomePage homePage;
	public static ProductsPage productPage;
	public static List<String> names = new ArrayList<>();
	public static List<AndroidElement> elements = new ArrayList<>();
	public static List<AndroidElement> elementPrices = new ArrayList<>();
	private static TouchAction touchAction;
	public static double totalPrice = 0;

	public static void main(String[] args) throws IOException {
		// TODO start apllication with appium
		driver = baseCapabilities("AppName");
		names.add("Converse All Star");
		names.add("Jordan 6 Rings");
		names.add("LeBron Soldier 12 ");
		names.add("Nike SFB Jungle");

		homePage = new GeneralStoreHomePage(driver);
		productPage = new ProductsPage(driver);

		// male cycle
		homePage.chooseCountry.click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Egypt\"));")
				.click();

		homePage.addName.sendKeys("shady ahmed");

		homePage.chooseGenderMale.click();

		homePage.clickToShop.click();

		selectALlProducts(names);

		System.out.println(totalPrice);

		// productPage.purchaseProducts.click();
		List<AndroidElement> purchaseProducts = driver.findElementsByXPath("//android.widget.ImageButton[@index='0']");
		purchaseProducts.get(1).click();

//		List<AndroidElement> reviewProducts=driver.findElementsByXPath("//android.widget.ImageView[@index='0']");
//		reviewProducts.get(0).click();
//		driver.findElementByXPath("//android.widget.TextView[@text='Air Jordan 4 Retro']").click();
//		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Nike SFB Jungle\"));");

		// long press for swipe action to swipe from first point to second point
//		touchAction = new TouchAction(driver);
//
//		WebElement first = driver.findElement(By.xpath("//android.widget.TextView[@text='Air Jordan 4 Retro']"));
//
		// touchAction.longPress(longPressOptions().withPosition([783,1325][1342,1401]));
//		WebElement second = driver.findElement(By.xpath("//android.widget.TextView[@text='Nike SFB Jungle']"));
//
//		touchAction.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second)).release().perform();

		driver.findElementByXPath("//android.widget.CheckBox[@index='1']").click();

		driver.findElementByXPath("//android.widget.Button[@index='2']").click();

		

		// female cycle
		driver.resetApp();
		
		homePage.chooseCountry.click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Cuba\"));").click();

		homePage.addName.sendKeys("mariam ahmed");

		homePage.chooseGenderFemale.click();

		homePage.clickToShop.click();

		selectALlProducts(names);
		
		driver.findElementByXPath("//android.widget.ImageButton[@index='0']").click();

		driver.findElementByXPath("//android.widget.ImageButton[@index='0']").click();
	}

	public static void selectALlProducts(List<String> names) {

		for (int j = 0; j < names.size(); j++) {
			elements = driver.findElementsByXPath("//android.widget.TextView[@text='ADD TO CART']");
			elementPrices = driver.findElementsByXPath("//android.widget.TextView[@index='0']");
			for (int i = 0; i < elements.size(); i++) {
				elements.get(i).click();
				totalPrice += Double.parseDouble(elementPrices.get(i).getText().substring(1));
			}
			driver.findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + names.get(j) + "\"));");
		}

		elements = driver.findElementsByXPath("//android.widget.TextView[@text='ADD TO CART']");
		elementPrices = driver.findElementsByXPath("//android.widget.TextView[@index='0']");
		for (int i = 0; i < elements.size(); i++) {
			elements.get(i).click();
			totalPrice += Double.parseDouble(elementPrices.get(i).getText().substring(1));
		}
	}

}
