package object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class homepage {
	
	WebDriver driver;
	
	By title_page = By.xpath("//div[contains(text(), \"Swag Labs\")]");
	
	By icon_cart = By.id("shopping_cart_container");
	
	By btn_sidebar = By.id("react-burger-menu-btn");
	
	By btn_about_sidebar = By.id("about_sidebar_link");
	
	By btn_add_to_cart = By.id("add-to-cart-sauce-labs-backpack");
	
	By btn_remove = By.id("remove-sauce-labs-backpack");
	
	By cart_badge = By.xpath("//span[contains(@class, \"shopping_cart_badge\")]");
	
	By btn_title_product_backpack = By.id("item_4_title_link");
	
	
	public homepage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void userIsInHomepage() {
		driver.findElement(title_page).isDisplayed();
		driver.findElement(icon_cart).isDisplayed();
		
		
		WebElement element = driver.findElement(By.xpath("//div[contains(@class, \"footer_copy\")]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.COMMAND, Keys.ADD));
	}
	
	public void addToCart() {
		driver.findElement(btn_add_to_cart).click();
	}
	
	public void showCartBadge() {
		driver.findElement(cart_badge).isDisplayed();
	}
	
	public void removeFromCart() {
		driver.findElement(btn_remove).click();
	}
	
	public boolean hideCartBadge() {
	    return driver.findElements(cart_badge).size() > 0;
	}
	
	public void clickProduct() {
		driver.findElement(btn_title_product_backpack).click();
	}

}
