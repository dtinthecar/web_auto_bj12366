package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebAutoUtils {
	public static WebDriver getWebDriver(String browserName,String SeliniumVersion) {
		WebDriver driver = null;
		if (browserName.equalsIgnoreCase("IE")) {
			driver=getIEDriver();
		}
		else if (browserName.equalsIgnoreCase("Chrome")) {
			driver = getChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("Firefox")) {
			if(!SeliniumVersion.equalsIgnoreCase("2.x")) {
				driver = getFireFoxDriver();
			}
			
		}
		else if (browserName.equalsIgnoreCase("Edge")) {
			driver = getEdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("Opera")) {
			// TODO Auto-generated method stub
		}
		else if (browserName.equalsIgnoreCase("Safiri")) {
			// TODO Auto-generated method stub
		}
		else {
			throw new RuntimeException("没有对应的浏览器");
		}
		return driver;

	}

	private static WebDriver getEdgeDriver() {
		WebDriver driver;
		System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, "src/main/resources/driver/MicrosoftWebDriver.exe");
		driver = new EdgeDriver();
		return driver;
	}

	private static WebDriver getFireFoxDriver() {
		WebDriver driver;
		System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, "src/main/resources/driver/geckodriver.exe");
		driver = new FirefoxDriver();
		return driver;
	}

	private static WebDriver getChromeDriver() {
		WebDriver driver;
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "src/main/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	private static WebDriver getIEDriver() {
		WebDriver driver;
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY, "src/main/resources/driver/IEDriverServer.exe");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://www.baidu.com");
		driver=new InternetExplorerDriver(capabilities);
		return driver;
	}

}
