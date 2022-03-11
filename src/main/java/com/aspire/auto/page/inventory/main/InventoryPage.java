package com.aspire.auto.page.inventory.main;

import com.aspire.auto.page.base.BasePage;
import com.aspire.auto.page.inventory.products.ProductsPage;
import com.aspire.auto.page.landing.LandingPage;
import com.aspire.auto.page.login.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class InventoryPage extends BasePage {
    @FindBy(css = "a[title='Home menu']")
    private WebElement HOME_MENU;

    @FindBy(css = ".dropdown-item.o_menu_brand")
    private WebElement INVENTORY_MENU;

    @FindBy(css = "button[title='Products']")
    private WebElement PRODUCT_MENU;

    @FindBy(xpath = "//a[text()='Products']")
    private WebElement PRODUCT_SUB_MENU;

    @Step
    public boolean inventoryPageIsDisplayed() {
        try {
            Assert.assertTrue(verifyElementIsDisplayed(HOME_MENU));
            Assert.assertTrue(verifyElementIsDisplayed(INVENTORY_MENU));
            Assert.assertTrue(verifyElementIsDisplayed(PRODUCT_MENU));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Step
    public void clickOnProductMenu() {
        PRODUCT_MENU.click();
    }

    @Step
    public void clickOnProductsSubMenu() {
        PRODUCT_SUB_MENU.click();
    }

    @Step
    public ProductsPage redirectToProductsPage() {
        clickOnProductMenu();
        clickOnProductsSubMenu();
        return new ProductsPage();
    }

    @Step
    public void openInventoryPage() {
        LoginPage loginPage = new LoginPage();
        LandingPage landingPage = loginPage.login();
        landingPage.redirectToInventoryPage();
    }

    @Step
    public void verifyProductsPageDisplayed() {
        ProductsPage productsPage = redirectToProductsPage();
        Assert.assertTrue(productsPage.productsPageIsDisplayed());
    }

}
