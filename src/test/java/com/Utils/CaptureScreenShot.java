package com.Utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenShot {

  public static String captureScreen(WebDriver driver, String screenName) throws IOException {
    // PropertiesManager prop = new PropertiesManager();
    TakesScreenshot screen = (TakesScreenshot) driver;
    File src = screen.getScreenshotAs(OutputType.FILE);
    // String dest = "C:\\report\\images\\" + screenName + ".png";
    String dest = "./report/" + screenName + ".png";
    File target = new File(dest);
    FileUtils.copyFile(src, target);
    return dest;
  }
}
