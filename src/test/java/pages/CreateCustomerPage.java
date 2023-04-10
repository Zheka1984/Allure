package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCustomerPage extends StartPage {

	public CreateCustomerPage(WebDriver driver) {
		super(driver);
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/addCust");
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[placeholder=\"First Name\"]")
	WebElement firstName;

	@FindBy(css = "input[placeholder=\"Last Name\"]")
	WebElement lastName;

	@FindBy(css = "input[placeholder=\"Post Code\"]")
	WebElement zipCode;

	@FindBy(css = "button[type=\"submit\"]")
	WebElement addCustomerAtTheBottom;

	private void fillCustomerData(String firstName, String lastName, String postCode) {
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.zipCode.sendKeys(postCode);
	}

	private String clickAddCustomerAtTheBottomAndGetAlertText() throws InterruptedException {
		addCustomerAtTheBottom.click();
		String alertMessage = null;
		try {
			Alert alert = driver.switchTo().alert();
			alertMessage = alert.getText();
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		return alertMessage;
	}

	public String addCustomer(String firstName, String lastName, String postCode) throws InterruptedException {
		fillCustomerData(firstName, lastName, postCode);
		return clickAddCustomerAtTheBottomAndGetAlertText();
	}
}