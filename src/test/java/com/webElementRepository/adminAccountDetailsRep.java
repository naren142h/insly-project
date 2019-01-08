package src.test.java.com.webElementRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class adminAccountDetailsRep {

  @FindBy(id = "broker_admin_email")
  private WebElement adminEmail;

  @FindBy(id = "broker_admin_name")
  private WebElement adminName;

  @FindBy(id = "broker_person_password")
  private WebElement adminPassword;

  @FindBy(id = "broker_person_password_repeat")
  private WebElement adminPasswordRepeat;

  @FindBy(id = "broker_admin_phone")
  private WebElement adminPhone;


  public WebElement getAdminEmail() {
    return adminEmail;
  }

  public WebElement getAdminName() {
    return adminName;
  }

  public WebElement getAdminPassword() {
    return adminPassword;
  }

  public WebElement getAdminPasswordRepeat() {
    return adminPasswordRepeat;
  }

  public WebElement getAdminPhone() {
    return adminPhone;
  }
}
