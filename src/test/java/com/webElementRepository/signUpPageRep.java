package com.webElementRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class signUpPageRep {

  @FindBy(xpath ="//h1[contains(text(),'Sign up and start using')]")
  private WebElement signUpTitleTxt;

  @FindBy(xpath ="//*[contains(text(),'Company')]")
  private WebElement companySubTitleTxt;

  @FindBy(xpath = "//*[@class='panel-body']")
  private WebElement formDiv;

  @FindBy(xpath ="//*[contains(text(),'Add user')]")
  private WebElement AddUserSubTitleTxt;

  @FindBy(xpath ="//*[contains(text(),'Administrator account details')]")
  private WebElement AdminAccDetailsSubTitleTxt;

  @FindBy(xpath ="//*[contains(text(),'Terms and conditions')]")
  private WebElement TermsAndConditionsSubTitleTxt;

  @FindBy(id = "broker_name")
  private WebElement companyNameInpt;

  @FindBy(id = "broker_address_country")
  private WebElement companyCountrySel;

  @FindBy(id = "broker_tag")
  private WebElement addressUrl;

  @FindBy(id = "prop_company_profile")
  private WebElement companyProfile;

  @FindBy(id = "prop_company_no_employees")
  private WebElement companyEmployeesSel;

  @FindBy(id = "prop_company_person_description")
  private WebElement personDescriptionSel;

  @FindBy(id = "submit_save")
  private WebElement saveBtn;


  public WebElement getSignUpTitleTxt() {

    return signUpTitleTxt;
  }

  public WebElement getCompanySubTitleTxt() {

    return companySubTitleTxt;
  }

  public WebElement getFormDiv() {

    return formDiv;
  }

  public WebElement getAddUserSubTitleTxt() {

    return AddUserSubTitleTxt;
  }

  public WebElement getAdminAccDetailsSubTitleTxt() {
    return AdminAccDetailsSubTitleTxt;
  }

  public WebElement getTermsAndConditionsSubTitleTxt() {

    return TermsAndConditionsSubTitleTxt;
  }

  public WebElement getCompanyNameInpt() {

    return companyNameInpt;
  }

  public WebElement getCompanyCountrySel() {

    return companyCountrySel;
  }

  public WebElement getAddressUrl() {

    return addressUrl;
  }

  public WebElement getCompanyProfile() {

    return companyProfile;
  }

  public WebElement getCompanyEmployeesSel() {

    return companyEmployeesSel;
  }

  public WebElement getPersonDescriptionSel() {

    return personDescriptionSel;
  }

  public WebElement getSaveBtn() {
    return saveBtn;
  }
}
