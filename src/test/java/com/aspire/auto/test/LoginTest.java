package com.aspire.auto.test;

import com.aspire.auto.base.BaseWeb;
import com.aspire.auto.page.login.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseWeb {
    @Test(description = "Login To Odoo Page")
    public void loginToOdooPage(){
        LoginPage loginPage = new LoginPage();
        loginPage.verifyLoginSuccessfully();
    }
}
