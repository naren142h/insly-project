package com.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class HtmlReport {
  private static ExtentHtmlReporter htmlReporter;
  private static ExtentReports reports;
  WebDriver driver;
  private static final DateFormat dateFormat = new SimpleDateFormat("hhmmSSS");

  public HtmlReport(WebDriver drivers) {
    this.driver = drivers;
  }

  private ExtentHtmlReporter getInstanceHtmlReporter() throws Exception {
    if (htmlReporter == null) {
      String testSuite = System.getProperty("dlx.testsuite");
      String rutaHtml = "./report/";
      File dir = new File(rutaHtml);
      if (!dir.exists())
        dir.mkdirs();
      htmlReporter = new ExtentHtmlReporter(rutaHtml + "suite.html");
      htmlReporter.loadConfig(System.getProperty("user.dir") + "/extent-config.xml");
      htmlReporter.config().setDocumentTitle("Reporte Prueba 1");
      htmlReporter.config().setReportName("Test " + testSuite);
      htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
      htmlReporter.config().setTheme(Theme.STANDARD);
      htmlReporter.config().setFilePath("./report/");
      htmlReporter.setAppendExisting(true);
      htmlReporter.config().setCSS("td.step-details img {width:50% !important;}");
    }
    return htmlReporter;
  }

  public ExtentReports getReport() throws Exception {
    if (reports == null) {
      reports = new ExtentReports();
      reports.attachReporter(getInstanceHtmlReporter());
      reports.setSystemInfo("Browser", System.getProperty("dlx.driver"));
      reports.setSystemInfo("Country", System.getProperty("dlx.country"));
      reports.setSystemInfo("Environment", System.getProperty("dlx.environment"));
      reports.setSystemInfo("Node", System.getProperty("dlx.namenode"));
      reports.setSystemInfo("Execution", System.getProperty("dlx.build"));
    }
    return reports;
  }

  private MediaEntityModelProvider addScreenCapture() throws Exception {
    Random random = new Random();
    Date date = new Date();
    String imageName = String.valueOf(random.nextInt(10000));
    imageName = imageName + "_" + dateFormat.format(date);
    String screenShot = CaptureScreenShot.captureScreen(this.driver, imageName);
    return MediaEntityBuilder.createScreenCaptureFromPath(screenShot.toString()).build();
  }

  public void debug(ExtentTest extentTest, String message, boolean capture) {
    addMessage(extentTest, Status.DEBUG, message, capture);
  }

  public void info(ExtentTest extentTest, String message, boolean capture) {
    addMessage(extentTest, Status.INFO, message, capture);
  }

  public void skip(ExtentTest extentTest, String message, boolean capture) {
    addMessage(extentTest, Status.SKIP, message, capture);
  }

  public void pass(ExtentTest extentTest, String message, boolean capture) {
    addMessage(extentTest, Status.PASS, message, capture);
  }

  public void fail(ExtentTest extentTest, String message, boolean capture) {
    addMessage(extentTest, Status.FAIL, message, capture);
  }

  public void warning(ExtentTest extentTest, String message, boolean capture) {
    addMessage(extentTest, Status.WARNING, message, capture);
  }

  public void error(ExtentTest extentTest, String message, boolean capture) {
    addMessage(extentTest, Status.ERROR, message, capture);
  }

  public void faltal(ExtentTest extentTest, String message, boolean capture) {
    addMessage(extentTest, Status.FATAL, message, capture);
  }

  public void addMessage(ExtentTest extentTest, Status status, String message, boolean capture) {
    try {
      if (capture)
        extentTest.log(status, message, addScreenCapture());
      else
        extentTest.log(status, message);
    } catch (Exception e) {
      System.out.println("\n"
          + "Error adding message and capture in extent report " + e.toString());
    }
  }

  public void addSystemInfo(ExtentTest extentTest, String info) {
    String[] infos = info.split(",");
    extentTest.assignCategory(infos);
  }

  public void generateStep(ExtentTest extentTest, ITestResult result, String message) {
    try {
      if (result.getStatus() == ITestResult.FAILURE) {
        fail(extentTest, result.getThrowable().getMessage(), true);
      } else if (result.getStatus() == ITestResult.SUCCESS) {
        pass(extentTest, message, true);
      } else if (result.getStatus() == ITestResult.SKIP) {
        skip(extentTest, message, true);
      }
    } catch (Exception e) {
      System.out.println("Error al generar Paso " + e.toString());
    }
  }

  public void leerHtml() {
    String rutaHtml = "./report/suite.html";
    try {
      File htmlTemplateFile = new File(rutaHtml);
      String htmlString = FileUtils.readFileToString(htmlTemplateFile);
      htmlString = htmlString.replace("./report", ".");
      File newHtmlFile = new File(rutaHtml);
      FileUtils.writeStringToFile(newHtmlFile, htmlString);
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("Error " + e.toString());
    }
  }

  public String returnStateCase(ITestResult result) {
    String resultado = "";
    switch (result.getStatus()) {
      case 1:
        resultado = "PASSED";
        break;
      case 2:
        resultado = "FAILED";
        break;
      case 3:
        resultado = "SKIP";
        break;
      default:
        resultado = "Invalid Result";
        break;
    }
    return resultado;
  }
}
