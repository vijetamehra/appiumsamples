package com.appium.samples.test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Following Test class executes Appium Test cases for IOS
 * 
 * @author Vijeta
 *
 */
public class AppiumIOSTest extends AppiumTest {

    @BeforeClass
    public static void setUpClass() throws MalformedURLException {
    	
    	//TODO - Read these properties from a property file 
         desiredCapabilities = new DesiredCapabilities();
        
        //Provide platform ios or android
        desiredCapabilities.setCapability("platformName", "iOS");
        
        //Only required for IOS
        desiredCapabilities.setCapability("automationName", "XCUITest");
        
        //Provide device details or simulator 
        desiredCapabilities.setCapability("udid", "");
        desiredCapabilities.setCapability("deviceName", "");
        
        //Either bundleId or app file generated from XCode which needs provisioning profile and certs for the below bundle id
        desiredCapabilities.setCapability("bundleId", "");
        
        //Path required for IOS where WebDriverAgent app will be generated
        desiredCapabilities.setCapability("bootstrapPath", "/usr/local/lib/node_modules/appium-xcuitest-driver/WebDriverAgent");
        desiredCapabilities.setCapability("agentPath", "/usr/local/lib/node_modules/appium-xcuitest-driver/WebDriverAgent/WebDriverAgent.xcodeproj");
        
//      desiredCapabilities.setCapability("xcodeOrgId", "<<Team Id>>");
//      desiredCapabilities.setCapability("xcodeSigningId", "iPhone Developer");
        initURL();
    }

    public static void main(String[] args) {
			try {
				AppiumIOSTest aios = new AppiumIOSTest();
				AppiumIOSTest.setUpClass();
				aios.loginTest();
				AppiumIOSTest.tearDownClass();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

	}
}