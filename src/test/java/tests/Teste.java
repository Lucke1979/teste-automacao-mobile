package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.DesiredCapabilities;

import config.PageBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import junit.framework.TestCase;


@RunWith(Cucumber.class)
@CucumberOptions(features="resources/features", glue="steps")
public class Teste extends TestCase{
	
	public static AndroidDriver<MobileElement> driver;
	
	public static DesiredCapabilities desiredCapabilities;
	
	
	@BeforeClass
	public static void before() {
		
		desiredCapabilities = new DesiredCapabilities();
		
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "ce071827b85d4e09047e");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
	    desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
	    
	    try {
			driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	    try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    PageBase.driver = driver;
	}
	
		
	
	@AfterClass
	public static void after() {
		driver.quit();
	}
	
}