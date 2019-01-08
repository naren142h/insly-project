package src.test.java.com.businesslib;

import static src.test.java.com.businesslib.commonLib.signUpUrl;
import java.util.logging.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import src.test.java.com.genericlib.Driver;
import src.test.java.com.genericlib.WebDriverUtils;
import src.test.java.com.webElementRepository.signUpPageRep;
import src.test.java.com.webElementRepository.adminAccountDetailsRep;
import src.test.java.com.webElementRepository.termsAndConditionsRep;

public class signUpPage {

  public signUpPage() {
    super();
  }

  private String errormessage=null;
  private static Logger Log = Logger.getLogger(org.apache.commons.logging.Log.class.getName());

  private signUpPageRep signUpPage = PageFactory.initElements(Driver.driver, signUpPageRep.class);
  private adminAccountDetailsRep adminAccountDetailsRep = PageFactory.initElements(Driver.driver, adminAccountDetailsRep.class);
  private termsAndConditionsRep termsAndConditionsRep = PageFactory.initElements(Driver.driver, termsAndConditionsRep.class);

  public void launchInsly() throws Exception {
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

  public boolean validateSignUpTitle(){
    try {
      WebDriverUtils.waitVisibility(Driver.driver, signUpPage.getSignUpTitleTxt(), 5);
      return true;
    } catch (Exception e){
      return false;
    }
  }

  public boolean validateCompanySubTitle(){
    try {
      WebDriverUtils.waitVisibility(Driver.driver, signUpPage.getCompanySubTitleTxt(), 5);
      return true;
    } catch (Exception e){
      return false;
    }
  }

  public boolean validateAddUserSubTitle(){
    try {
      WebDriverUtils.waitVisibility(Driver.driver, signUpPage.getAddUserSubTitleTxt(), 5);
      return true;
    } catch (Exception e){
      return false;
    }
  }

  public boolean validateAdminAccDetailsSubTitle(){
    try {
      WebDriverUtils.waitVisibility(Driver.driver, signUpPage.getAdminAccDetailsSubTitleTxt(), 5);
      return true;
    } catch (Exception e){
      return false;
    }
  }

  public boolean validateTermsAndConditionsSubTitle(){
    try {
      WebDriverUtils.waitVisibility(Driver.driver, signUpPage.getTermsAndConditionsSubTitleTxt(), 5);
      return true;
    } catch (Exception e){
      return false;
    }
  }

  public void fillCompanyDataName(String name) throws Exception {
    try{
      WebDriverUtils.waitClickable(Driver.driver, signUpPage.getCompanyNameInpt(), 5);
      signUpPage.getCompanyNameInpt().sendKeys(name);
    } catch(Exception e){
      errormessage = e.getMessage();
      throw new Exception(e);
    }
  }

  public void selectCountry(String country) {
    Select cntry = new Select(signUpPage.getCompanyCountrySel());
    cntry.selectByVisibleText(country);
  }

  public boolean validateAddressUrl(){
    try{
      String addressurl = signUpPage.getAddressUrl().getText();
      return addressurl != null;
    } catch (Exception e) {
      return false;
    }
  }

  public void selectCompanyProfile(){
    Select profile = new Select(signUpPage.getCompanyProfile());
    profile.selectByIndex(1);
  }

  public void selectCompanyEmployees(String employees){
    Select emp = new Select(signUpPage.getCompanyEmployeesSel());
    emp.selectByValue(employees);
  }

  public void selectPersonDesc(){
    Select desc = new Select(signUpPage.getPersonDescriptionSel());
    desc.selectByIndex(1);
  }

  public void fillAdminDetails(String email, String name, String password, String passwordrepeat, String phone){
    adminAccountDetailsRep.getAdminEmail().sendKeys(email);
    adminAccountDetailsRep.getAdminName().sendKeys(name);
    adminAccountDetailsRep.getAdminPassword().sendKeys(password);
    adminAccountDetailsRep.getAdminPasswordRepeat().sendKeys(passwordrepeat);
    adminAccountDetailsRep.getAdminPhone().sendKeys(phone);
  }

  public void clickTermsAndCndts(){
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

  public boolean validateSignupBtn(){
    try{
      WebDriverUtils.waitClickable(Driver.driver, signUpPage.getSaveBtn(), 5);
      return true;
    } catch (Exception e){
      return false;
    }
  }

  public void clickSignUpBtn(){
      WebDriverUtils.waitClickable(Driver.driver, signUpPage.getSaveBtn(), 5);
      signUpPage.getSaveBtn().click();
  }
}
