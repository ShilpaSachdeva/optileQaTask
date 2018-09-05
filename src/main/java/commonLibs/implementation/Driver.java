package commonLibs.implementation;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commonLibs.contracts.IDriver;

public class Driver implements IDriver {

	private WebDriver driver;

	private int pageLoadTimeout;
	private int elementDetectionTimeout;

	public WebDriver getDriver() {
		return driver;
	}

	public void setPageLoadTimeout(int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}

	public Driver(String browserType) throws Exception {

		String currentDir = new java.io.File(".").getCanonicalPath();

		String pathSeparator = File.separator;

		elementDetectionTimeout = 5;

		pageLoadTimeout = 60;

		browserType = browserType.trim();

		String os = System.getProperty("os.name").toLowerCase();

		if ((browserType.equalsIgnoreCase("chrome")) && os.contains("mac")) {

			System.setProperty("webdriver.chrome.driver",

					currentDir + pathSeparator + "drivers" + pathSeparator + "chromedriver");

			driver = new ChromeDriver();

		}

		else if ((browserType.equalsIgnoreCase("chrome")) && os.contains("windows")) {

			System.setProperty("webdriver.chrome.driver",

					currentDir + pathSeparator + "drivers" + pathSeparator + "chromedriver.exe");

			driver = new ChromeDriver();

		}

		else if ((browserType.equalsIgnoreCase("firefox")) && os.contains("mac")) {

			System.setProperty("webdriver.gecko.driver",

					currentDir + pathSeparator + "drivers" + pathSeparator + "geckodriver");

			driver = new FirefoxDriver();

		}

		else if ((browserType.equalsIgnoreCase("firefox")) && os.contains("windows")) {

			System.setProperty("webdriver.gecko.driver",

					currentDir + pathSeparator + "drivers" + pathSeparator + "geckodriver.exe");

			driver = new FirefoxDriver();

		}

		else {

			throw new Exception("Invalid Browser type : " + browserType);

		}

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

	}

	public void navigateToFirstUrl(String url) throws Exception {

		url = url.trim();

		if (url.isEmpty() || url == null) {
			throw new Exception("Url is empty or null");
		}

		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);

		driver.get(url);

	}

	public String getTitle() throws Exception {

		return driver.getTitle();
	}

	public String getCurrentUrl() throws Exception {

		return driver.getCurrentUrl();
	}

	public String getPageSource() throws Exception {

		return driver.getPageSource();
	}

	public void navigateToUrl(String url) throws Exception {

		url = url.trim();

		if (url.isEmpty() || url == null) {
			throw new Exception("Url is empty or null");
		}
		driver.navigate().to(url);

	}

	public void navigateForward() throws Exception {
		driver.navigate().forward();

	}

	public void navigateBackward() throws Exception {
		driver.navigate().back();

	}

	public void refresh() throws Exception {
		driver.navigate().refresh();

	}

	public void closeBrowser() throws Exception {
		driver.close();

	}

	public void closeAllBrowsers() throws Exception {
		driver.quit();

	}

}
