package object_repository;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

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
	
	By backpack_image = By.xpath("//img[contains(@alt, 'Sauce Labs Backpack')]");
	
	By bike_light = By.xpath("//img[contains(@alt, 'Sauce Labs Bike Light')]");
	
	By red_tshirt = By.xpath("//img[contains(@alt, 'Test.allTheThings() T-Shirt (Red)')]");
	
	By active_option = By.xpath("//span[contains(text(), 'Name (Z to A)')]");
	
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
	
	public void goToAbout() {
		driver.findElement(btn_sidebar).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.findElement(btn_about_sidebar).click();
	}
	
	public void selectDropdown() {
		Select dropdown = new Select(driver.findElement(By.xpath("//select[contains(@class, 'product_sort_container')]")));
		dropdown.selectByIndex(1);

	}
	
	public void activeDropdown() {
		driver.findElement(active_option).isDisplayed();
	}
	
	public void compareImage() throws IOException, InterruptedException {
		String projectPath = System.getProperty("user.dir");
		
		WebElement ImageBackpack = driver.findElement(backpack_image);
		WebElement TitlePage = driver.findElement(title_page);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", TitlePage);
        
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        if(!(Boolean) js.executeScript("return (typeof jQuery != \"undefined\")")) {
            js.executeScript(
                    "var headID = document.getElementsByTagName('head')[0];" +
                            "var newScript = document.createElement('script');" +
                            "newScript.type = 'text/javascript';" +
                            "newScript.src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js';" +
                            "headID.appendChild(newScript);");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            Function<WebDriver, Boolean> jQueryAvailable = WebDriver -> (
                    (Boolean) js.executeScript("return (typeof jQuery != \"undefined\")")
            );
            wait.until(jQueryAvailable);
        }
		
		Screenshot ImageBackpackScreenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver, ImageBackpack);
		ImageIO.write(ImageBackpackScreenshot.getImage(),"png",new File(projectPath+"/src/test/resources/image/backpack.png"));
		
		BufferedImage expectedImage = ImageIO.read(new File(projectPath+"/src/test/resources/image/backpack.png"));

		
		BufferedImage actualImage = ImageBackpackScreenshot.getImage();
		
		ImageDiffer imgDiff = new ImageDiffer();
			ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
			Assert.assertFalse("Visual differences found!", diff.hasDiff());
	}

}
