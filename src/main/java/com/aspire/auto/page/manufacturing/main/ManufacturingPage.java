package com.aspire.auto.page.manufacturing.main;

import com.aspire.auto.page.base.BasePage;
import com.aspire.auto.page.manufacturing.orders.CreateOrdersPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ManufacturingPage extends BasePage {
    @FindBy(css = "button[data-original-title='Create record']")
    private WebElement CREATE_BUTTON;

    @Step
    public boolean manufacturingPageIsDisplayed() {
        try {
            Assert.assertTrue(verifyElementIsDisplayed(CREATE_BUTTON));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Step
    public void clickOnCreateButton() {
        clickOnElement(CREATE_BUTTON);
    }

    @Step
    public CreateOrdersPage redirectToCreateOrdersPage() {
        clickOnCreateButton();
        return new CreateOrdersPage();
    }

}
