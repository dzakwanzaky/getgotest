package object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class draggable_page {
	
	WebDriver driver;
	
	By drag_box = By.id("draggable");
	
	public draggable_page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void dragImage() {
		
		Actions action = new Actions(driver);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		WebElement element = driver.findElement(drag_box);
		
		action.dragAndDropBy(element, 300, 150).perform();
	}
}
