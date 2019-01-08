package src.test.java.com.webElementRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class termsAndConditionsRep {

  @FindBy(xpath = "//*[@id='field_terms']/td[2]/div/div/label[1]/span")
  private WebElement termsandconditionsCbox;

  @FindBy(xpath = "//*[@id='field_terms']/td[2]/div/div/label[2]/span")
  private WebElement privacypolicyCbox;

  @FindBy(xpath = "//*[@id='field_terms']/td[2]/div/div/label[3]/span")
  private WebElement agreeDataStorageCBox;

  @FindBy(xpath = "//*[contains(text(),'terms and conditions')]")
  private WebElement termsandcndtsLnk;

  @FindBy(xpath = "//*[@class='primary']")
  private WebElement tAndCAgreeBtn;

  @FindBy(xpath = "//*[contains(text(),'privacy policy')]")
  private WebElement privacypolicyLnk;

  @FindBy(xpath = "(//*[@class='icon-close'])[2]")
  private WebElement privacypolicyCloseBtn;

  @FindBy(id = "submit_save")
  private WebElement signupbtn;

  @FindBy(xpath = "//*[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']")
  private WebElement privacypolicyDiv;

  @FindBy(xpath = "//*[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable ui-dialog-buttons']")
  private WebElement termsCndtsDiv;

  public WebElement getTermsandconditionsCbox() {
    return termsandconditionsCbox;
  }

  public WebElement getPrivacypolicyCbox() {
    return privacypolicyCbox;
  }

  public WebElement getAgreeDataStorageCBox() {
    return agreeDataStorageCBox;
  }

  public WebElement getTermsandcndtsLnk() {
    return termsandcndtsLnk;
  }

  public WebElement gettAndCAgreeBtn() {
    return tAndCAgreeBtn;
  }

  public WebElement getPrivacypolicyLnk() {
    return privacypolicyLnk;
  }

  public WebElement getPrivacypolicyCloseBtn() {
    return privacypolicyCloseBtn;
  }

  public WebElement getSignupbtn() {
    return signupbtn;
  }

  public WebElement getPrivacypolicyDiv() {
    return privacypolicyDiv;
  }

  public WebElement getTermsCndtsDiv() {
    return termsCndtsDiv;
  }
}
