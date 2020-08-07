 package com.amazon.testcases;

import com.amazon.base.TestBase;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    public LoginPageTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialize();
        loginPage = new LoginPage();
    }
    @Test
    public void logoTest(){
        boolean flag = loginPage.validateTheLogo();
        Assert.assertTrue(flag);
    }
    @Test
    public void validTitleTest(){
        String title = loginPage.validateTitle();
        Assert.assertEquals(title,"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
    }
    @Test
    public void loginTest() {
        loginPage.clickOnAccountAndListLink();
        homePage = loginPage.ClickOnLoginPage(prop.getProperty("userID"),prop.getProperty("password"));
    }
    @AfterMethod
    public void tearDown(){
      driver.quit();
    }
}
