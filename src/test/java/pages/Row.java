package pages;

import java.util.List;
import java.util.Objects;

import org.openqa.selenium.WebElement;

public class Row {
	String firstName;
	String lastName;
	String zipCode;
	WebElement deleteButton;
	List<WebElement> columnsList;

	public Row(List<WebElement> columnsList) {
		this.columnsList = columnsList;
		firstName = columnsList.get(0).getText();
		lastName = columnsList.get(1).getText();
		zipCode = columnsList.get(2).getText();
		deleteButton = columnsList.get(4);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(WebElement deleteButton) {
		this.deleteButton = deleteButton;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Row other = (Row) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(zipCode, other.zipCode);
	}

	@Override
	public String toString() {
		return "Row [firstName=" + firstName + ", lastName=" + lastName + ", zipCode=" + zipCode + "]";
	}
}