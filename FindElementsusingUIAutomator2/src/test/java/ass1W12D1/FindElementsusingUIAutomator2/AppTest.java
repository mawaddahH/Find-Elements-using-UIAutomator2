package ass1W12D1.FindElementsusingUIAutomator2;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private AndroidDriver driver;

	@BeforeSuite
	public void setUp() throws MalformedURLException, InterruptedException {

		// Setting up desire caps using DesireCapabilities class
		// Create an object for Desired Capabilities
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

		// Set capabilities
		desiredCapabilities.setCapability("appium:app",
				"C:\\Users\\lo0ol\\Downloads\\QA_class_app_resources.zip, attachment\\QA class app resources\\ApiDemos-debug.apk");
		desiredCapabilities.setCapability("appium:deviceName", "23b9cb400c1c7ece");
		desiredCapabilities.setCapability("appium:platformName", "Android");
		desiredCapabilities.setCapability("appium:platformVersion", "10");
		desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
		desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
		desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
		// Java package of the Android app you want to run
		desiredCapabilities.setCapability("appium:appPackage", "io.appium.android.apis");
		// Activity name for the Android activity you want to launch from your package
		desiredCapabilities.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");

		System.out.println("Finshed: desiredCapabilities");

		// Initialize the driver object with the URL to Appium Server and
		// passing the capabilities
		URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		System.out.println("Finshed: driver");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	

	/**
	 * Test UIAutomator2
	 */
	@Test(priority = 1)
	public void TestUIAutomator2() throws InterruptedException {	
		Navigation navigate = driver.navigate();

		// Perform the action on the element
		// click on "View"
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		System.out.println("Finshed: Views");
		Thread.sleep(4000);
		
		// FindElement By Text "Seek Bar"
		WebElement element = driver.findElement(new AppiumBy.ByAndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().text(\"Seek Bar\"))"));
		element.click();
		System.out.println("Finshed: FindElement Seek Bar");
		Thread.sleep(4000);

        
		// back to Page
		navigate.back();
		System.out.println("Finshed: back to \"My account\" Page");
		Thread.sleep(3000);
		
		// flingBackward (performs quick swipe)
		try {
		    driver.findElement(new AppiumBy.ByAndroidUIAutomator(
		            "new UiScrollable(new UiSelector().scrollable(true)).flingBackward()"));
			System.out.println("Finshed: flingBackward (performs quick swipe)");

			Thread.sleep(3000);

		} catch (InvalidSelectorException e) {
		    // ignore
		}
		
	
		
		// FindElement By id for "Animation"
		WebElement element1 = driver.findElement(new AppiumBy.ByAndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().resourceIdMatches(\"android:id/text1*\"))"));
		System.out.println("Finshed: FindElement By id = "+ element1.getText());
		element1.click();
		Thread.sleep(3000);

		
		// back to Page
		navigate.back();
		System.out.println("Finshed: back");
		Thread.sleep(3000);
		
		
		// flingToBeginning (performs quick swipes. 10 swipes max)
		try {
		    driver.findElement(new AppiumBy.ByAndroidUIAutomator(
		            "new UiScrollable(new UiSelector().scrollable(true)).flingToBeginning(10)"));
			System.out.println("Finshed: flingToBeginning (performs quick swipes. 10 swipes max)");
			Thread.sleep(3000);

		} catch (InvalidSelectorException e) {
		    // ignore
		}
		
		// FindElement By id and Text for "Layout Animation"
		WebElement element3 = driver.findElement(new AppiumBy.ByAndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().resourceIdMatches(\"android:id/text1\").text(\"Layout Animation\"))"));
		element3.click();
		System.out.println("Finshed: FindElement By id and Text for \"Layout Animation\"");
		Thread.sleep(3000);
		
		// back to Page
		navigate.back();
		System.out.println("Finshed: back");
		Thread.sleep(3000);
		
		// flingForward (performs quick swipe)
		try {
		    driver.findElement(new AppiumBy.ByAndroidUIAutomator(
		            "new UiScrollable(new UiSelector().scrollable(true)).flingForward()"));
			System.out.println("Finshed: flingForward (performs quick swipe)");
			Thread.sleep(3000);
		} catch (InvalidSelectorException e) {
		    // ignore
		}

		// set max swipes to 10
		// FindElement by Test and max swipes for "Drag and Drop"
		WebElement element4 = driver.findElement(new AppiumBy.ByAndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes(10)" +
		         ".scrollIntoView(new UiSelector().text(\"Drag and Drop\"))"));
		element4.click();
		System.out.println("Finshed: FindElement by Test and max swipes for \"Drag and Drop\"");
		Thread.sleep(3000);
		
		
		// back to Page
		navigate.back();
		System.out.println("Finshed: back");
		Thread.sleep(3000);

	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		System.out.println("Finshed: quit");
	}
}
