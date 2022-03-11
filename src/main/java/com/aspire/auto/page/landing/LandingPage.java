package com.aspire.auto.page.landing;

import com.aspire.auto.enums.page.Landing;
import com.aspire.auto.page.base.BasePage;
import com.aspire.auto.page.inventory.main.InventoryPage;
import com.aspire.auto.page.login.LoginPage;
import com.aspire.auto.page.manufacturing.main.ManufacturingPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LandingPage extends BasePage {
    @FindBy(xpath = "//div[text()='Inventory']/parent::a")
    private WebElement INVENTORY_ICON;

    @FindBy(xpath = "//div[text()='Inventory']")
    private WebElement INVENTORY_ICON_LABEL;

    @FindBy(xpath = "//div[text()='Manufacturing']/parent::a")
    private WebElement MANUFACTURING_ICON;

    @FindBy(xpath = "//div[text()='Manufacturing']")
    private WebElement MANUFACTURING_ICON_LABEL;

    @FindBy(css = "button.dropdown-toggle")
    private WebElement USER_MENU_ICON;

    @Step
    public boolean landingPageIsDisplayed() {
        try {
            Assert.assertTrue(verifyElementIsDisplayed(INVENTORY_ICON));
            Assert.assertTrue(verifyElementIsDisplayed(MANUFACTURING_ICON));
            Assert.assertTrue(verifyElementIsDisplayed(USER_MENU_ICON));
            verifyLandingPageUI();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Step
    public void verifyLandingPageUI() {
        String expectedPageTitle = Landing.TITLE.getValue();
        String expectedPageUrl = Landing.URL.getValue();
        String expectedInventoryIconLabel = Landing.INVENTORY_ICON_LABEL.getValue();
        String expectedManufacturingIconLabel = Landing.MANUFACTURING_ICON_LABEL.getValue();

        verifyField(INVENTORY_ICON_LABEL, expectedInventoryIconLabel);
        verifyField(MANUFACTURING_ICON_LABEL, expectedManufacturingIconLabel);
        verifyPageTitle(expectedPageTitle);
        verifyPageUrl(expectedPageUrl);
    }

    @Step
    public void clickOnInventoryIcon() {
        INVENTORY_ICON.click();
    }

    @Step
    public void clickOnManufacturingIcon() {
        MANUFACTURING_ICON.click();
    }

    @Step
    public InventoryPage redirectToInventoryPage() {
        clickOnInventoryIcon();
        return new InventoryPage();
    }

    @Step
    public ManufacturingPage redirectToManufacturingPage() {
        clickOnManufacturingIcon();
        return new ManufacturingPage();
    }

    @Step
    public InventoryPage redirectToInventoryPageTest() {
        openLandingPage();
        clickOnInventoryIcon();
        return new InventoryPage();
    }

    @Step
    public ManufacturingPage redirectToManufacturingPageTest() {
        openLandingPage();
        clickOnManufacturingIcon();
        return new ManufacturingPage();
    }

    @Step
    public void openLandingPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.login();
    }

    @Step
    public void verifyInventoryPageDisplayed() {
        InventoryPage inventoryPage = redirectToInventoryPageTest();
        Assert.assertTrue(inventoryPage.inventoryPageIsDisplayed());
    }

    @Step
    public void verifyManufacturingPageDisplayed() {
        ManufacturingPage manufacturingPage = redirectToManufacturingPageTest();
        Assert.assertTrue(manufacturingPage.manufacturingPageIsDisplayed());
    }
}
