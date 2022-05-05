package hotelbooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HotelBooking {

	public static String browser = "chrome"; // External configuration - XLS, CSV
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get(Constants.TARGET_URL);
		driver.manage().window().maximize();
		driver.findElement(By.id(Constants.FIRST_NAME)).sendKeys(Constants.TEST_NAME);
		driver.findElement(By.id(Constants.LAST_NAME)).sendKeys(Constants.TEST_SURNAME);
		driver.findElement(By.id(Constants.TOTAL_PRICE)).sendKeys(Constants.TEST_PRICE);
		driver.findElement(By.id(Constants.DEPOSIT_PAID)).sendKeys(Constants.TEST_DEPOSIT_PAID);
		driver.findElement(By.id(Constants.CHECK_IN)).sendKeys(Constants.TEST_CHECK_IN);
		driver.findElement(By.id(Constants.CHECK_OUT)).sendKeys(Constants.TEST_CHECK_OUT);
		driver.findElement(By.xpath(Constants.SAVE_BUTTON)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(Constants.DELETE_BUTTON)).click();
		//driver.close(); 

	}

}
