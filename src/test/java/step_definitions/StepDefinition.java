package step_definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import object_repository.login_page;
import object_repository.product_detail_page;
import object_repository.homepage;

public class StepDefinition {
	
	WebDriver driver = null;
	
	@Given("user is in Login page")
	public void user_is_in_login_page() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/driver/chromedriver");
		
		driver = new ChromeDriver();
		
		driver.navigate().to("https://www.saucedemo.com/");
	}

	@When("user input the valid credentials and click login button")
	public void user_input_the_valid_credentials_and_click_login_button() {
		login_page login = new login_page(driver);
		login.inputLoginCredentials("standard_user", "secret_sauce");

	}
	
	@When("user input the invalid credentials and click login button")
	public void user_input_the_invalid_credentials_and_click_login_button() {
		login_page login = new login_page(driver);
		login.inputLoginCredentials("standard_user", "wrong_password");

	}
	

	@Then("user can successfully login")
	public void user_can_successfully_login() {
		homepage home_page = new homepage(driver);
		home_page.userIsInHomepage();
		
		login_page login = new login_page(driver);
		login.userIsNotInLoginPage();
		
	}
	
	@Then("user can not login")
	public void user_can_not_login() {
		login_page login = new login_page(driver);
		login.showErrorMessage();
		
	}
	
	@When("user click Add to cart button in the homepage")
	public void user_click_add_to_cart_button_in_the_homepage() {
		homepage home_page = new homepage(driver);
		home_page.addToCart();

	}

	@Then("user successfully added the product to the cart")
	public void user_successfully_added_the_product_to_the_cart() {
		homepage home_page = new homepage(driver);
		home_page.showCartBadge();
	}

	@When("user click Remove button in the homepage")
	public void user_click_remove_button_in_the_homepage() {
		homepage home_page = new homepage(driver);
		home_page.removeFromCart();
	}

	@Then("user successfully remove the product from the cart")
	public void user_successfully_remove_the_product_from_the_cart() {
		homepage home_page = new homepage(driver);
		home_page.hideCartBadge();

	}
	
	@When("user click one of the product in the homepage")
	public void user_click_one_of_the_product_in_the_homepage() {

		homepage home_page = new homepage(driver);
		home_page.clickProduct();
	}
	
	@Then("user can go to product detail page")
	public void user_can_go_to_product_detail_page() {
		product_detail_page product_detail = new product_detail_page(driver);
		product_detail.redirectProductDetail();

	}

}
