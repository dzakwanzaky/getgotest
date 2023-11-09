package object_repository;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class about_page {
	
	WebDriver driver;
	
	By page_logo = By.xpath("//img[contains(@src, '/images/logo.svg')]");
	
	public about_page(WebDriver driver) {
		this.driver = driver;
	}
	
		
	public void swipeElement() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[6]/div[2]/div/div/div/div[1]/div/div"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);	
		
		Actions action = new Actions(driver);
        action.dragAndDropBy(element, 500, 0).build().perform();
        
		
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.COMMAND, Keys.ADD));
		
		
	}
	
	public void zoomPage() {
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("document.body.style.zoom = '1.5'");		

		
	}

	
	
}
