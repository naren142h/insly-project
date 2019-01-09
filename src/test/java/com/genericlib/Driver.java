package com.genericlib;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
                
                public static WebDriver driver;		
		              //Chrome browser
		                
		                public static WebDriver configChromeBrowser() {
		            		// TODO Auto-generated method stub
		            		System.setProperty("webdriver.chrome.driver", "/Users/Naren/Desktop/insly-project/Utilities/drivers/mac/chromedriver");
		            		ChromeOptions options = new ChromeOptions();
		            		options.addArguments("--disable-extensions");
		            		Map<String, Object> prefs = new HashMap<String, Object>();
		    		        prefs.put("profile.default_content_setting_values.notifications", 2);
		    		        options.setExperimentalOption("prefs", prefs);
		            		driver =new ChromeDriver(options);
		            		//@SuppressWarnings("unused")
							      WebDriver globaldriver = driver;
		            		driver.manage().window().fullscreen(); //for Mac
										//driver.manage().window().maximize(); //For windows
		            		return driver;
		            	}
}