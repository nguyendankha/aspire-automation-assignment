package com.aspire.auto.page.inventory.products;

import com.aspire.auto.data.ProductDataFactory;
import com.aspire.auto.model.Product;
import com.aspire.auto.page.base.BasePage;
import com.aspire.auto.page.inventory.main.InventoryPage;
import com.aspire.auto.page.landing.LandingPage;
import com.aspire.auto.page.login.LoginPage;
import com.aspire.auto.utils.Utilities;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CreateProductPage extends BasePage {
    @FindBy(css = "a[title='Home menu']")
    private WebElement HOME_MENU;

    @FindBy(css = "button[title='Save record']")
    private WebElement SAVE_BUTTON;

    @FindBy(css = "button[title='Discard record']")
    private WebElement DISCARD_BUTTON;

    @FindBy(css = "button[name='action_update_quantity_on_hand']")
    private WebElement UPDATE_QUANTITY_BUTTON;

    @FindBy(css = "input[name='name']")
    private WebElement PRODUCT_NAME_FIELD;

    @FindBy(css = "select[name='detailed_type']")
    private WebElement PRODUCT_TYPE_DROPDOWN;

    @FindBy(xpath = "//label[text()='Unit of Measure']/parent::td/following-sibling::td//input")
    private WebElement UNIT_OF_MEASURE_DROPDOWN;

    @FindBy(xpath = "//label[text()='Purchase UoM']/parent::td/following-sibling::td//input")
    private WebElement PURCHASE_UOM_DROPDOWN;

    @FindBy(xpath = "//label[text()='Sales Price']/parent::td/following-sibling::td//input")
    private WebElement SALES_PRICE_FIELD;

    @FindBy(xpath = "//label[text()='Cost']/parent::td/following-sibling::td//input")
    private WebElement COST_FIELD;

    @FindBy(xpath = "//label[text()='Product Category']/parent::td/following-sibling::td//input")
    private WebElement PRODUCT_CATEGORY_DROPDOWN;

    @FindBy(xpath = "//div[@name='sale_ok']/input")
    private WebElement CAN_BE_SOLD_CHECKBOX;

    @FindBy(xpath = "//div[@name='purchase_ok']/input")
    private WebElement CAN_BE_PURCHASED_CHECKBOX;

    @FindBy(xpath = "//li/a[text()='General Information']")
    private WebElement GENERAL_INFORMATION_SUB_TAB;

    @FindBy(xpath = "//li/a[text()='Inventory']")
    private WebElement INVENTORY_SUB_TAB;

    @FindBy(xpath = "//label[text()='Manufacture']/preceding-sibling::input")
    private WebElement INVENTORY_ROUTE_MANUFACTURE_CHECKBOX;

    @FindBy(css = "input[name='weight']")
    private WebElement INVENTORY_LOGISTICS_WEIGHT_FIELD;

    @FindBy(css = "input[name='volume']")
    private WebElement INVENTORY_LOGISTICS_VOLUME_FIELD;

    @FindBy(css = "input[name='produce_delay']")
    private WebElement INVENTORY_LOGISTICS_MANUF_LEAD_TIME_FIELD;

    @FindBy(xpath = "input[name='sale_delay']")
    private WebElement INVENTORY_LOGISTICS_CUSTOMER_LEAD_TIME_FIELD;

    @FindBy(css = "button[title='Edit record']")
    private WebElement EDIT_BUTTON;

    @FindBy(css = "button[title='Create record']")
    private WebElement CREATE_BUTTON;

    @FindBy(css = "span[name='name']")
    private WebElement PRODUCT_NAME;

    @FindBy(css = "span[name='detailed_type']")
    private WebElement PRODUCT_TYPE;

    @FindBy(css = "a[name='uom_id'] span")
    private WebElement UNIT_OF_MEASURE;

    @FindBy(css = "a[name='uom_po_id'] span")
    private WebElement PURCHASE_UOM;

    @FindBy(css = "span[name='list_price']")
    private WebElement SALES_PRICE;

    @FindBy(css = "span[name='standard_price']")
    private WebElement COST;

    @FindBy(css = "a[name='categ_id'] span")
    private WebElement PRODUCT_CATEGORY;

    @Step
    public boolean createProductPageIsDisplayed() {
        try {
            Assert.assertTrue(verifyElementIsDisplayed(SAVE_BUTTON));
            Assert.assertTrue(verifyElementIsDisplayed(DISCARD_BUTTON));
            Assert.assertTrue(verifyElementIsDisplayed(PRODUCT_NAME_FIELD));
            Assert.assertTrue(verifyElementIsDisplayed(PRODUCT_TYPE_DROPDOWN));
            Assert.assertTrue(verifyElementIsDisplayed(UNIT_OF_MEASURE_DROPDOWN));
            Assert.assertTrue(verifyElementIsDisplayed(PURCHASE_UOM_DROPDOWN));
            Assert.assertTrue(verifyElementIsDisplayed(SALES_PRICE_FIELD));
            Assert.assertTrue(verifyElementIsDisplayed(COST_FIELD));
            Assert.assertTrue(verifyElementIsDisplayed(PRODUCT_CATEGORY_DROPDOWN));
            Assert.assertTrue(verifyElementIsDisplayed(CAN_BE_SOLD_CHECKBOX));
            Assert.assertTrue(verifyElementIsDisplayed(CAN_BE_PURCHASED_CHECKBOX));
            Assert.assertTrue(verifyElementIsDisplayed(GENERAL_INFORMATION_SUB_TAB));
            Assert.assertTrue(verifyElementIsDisplayed(INVENTORY_SUB_TAB));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Step
    public void clickOnSaveButton() {
        clickOnElement(SAVE_BUTTON);
    }

    @Step
    public void inputProductName(String productName) {
        inputField(PRODUCT_NAME_FIELD, productName);
    }

    @Step
    public void selectProductType(String productType) {
        logger.info("Product Type: " + productType);
        selectItemFromDropdown(PRODUCT_TYPE_DROPDOWN, productType);
    }

    @Step
    public void selectUnitOfMeasure(String unit) {
        String xpath = "//ul[contains(@style, 'display: block')]/li[@class='ui-menu-item']/a[text()='%s']";
        inputAutocompleteDropdown(UNIT_OF_MEASURE_DROPDOWN, xpath, unit);
    }

    @Step
    public void selectPurchaseUoM(String unit) {
        String xpath = "//ul[contains(@style, 'display: block')]/li[@class='ui-menu-item']/a[text()='%s']";
        inputAutocompleteDropdown(PURCHASE_UOM_DROPDOWN, xpath, unit);
    }

    @Step
    public void inputProductSalePrice(int price) {
        logger.info(String.format("Sales Price: %s", price));
        inputField(SALES_PRICE_FIELD, String.valueOf(price));
    }

    @Step
    public void inputProductCost(int cost) {
        logger.info(String.format("----- Cost: %s -----", cost));
        inputField(COST_FIELD, String.valueOf(cost));
    }

    @Step
    public void selectProductCategory(String category) {
        String xpath = "//ul[contains(@style, 'display: block')]/li[@class='ui-menu-item']/a[text()='%s']";
        inputAutocompleteDropdown(PRODUCT_CATEGORY_DROPDOWN, xpath, category);
    }

    @Step
    public void openCreateProductPage() {
        LoginPage loginPage = new LoginPage();
        LandingPage landingPage = loginPage.login();
        InventoryPage inventoryPage = landingPage.redirectToInventoryPage();
        ProductsPage productsPage = inventoryPage.redirectToProductsPage();
        productsPage.redirectToCreateProductPage();
    }

    @Step
    public void clickOnEditButton() {
        clickOnElement(EDIT_BUTTON);
    }

    @Step
    public Product createNewProductTest(Product product) {
        openCreateProductPage();
        createProductPageIsDisplayed();
        Product productInformation = product;
        String productName = productInformation.getProductName();
        String productType = productInformation.getProductType().getValue();
        String unit = productInformation.getUnitType().getValue();
        int salesPrice = productInformation.getSalesPrice();
        int cost = productInformation.getCost();
        String productCategory = productInformation.getProductCategory().getValue();
        int quantity = productInformation.getQuantity();

        inputProductName(productName);
        selectProductType(productType);
        selectUnitOfMeasure(unit);
        selectPurchaseUoM(unit);
        inputProductSalePrice(salesPrice);
        inputProductCost(cost);
        selectProductCategory(productCategory);
        clickOnSaveButton();

        String actualProductName = getTextFromElement(PRODUCT_NAME);
        String actualProductType = getTextFromElement(PRODUCT_TYPE);
        String actualProductUnitOfMeasure = getTextFromElement(UNIT_OF_MEASURE);
        String actualProductPurchaseUoM = getTextFromElement(PURCHASE_UOM);
        String actualSalesPrice = Utilities.getNumberFromString(getTextFromElement(SALES_PRICE));
        String actualCost = Utilities.getNumberFromString(getTextFromElement(COST));
        String actualProductCategory = getTextFromElement(PRODUCT_CATEGORY);

        Assert.assertEquals(actualProductName, productName);
        Assert.assertEquals(actualProductType, productType);
        Assert.assertEquals(actualProductUnitOfMeasure, unit);
        Assert.assertEquals(actualProductPurchaseUoM, unit);
        Assert.assertEquals(Integer.parseInt(actualSalesPrice), salesPrice);
        Assert.assertEquals(Integer.parseInt(actualCost), cost);
        Assert.assertEquals(actualProductCategory, productCategory);

        UpdateProductQuantityPage updateProductQuantityPage = goToUpdateProductQuantityPage();
        updateProductQuantityPage.createUpdateQuantityPageIsDisplayed();
        updateProductQuantityPage.updateProductQuantity(String.valueOf(quantity));

        return productInformation;
    }

    @Step
    public Product createNewProduct(Product product) {
        createProductPageIsDisplayed();
        Product productInformation = product;
        String productName = productInformation.getProductName();
        String productType = productInformation.getProductType().getValue();
        String unit = productInformation.getUnitType().getValue();
        int salesPrice = productInformation.getSalesPrice();
        int cost = productInformation.getCost();
        String productCategory = productInformation.getProductCategory().getValue();
        int quantity = productInformation.getQuantity();

        inputProductName(productName);
        selectProductType(productType);
        selectUnitOfMeasure(unit);
        selectPurchaseUoM(unit);
        inputProductSalePrice(salesPrice);
        inputProductCost(cost);
        selectProductCategory(productCategory);
        clickOnSaveButton();

        String actualProductName = getTextFromElement(PRODUCT_NAME);
        String actualProductType = getTextFromElement(PRODUCT_TYPE);
        String actualProductUnitOfMeasure = getTextFromElement(UNIT_OF_MEASURE);
        String actualProductPurchaseUoM = getTextFromElement(PURCHASE_UOM);
        String actualSalesPrice = Utilities.getNumberFromString(getTextFromElement(SALES_PRICE));
        String actualCost = Utilities.getNumberFromString(getTextFromElement(COST));
        String actualProductCategory = getTextFromElement(PRODUCT_CATEGORY);

        Assert.assertEquals(actualProductName, productName);
        Assert.assertEquals(actualProductType, productType);
        Assert.assertEquals(actualProductUnitOfMeasure, unit);
        Assert.assertEquals(actualProductPurchaseUoM, unit);
        Assert.assertEquals(Integer.parseInt(actualSalesPrice), salesPrice);
        Assert.assertEquals(Integer.parseInt(actualCost), cost);
        Assert.assertEquals(actualProductCategory, productCategory);

        UpdateProductQuantityPage updateProductQuantityPage = goToUpdateProductQuantityPage();
        updateProductQuantityPage.updateProductQuantity(String.valueOf(quantity));

        return productInformation;
    }

    @Step
    public UpdateProductQuantityPage goToUpdateProductQuantityPage() {
        clickOnElement(EDIT_BUTTON);
        clickOnElement(UPDATE_QUANTITY_BUTTON);
        return new UpdateProductQuantityPage();
    }

    @Step
    public LandingPage clickOnHomeMenu() {
        clickOnElement(HOME_MENU);
        return new LandingPage();
    }

    public Product getProductInformation() {
        Product productInformation = new ProductDataFactory().getProductData();
        return productInformation;
    }

}
