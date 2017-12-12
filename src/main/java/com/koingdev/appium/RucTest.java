package com.koingdev.appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RucTest {

  private IOSDriver driver;

  @Before
  public void setUp() throws MalformedURLException {
	  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	  desiredCapabilities.setCapability("deviceName", "iPhone Simulator");
	  desiredCapabilities.setCapability("platformVersion", "10.3");
	  desiredCapabilities.setCapability("platformName", "iOS");
	  desiredCapabilities.setCapability("bundleId", "koingdev.rise-up");
	  desiredCapabilities.setCapability("autoLaunch", true);
	  desiredCapabilities.setCapability("automationName", "Appium");
	  desiredCapabilities.setCapability("udid", "6FD588A9-4200-4490-B41D-E774F44FF67B");

	  URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	  driver = new IOSDriver(remoteUrl, desiredCapabilities);
  }

  @Test
  public void checkDefaultScreenName(){
	  MobileElement el = (MobileElement)driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Android\"]");
	  String defaulScreenName = el.getText();
	  //check whether default screen name equals Android
	  assertEquals(defaulScreenName, "Android");
	  System.out.println(defaulScreenName);
  }
  
  @Test
  public void clickOnMenu(){
	  driver.findElementByName("menu").click();
  }
  
  @Test
  public void clickOnFirstCell() {
	  MobileElement el1 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"rise-up\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]");
	  el1.click();
  }

  @After
  public void tearDown() {
	  try {
		//delay 1sec before exit
		Thread.sleep(1000);
		driver.quit();
	  } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
  }
}
