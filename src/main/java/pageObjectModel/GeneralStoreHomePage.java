package pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GeneralStoreHomePage {

	public GeneralStoreHomePage(AppiumDriver driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	// xpath to choose country
	@AndroidFindBy(xpath = "//android.widget.Spinner[@index='1']")
	public WebElement chooseCountry;

	// xpath to add username
	@AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
	public WebElement addName;

	// xpath to choose gender male
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@index='0']")
	public WebElement chooseGenderMale;

	// xpath to choose gender female
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@index='1']")
	public WebElement chooseGenderFemale;

	// xpath to to start shop
	@AndroidFindBy(xpath = "//android.widget.Button[@index='6']")
	public WebElement clickToShop;

}
