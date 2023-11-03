package object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login_page {
	
	WebDriver driver;
	
	By input_username = By.id("user-name");
	
	By input_password = By.id("password");
	
	By btn_login = By.id("login-button");
	
	By error_message = By.xpath("//h3[contains(text(), \"Epic sadface: Username and password do not match any user in this service\")]");
	
	public login_page(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void inputLoginCredentials(String username, String password) {
		driver.findElement(input_username).sendKeys(username);
		driver.findElement(input_password).sendKeys(password);
		driver.findElement(btn_login).click();
	}
	
	public boolean userIsNotInLoginPage() {
	    return driver.findElements(btn_login).size() > 0;

	}
	
	public void showErrorMessage() {
		driver.findElement(error_message);
	}
	
	
}
