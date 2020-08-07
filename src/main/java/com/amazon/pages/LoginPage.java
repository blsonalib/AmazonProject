package com.amazon.pages;

import com.amazon.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    @FindBy(xpath = "//a[@class='nav-logo-link']")
    private WebElement logo;
    @FindBy(id = "nav-link-accountList")
    private WebElement accountAndList;
    @FindBy(id = "ap_email")
    private WebElement userName;
    @FindBy(id = "continue")
    private WebElement continueButton;
    @FindBy(id = "ap_password")
    private WebElement password;
    @FindBy(id = "signInSubmit")
    private WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean validateTheLogo() {
        return logo.isDisplayed();
    }
    public String validateTitle(){
        return driver.getTitle();
    }
    public void clickOnAccountAndListLink() {
        accountAndList.click();
    }
    public HomePage ClickOnLoginPage(String un,String pwd){
        userName.sendKeys(un);
        continueButton.click();
        password.sendKeys(pwd);
        loginButton.click();
        return new HomePage();
    }
}
