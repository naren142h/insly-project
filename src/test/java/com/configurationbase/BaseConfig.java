package com.configurationbase;

import static com.businesslib.signUpPage.*;
import com.Utils.HtmlReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.businesslib.commonLib;
import com.businesslib.signUpPage;
import com.genericlib.Driver;
import com.genericlib.WebDriverUtils;
import java.lang.reflect.Method;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.DriverFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseConfig {


  public WebDriver driver;
  public DriverFactory factory;
  ExtentReports report;
  ExtentHtmlReporter htmlReporter;
  public String nameClass = "";
  public static ExtentTest test;
  public static HtmlReport htrep;
  private Driver dLib;
  private WebDriverUtils wLib;
  private commonLib cLib;
  private signUpPage signUpPage;
  private static Logger Log = Logger.getLogger(org.apache.commons.logging.Log.class.getName());

  @BeforeMethod(alwaysRun = true)
  public void beforeMethodSetup(Method method) throws Exception {
    Driver.configChromeBrowser();
    wLib = new WebDriverUtils();
    cLib = new commonLib();
    dLib = new Driver();
    signUpPage = new signUpPage();
    htrep = new HtmlReport(driver);
    report = htrep.getReport();
    nameClass = this.getClass().getName().substring(
        this.getClass().getPackage().getName().length() + 1, this.getClass().getName().length());
    // log description test
    String description = "";
    Test testName = method.getAnnotation(Test.class);
    description = (testName != null) ? testName.description() : "";
    test = report.createTest(nameClass, "Description Test : " + description);
    launchInsly();
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethodSetup(ITestResult result) {
    Driver.driver.manage().deleteAllCookies();
    htrep.generateStep(test, result, "Case executed " + nameClass);
    report.flush();
    htrep.leerHtml();
    Driver.driver.quit();
  }
}