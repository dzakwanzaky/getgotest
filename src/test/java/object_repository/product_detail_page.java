package object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class product_detail_page {
	
	WebDriver driver;
	
	By btn_back = By.id("back-to-products");
	
	By title_product_detail = By.xpath("//div[contains(text(), \"Sauce Labs Backpack\")]");
	
	public product_detail_page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void redirectProductDetail() {
		driver.findElement(btn_back).isDisplayed();
		driver.findElement(title_product_detail).isDisplayed();
	}

}
