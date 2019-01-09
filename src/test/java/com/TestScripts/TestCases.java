package com.TestScripts;

import com.Utils.StringRandom;
import com.configurationbase.BaseConfig;
import com.oracle.tools.packager.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.businesslib.signUpPage;

public class TestCases extends BaseConfig {

  @Test
   public void Test1() throws Exception {

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
}
