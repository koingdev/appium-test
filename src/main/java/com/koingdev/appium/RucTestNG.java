package com.koingdev.appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;


public class RucTestNG {

  private IOSDriver driver;

  @BeforeMethod
  public void setUp() throws MalformedURLException {
	  /*
	   * Define the Capabilities of iPhone Simulator
	   */
	  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	  desiredCapabilities.setCapability("deviceName", "iPhone Simulator");
	  desiredCapabilities.setCapability("platformVersion", "10.3");
	  desiredCapabilities.setCapability("platformName", "iOS");
	  desiredCapabilities.setCapability("bundleId", "koingdev.rise-up");
	  desiredCapabilities.setCapability("autoLaunch", true);
	  desiredCapabilities.setCapability("automationName", "Appium");
	  desiredCapabilities.setCapability("udid", "6FD588A9-4200-4490-B41D-E774F44FF67B");

	  URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

	  driver = new IOSDriver(remoteUrl, desiredCapabilities);
  }

  /*
   * This test-case is used for comparing the default screen name
   * if it equals Android, the test succeed
   * The test execution order is based on priority (start from zero)
   */
  @Test (priority=0)
  public void testCheckDefaultScreenName(){
	  MobileElement el = (MobileElement)driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Android\"]");
	  String defaulScreenName = el.getText();
	  //check whether default screen name equals Android
	  Assert.assertEquals(defaulScreenName, "Android");
  }
  
  /*
   * This test-case is used for clicking on the MENU Button
   */
  @Test (priority=10)
  public void testClickOnMenu(){
	  driver.findElementByName("menu").click();
  }
  
  /*
   * This test-case is used for clicking on the first UITableView cell
   */
  @Test (priority=20)
  public void testClickOnFirstCell() {
	  MobileElement el = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"rise-up\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]");
	  el.click();
  }

  @AfterMethod
  public void takeBreak() {
	  try {
		//delay 1sec before exit
		Thread.sleep(1000);
		//driver.quit();
	  } catch (InterruptedException e) {
		e.printStackTrace();
	  }
  }
}
