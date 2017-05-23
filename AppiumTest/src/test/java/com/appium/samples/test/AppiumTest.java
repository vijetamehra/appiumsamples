package com.appium.samples.test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

/**
 * Base class for common code for IOS and Android Test cases
 * 
 * @author Vijeta
 *
 */
public class AppiumTest {
	
    protected static AppiumDriver driver;
    protected static URL url;
    protected static DesiredCapabilities desiredCapabilities;

    @AfterClass
    public static void tearDownClass() {
        if (driver != null) {               
            driver.quit();
        }           
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception{
    	
    }
    
    protected static void initURL() throws MalformedURLException{
        url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new IOSDriver<WebElement>(url, desiredCapabilities);
    }
    
    @Test
    public void loginTest() throws IOException {
        WebElement fieldUN = driver.findElement(By.name("Username"));
        fieldUN.clear();
        fieldUN.sendKeys("");
        WebElement fieldpwd = driver.findElement(By.name("Password"));
        fieldpwd.clear();
        fieldpwd.sendKeys("");
        
        WebElement button = driver.findElement(By.name("Log In"));
        button.click();
        
        try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
