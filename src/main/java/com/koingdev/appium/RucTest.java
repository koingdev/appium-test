package com.koingdev.appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

/*
 * This will start our test-case from A - Z (ASC)
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RucTest {

  private IOSDriver driver;

  @Before
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
   */
  @Test
  public void A_checkDefaultScreenName(){
	  MobileElement el = (MobileElement)driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Android\"]");
	  String defaulScreenName = el.getText();
	  //check whether default screen name equals Android
	  assertEquals(defaulScreenName, "Android");
  }
  
  /*
   * This test-case is used for clicking on the MENU Button
   */
  @Test
  public void C_clickOnMenu(){
	  driver.findElementByName("menu").click();
  }
  
  /*
   * This test-case is used for clicking on the first UITableView cell
   */
  @Test
  public void B_clickOnFirstCell() {
	  MobileElement el = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"rise-up\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]");
	  el.click();
  }

  @After
  public void tearDown() {
	  try {
		//delay 1sec before exit
		Thread.sleep(1000);
		driver.quit();
	  } catch (InterruptedException e) {
		e.printStackTrace();
	  }
  }
}
