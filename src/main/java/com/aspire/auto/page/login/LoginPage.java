package com.aspire.auto.page.login;

import com.aspire.auto.data.AccountDataFactory;
import com.aspire.auto.enums.page.Login;
import com.aspire.auto.model.Account;
import com.aspire.auto.page.base.BasePage;
import com.aspire.auto.page.landing.LandingPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {
    @FindBy(css = "#login")
    private WebElement EMAIL_LOGIN_FIELD;

    @FindBy(css = "label[for='login']")
    private WebElement EMAIL_FIELD_LABEL;

    @FindBy(css = "#password")
    private WebElement PASSWORD_LOGIN_FIELD;

    @FindBy(css = "label[for='password']")
    private WebElement PASSWORD_FIELD_LABEL;

    @FindBy(css = "button[type='submit']")
    private WebElement LOGIN_BUTTON;

    @Step
    public void inputEmail(String email) {
        inputField(EMAIL_LOGIN_FIELD, email);
    }

    @Step
    public void inputPassword(String password) {
        inputField(PASSWORD_LOGIN_FIELD, password);
    }

    @Step
    public void clickOnLoginButton() {
        this.LOGIN_BUTTON.click();
    }

    @Step
    public void verifyLoginPageUI() {
        String expectedPageTitle = Login.TITLE.getValue();
        String expectedPageUrl = Login.URL.getValue();
        String expectedEmailFieldLabel = Login.EMAIL_FIELD_LABEL.getValue();
        String expectedPasswordFieldLabel = Login.PASSWORD_FIELD_LABEL.getValue();
        String expectedLoginButtonLabel = Login.LOGIN_BUTTON_LABEL.getValue();

        verifyField(EMAIL_FIELD_LABEL, expectedEmailFieldLabel);
        verifyField(PASSWORD_FIELD_LABEL, expectedPasswordFieldLabel);
        verifyField(LOGIN_BUTTON, expectedLoginButtonLabel);
        verifyPageTitle(expectedPageTitle);
        verifyPageUrl(expectedPageUrl);
    }

    @Step
    public LandingPage login() {
        Account accountInformation = new AccountDataFactory().getAccountInfo();
        inputEmail(accountInformation.getEmail());
        inputPassword(accountInformation.getPassword());
        clickOnLoginButton();
        return new LandingPage();
    }

    @Step
    public LandingPage loginTest() {
        verifyLoginPageUI();
        Account accountInformation = new AccountDataFactory().getAccountInfo();
        inputEmail(accountInformation.getEmail());
        inputPassword(accountInformation.getPassword());
        clickOnLoginButton();
        return new LandingPage();
    }

    @Step
    public void verifyLoginSuccessfully() {
        LandingPage landingPage = loginTest();
        Assert.assertTrue(landingPage.landingPageIsDisplayed());
    }

}
