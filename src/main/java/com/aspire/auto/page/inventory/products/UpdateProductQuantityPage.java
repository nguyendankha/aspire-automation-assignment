package com.aspire.auto.page.inventory.products;

import com.aspire.auto.page.base.BasePage;
import com.aspire.auto.page.landing.LandingPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class UpdateProductQuantityPage extends BasePage {
    @FindBy(css = "a[title='Home menu']")
    private WebElement HOME_MENU;

    @FindBy(css = "button[data-original-title='Create record']")
    private WebElement CREATE_BUTTON;

    @FindBy(css = "input[name='inventory_quantity']")
    private WebElement PRODUCT_QUANTITY;

    @FindBy(css = "button[title='Save record']")
    private WebElement SAVE_BUTTON;

    @Step
    public boolean createUpdateQuantityPageIsDisplayed() {
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
    public void clickOnSaveButton() {
        clickOnElement(SAVE_BUTTON);
    }

    @Step
    public void updateProductQuantity(String quantity) {
        clickOnCreateButton();
        inputField(PRODUCT_QUANTITY, quantity);
        clickOnSaveButton();
        sleep(5);
    }

    @Step
    public LandingPage clickOnHomeMenu() {
        clickOnElement(HOME_MENU);
        return new LandingPage();
    }

}
