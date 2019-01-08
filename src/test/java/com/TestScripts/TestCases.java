package src.test.java.com.TestScripts;

import java.util.logging.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import src.test.java.com.Utils.StringRandom;
import src.test.java.com.businesslib.commonLib;
import src.test.java.com.businesslib.signUpPage;
import src.test.java.com.genericlib.Driver;
import src.test.java.com.genericlib.WebDriverUtils;

public class TestCases {

  private Driver dLib;
  private WebDriverUtils wLib;
  private commonLib cLib;
  private signUpPage signUpPage;

  private static Logger Log = Logger.getLogger(org.apache.commons.logging.Log.class.getName());

  @BeforeClass
  public void configBeforeClass(){
    Driver.configChromeBrowser();
    wLib = new WebDriverUtils();
    cLib = new commonLib();
    dLib = new Driver();
    signUpPage = new signUpPage();
  }

  //TC1 - Checking elements on the page
  @Test
   public void Test1() throws Exception {
    signUpPage.launchInsly();

    SoftAssert softAssert = new SoftAssert();
    softAssert.assertTrue(signUpPage.validateSignUpTitle(), "Sign up title is not displayed");
    softAssert.assertTrue(signUpPage.validateCompanySubTitle(), "Company Subtitle is not displayed");
    softAssert.assertTrue(signUpPage.validateAddUserSubTitle(), "Add User subtitle is not displayed");
    softAssert.assertTrue(signUpPage.validateAdminAccDetailsSubTitle(), "Administration account details subtitle is not displayed");
    softAssert.assertTrue(signUpPage.validateTermsAndConditionsSubTitle(), "Terms and Conditions subtitle is not displayed");
    softAssert.assertAll();
    signUpPage.fillCompanyDataName("Naren");
    signUpPage.selectCountry("India");
    Assert.assertTrue(signUpPage.validateAddressUrl(), "Address URL is not auto filled");
    signUpPage.selectCompanyProfile();
    signUpPage.selectCompanyEmployees("20");
    signUpPage.selectPersonDesc();
    Log.info("All details are filled correctly");
    String adminemail = StringRandom.retrunRandomGmail();
    String password = StringRandom.generateRandomPassword();
    signUpPage.fillAdminDetails(adminemail, "Admin Name", password, password, "9740953151");
    Log.info("Admin details are entered successfully");
    signUpPage.clickTermsAndCndts();
    Assert.assertTrue(signUpPage.validateSignupBtn(), "Sign up button is not enabled");
    signUpPage.clickSignUpBtn();
    Log.info("Sign Up button clicked successfully");
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethodSetup() {
    Driver.driver.manage().deleteAllCookies();
    Driver.driver.quit();
  }
}
