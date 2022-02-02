package main;

//import io.appium.java_client.TouchAction;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.touch.LongPressOptions;
import pom.GeneralStoreHomePage;
import pom.ProductsPage;
import utility.ExcelUtility;
import utility.Utility;

//import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
//import static io.appium.java_client.touch.offset.ElementOption.element;
//import static java.time.Duration.ofSeconds;

import java.io.IOException;
//import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import touchactions libraries
//import io.appium.java_client.TouchAction;
//import static io.appium.java_client.touch.TapOptions.tapOptions;
//import static io.appium.java_client.touch.offset.ElementOption.element;
//import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
//import time library
//import static java.time.Duration.ofSeconds;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;

import capabilities.Capabilities;
import io.appium.java_client.android.AndroidElement;

public class main extends Capabilities {

	@BeforeTest
	public static void prepare() throws IOException {
		// TODO start apllication with appium
		driver = baseCapabilities("AppName");
		names.add("Converse All Star");
		names.add("Jordan 6 Rings");
		names.add("LeBron Soldier 12 ");
		names.add("Nike SFB Jungle");

		homePage = new GeneralStoreHomePage(driver);
		productPage = new ProductsPage(driver);
	}

	// male cycle
	@Test(priority = 1)
	public static void checkToastErrorMessage() throws InterruptedException {
		homePage.clickToShop.click();
		Assert.assertEquals(homePage.toastMessage.getAttribute("name").toString(), "Please enter your name");
		Utility.captureScreenshot(driver, "toastErrorMessage"); // take screenshot when click to shop with empty data
	}

	@Test(priority = 2)
	public static void chooseUserCountry() throws InterruptedException {
		homePage.chooseCountry.click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Egypt\"));")
				.click();
		Utility.captureScreenshot(driver, "verifyCountry"); // take screenshot after choose country
	}

	@Test(priority = 3)
	public static void addUserName() throws InterruptedException {
		homePage.addName.sendKeys(ExcelUtility.getUserName());
		Utility.captureScreenshot(driver, "username"); // take screenshot after fill user name
	}

	@Test(priority = 4)
	public static void chooseGender() throws InterruptedException {
		homePage.chooseGenderMale.click();
		Utility.captureScreenshot(driver, "chooseGender"); // take screenshot after choose geneder
	}

	@Test(priority = 5)
	public static void goToProductsPage() throws InterruptedException {
		homePage.clickToShop.click();
	}

	@Test(priority = 6)
	public static void selectAllProducts() throws InterruptedException {
		selectALlProducts(names);
		Utility.captureScreenshot(driver, "chooseProducts"); // take screenshot after choose all products
	}

	@Test(priority = 7)
	public static void goToPaymentPage() throws InterruptedException {
		productPage.goToPayment.get(1).click();
		Utility.captureScreenshot(driver, "paymentPage"); // take screenshot for payment page
	}

	@Test(priority = 8)
	public static void checkConfirmationBox() throws InterruptedException {
		productPage.confirmPayment.click();
		Utility.captureScreenshot(driver, "confirmPurchasing"); // take screenshot after click check box to confirm
																// purchasing
	}

	@AfterClass
	public static void TearDown() {
		driver.quit();
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

//	System.out.println(totalPrice);

	// productPage.purchaseProducts.click();

//	List<AndroidElement> reviewProducts=driver.findElementsByXPath("//android.widget.ImageView[@index='0']");
//	reviewProducts.get(0).click();
//	driver.findElementByXPath("//android.widget.TextView[@text='Air Jordan 4 Retro']").click();
//	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Nike SFB Jungle\"));");

	// long press for swipe action to swipe from first point to second point
//	touchAction = new TouchAction(driver);
//
//	WebElement first = driver.findElement(By.xpath("//android.widget.TextView[@text='Air Jordan 4 Retro']"));
//
	// touchAction.longPress(longPressOptions().withPosition([783,1325][1342,1401]));
//	WebElement second = driver.findElement(By.xpath("//android.widget.TextView[@text='Nike SFB Jungle']"));
//
//	touchAction.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second)).release().perform();

//	driver.findElementByXPath("//android.widget.Button[@index='2']").click();

	// female cycle
//	driver.resetApp();
//	
//	homePage.chooseCountry.click();
//	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Cuba\"));").click();
//
//	homePage.addName.sendKeys("mariam ahmed");
//
//	homePage.chooseGenderFemale.click();
//
//	homePage.clickToShop.click();
//
//	selectALlProducts(names);
//	
//	driver.findElementByXPath("//android.widget.ImageButton[@index='0']").click();
//
//	driver.findElementByXPath("//android.widget.ImageButton[@index='0']").click();

}
