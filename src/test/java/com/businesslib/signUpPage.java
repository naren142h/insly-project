package com.businesslib;

import static com.businesslib.commonLib.signUpUrl;
import com.genericlib.Driver;
import com.genericlib.WebDriverUtils;
import com.webElementRepository.adminAccountDetailsRep;
import com.webElementRepository.signUpPageRep;
import com.webElementRepository.termsAndConditionsRep;
import java.util.logging.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class signUpPage {

  public signUpPage() {
    super();
  }

  private static String errormessage=null;
  private static Logger Log = Logger.getLogger(org.apache.commons.logging.Log.class.getName());

  private static signUpPageRep signUpPage = PageFactory.initElements(Driver.driver, signUpPageRep.class);
  private static adminAccountDetailsRep adminAccountDetailsRep = PageFactory.initElements(Driver.driver, adminAccountDetailsRep.class);
  private static termsAndConditionsRep termsAndConditionsRep = PageFactory.initElements(Driver.driver, termsAndConditionsRep.class);

  public static void launchInsly() throws Exception {
    try{
      Driver.driver.get(signUpUrl);
      Log.info("URL is entered successfully");
      WebDriverUtils.waitVisibility(Driver.driver, signUpPage.getFormDiv(), 5);
      Log.info("Form div is displayed successfully");
    } catch(Exception e){
      errormessage = e.getMessage();
      throw new Exception(e);
    }
  }

  public static boolean validateSignUpTitle(){
    try {
      WebDriverUtils.waitVisibility(Driver.driver, signUpPage.getSignUpTitleTxt(), 5);
      return true;
    } catch (Exception e){
      return false;
    }
  }

  public static boolean validateCompanySubTitle(){
    try {
      WebDriverUtils.waitVisibility(Driver.driver, signUpPage.getCompanySubTitleTxt(), 5);
      return true;
    } catch (Exception e){
      return false;
    }
  }

  public static boolean validateAddUserSubTitle(){
    try {
      WebDriverUtils.waitVisibility(Driver.driver, signUpPage.getAddUserSubTitleTxt(), 5);
      return true;
    } catch (Exception e){
      return false;
    }
  }

  public static boolean validateAdminAccDetailsSubTitle(){
    try {
      WebDriverUtils.waitVisibility(Driver.driver, signUpPage.getAdminAccDetailsSubTitleTxt(), 5);
      return true;
    } catch (Exception e){
      return false;
    }
  }

  public static boolean validateTermsAndConditionsSubTitle(){
    try {
      WebDriverUtils.waitVisibility(Driver.driver, signUpPage.getTermsAndConditionsSubTitleTxt(), 5);
      return true;
    } catch (Exception e){
      return false;
    }
  }

  public static void fillCompanyDataName(String name) throws Exception {
    try{
      WebDriverUtils.waitClickable(Driver.driver, signUpPage.getCompanyNameInpt(), 5);
      signUpPage.getCompanyNameInpt().sendKeys(name);
    } catch(Exception e){
      errormessage = e.getMessage();
      throw new Exception(e);
    }
  }

  public static void selectCountry(String country) {
    Select cntry = new Select(signUpPage.getCompanyCountrySel());
    cntry.selectByVisibleText(country);
  }

  public static boolean validateAddressUrl(){
    try{
      String addressurl = signUpPage.getAddressUrl().getText();
      return addressurl != null;
    } catch (Exception e) {
      return false;
    }
  }

  public static void selectCompanyProfile(){
    Select profile = new Select(signUpPage.getCompanyProfile());
    profile.selectByIndex(1);
  }

  public static void selectCompanyEmployees(String employees){
    Select emp = new Select(signUpPage.getCompanyEmployeesSel());
    emp.selectByValue(employees);
  }

  public static void selectPersonDesc(){
    Select desc = new Select(signUpPage.getPersonDescriptionSel());
    desc.selectByIndex(1);
  }

  public static void fillAdminDetails(String email, String name, String password, String passwordrepeat, String phone){
    adminAccountDetailsRep.getAdminEmail().sendKeys(email);
    adminAccountDetailsRep.getAdminName().sendKeys(name);
    adminAccountDetailsRep.getAdminPassword().sendKeys(password);
    adminAccountDetailsRep.getAdminPasswordRepeat().sendKeys(passwordrepeat);
    adminAccountDetailsRep.getAdminPhone().sendKeys(phone);
  }

  public static void clickTermsAndCndts(){
    WebDriverUtils.waitVisibility(Driver.driver, termsAndConditionsRep.getTermsandcndtsLnk(), 5);
    termsAndConditionsRep.getTermsandcndtsLnk().click();
    WebDriverUtils.waitVisibility(Driver.driver, termsAndConditionsRep.getTermsCndtsDiv(), 5);
    termsAndConditionsRep.getTermsCndtsDiv().click();
    WebDriverUtils.waitVisibility(Driver.driver, termsAndConditionsRep.gettAndCAgreeBtn(), 5);
    termsAndConditionsRep.gettAndCAgreeBtn().click();
    termsAndConditionsRep.getPrivacypolicyLnk().click();
    WebDriverUtils.waitVisibility(Driver.driver, termsAndConditionsRep.getPrivacypolicyDiv(), 5);
    termsAndConditionsRep.getPrivacypolicyDiv().click();
    WebDriverUtils.waitVisibility(Driver.driver, termsAndConditionsRep.getPrivacypolicyDiv(), 5);
    WebDriverUtils.scrollToBottom(Driver.driver);
    termsAndConditionsRep.getPrivacypolicyCloseBtn().click();
    termsAndConditionsRep.getPrivacypolicyCbox().click();
    termsAndConditionsRep.getAgreeDataStorageCBox().click();
  }

  public static boolean validateSignupBtn(){
    try{
      WebDriverUtils.waitClickable(Driver.driver, signUpPage.getSaveBtn(), 5);
      return true;
    } catch (Exception e){
      return false;
    }
  }

  public static void clickSignUpBtn(){
      WebDriverUtils.waitClickable(Driver.driver, signUpPage.getSaveBtn(), 5);
      signUpPage.getSaveBtn().click();
  }
}
