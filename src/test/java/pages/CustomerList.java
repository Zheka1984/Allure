package pages;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerList extends StartPage {

	public CustomerList(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//table[@class=\"table table-bordered table-striped\"]")
	WebElement table;

	@FindBy(xpath = "//a[contains(text(), \'First Name\')]")
	WebElement firstNameCell;

	@FindBy(css = "input[placeholder=\"Search Customer\"]")
	WebElement searchField;

	By rowElementSelector = By.tagName("tr");

	public List<Row> getRows() {
		List<WebElement> listOfAllRows = table.findElements(rowElementSelector);
		List<Row> rowList = listOfAllRows.stream().skip(1)
				.map(rowElement -> new Row(rowElement.findElements(By.tagName("td")))).collect(Collectors.toList());
		return rowList;
	}

	public void findCustomer(String data) throws InterruptedException {
		Actions act = new Actions(driver);
		act.sendKeys(table, Keys.PAGE_UP).build().perform();
		searchField.sendKeys(data);
	}

	public void sortByFirstName() {
		firstNameCell.click();
	}

	public void clearSearchField() {
		searchField.clear();
	}

	public void deleteCustomer(String name) throws InterruptedException {
		findCustomer(name);
		List<Row> usersForDelete = getRows();
		usersForDelete.get(0).getDeleteButton().click();
		clearSearchField();
	}
}