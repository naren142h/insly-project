package com.genericlib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
  static Robot robot;
  boolean status = true;
  public void waitForPageToLoad(){
    Driver.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

  }

  public void waitForLinkTextPresent(String Xpath){
    WebElement element = (new WebDriverWait(Driver.driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)));
    element.click();
  }

  public static void scrollToBottom(WebDriver driver) {
    ((JavascriptExecutor) driver)
        .executeScript("window.scrollTo(0, document.body.scrollHeight)");
  }

  public static void scrollToTop(WebDriver driver) {
    ((JavascriptExecutor) driver)
        .executeScript("window.scrollTo(document.body.scrollHeight,0)");
  }

  public void waitForXpathPresent(String wbXpath){
    WebDriverWait wait = new WebDriverWait(Driver.driver, 30);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(wbXpath)));
  }

  public boolean verifyText(String wbXpath , String expectedText){
    boolean flag= false;
    String actText = Driver.driver.findElement(By.xpath
        (wbXpath)).getText();
    if(expectedText.equals(actText)){
      flag=true;
      System.out.println(expectedText + "=text is verified==>PASS");
    }else{
      System.out.println(expectedText + "=text is not verified==>FAIL");
    }
    return flag;
  }

  public void selectByVisibleText(WebElement wbName , String visibleText){
    Select sel = new Select(wbName);
    sel.selectByVisibleText(visibleText);
  }

  public void selectByValue(WebElement wbName , String value){
    Select sel = new Select(wbName);
    sel.selectByValue(value);
  }

  public void selectByIndex(String xpath , int index){
    Select sel = new Select(Driver.driver.findElement(By.xpath(xpath)));
    sel.selectByIndex(index);
  }

  public void acceptAlert(){
    WebDriverWait wait = new WebDriverWait(Driver.driver, 5);
    wait.until(ExpectedConditions.alertIsPresent());
    Alert alt = Driver.driver.switchTo().alert();
    System.out.println(alt.getText());
    alt.accept();
  }

  public void dismissAlert(){
    Alert alt = Driver.driver.switchTo().alert();
    System.out.println(alt.getText());
    alt.dismiss();
  }

  public void mouseOver(String wbxpath){
    WebElement wb = Driver.driver.findElement
        (By.xpath(wbxpath));
    Actions act = new Actions(Driver.driver);
    act.moveToElement(wb).perform();

  }

  private static void configRobot()
  {
    try {
      robot=new Robot();
    } catch (AWTException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void clickEscape()
  {
    configRobot();
    robot.keyPress(KeyEvent.VK_ESCAPE);
  }

  public static void waitVisibility(WebDriver driver, WebElement element, int time){
    WebDriverWait wait = new WebDriverWait(driver, time);
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  public static void waitClickable(WebDriver driver, WebElement element, int time){
    WebDriverWait wait = new WebDriverWait(driver, time);
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  public static void waitSelected(WebDriver driver, WebElement element, int time){
    WebDriverWait wait = new WebDriverWait(driver, time);
    wait.until(ExpectedConditions.elementToBeSelected(element));
  }

  public static void waitAlert(WebDriver driver, int time){
    WebDriverWait wait = new WebDriverWait(driver, time);
    wait.until(ExpectedConditions.alertIsPresent());
  }
}
