package step_definitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import object_repository.login_page;
import object_repository.product_detail_page;
import object_repository.about_page;
import object_repository.draggable_page;
import object_repository.homepage;

public class StepDefinition {
	
	WebDriver driver = null;
	
	@Given("user is in Login page")
	public void user_is_in_login_page() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/driver/chromedriver");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
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
	
	@When("user click about page button on the sidebar menu")
	public void user_click_about_page_button_on_the_sidebar_menu() {
		homepage home_page = new homepage(driver);
		home_page.goToAbout();
	}
	
	@When("user scroll to the swipe bar and swap")
	public void user_scroll_to_the_swipe_bar_and_swap() {
		about_page about = new about_page(driver);
		about.swipeElement();
		about.zoomPage();

	}
	
	@When("user click filter button and select one of the filter")
	public void user_click_filter_button_and_select_one_of_the_filter() {
		homepage home_page = new homepage(driver);
		home_page.selectDropdown();
	}
	
	@Then("user can see the homepage filtered by the selected filter")
	public void  user_can_see_the_homepage_filtered_by_the_selected_filter() {
		homepage home_page = new homepage(driver);
		home_page.activeDropdown();
	}
	
	
	@Given("user is draggable web")
	public void user_is_draggable_web() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/driver/chromedriver");
		
		driver = new ChromeDriver();
		
		driver.navigate().to("https://jqueryui.com/draggable/");
		
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}
	
	@Then("user drag box on the draggable page")
	public void user_drag_box_on_the_draggable_page() {
		draggable_page draggable = new draggable_page(driver);
		draggable.dragImage();
	}
	
	@When("user see the product image")
	public void user_see_the_product_image() throws IOException, InterruptedException {
		homepage home_page = new homepage(driver);
		home_page.compareImage();
		
	}
	
  	@Then("user can compare the product image")
  	public void user_can_compare_the_product_image() {
  		
  	}
	

}
