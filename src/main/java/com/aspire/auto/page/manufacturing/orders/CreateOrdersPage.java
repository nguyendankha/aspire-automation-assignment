package com.aspire.auto.page.manufacturing.orders;

import com.aspire.auto.enums.data.OrderStatus;
import com.aspire.auto.model.Product;
import com.aspire.auto.page.base.BasePage;
import com.aspire.auto.page.inventory.products.CreateProductPage;
import com.aspire.auto.page.inventory.main.InventoryPage;
import com.aspire.auto.page.inventory.products.ProductsPage;
import com.aspire.auto.page.landing.LandingPage;
import com.aspire.auto.page.login.LoginPage;
import com.aspire.auto.page.manufacturing.main.ManufacturingPage;
import com.aspire.auto.utils.Utilities;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CreateOrdersPage extends BasePage {
    @FindBy(css = "button[title='Save record']")
    private WebElement SAVE_BUTTON;

    @FindBy(css = "button[title='Discard record']")
    private WebElement DISCARD_BUTTON;

    @FindBy(css = "button[name='action_confirm']")
    private WebElement CONFIRM_BUTTON;

    @FindBy(xpath = "//label[text()='Product']/parent::td/following-sibling::td//input")
    private WebElement PRODUCT_DROPDOWN;

    @FindBy(xpath = "//label[text()='Quantity']/parent::td/following-sibling::td//div/input[@name='product_qty']")
    private WebElement QUANTITY;

    @FindBy(xpath = "//div[@class='tab-pane active']//a[text()='Add a line']")
    private WebElement ADD_A_LINE;

    @FindBy(css = "td[name='product_id'] input")
    private WebElement PRODUCT_LINE_DROPDOWN;

    @FindBy(css = "span[name='qty_producing']")
    private WebElement QUANTITY_PRODUCING;

    @FindBy(css = "input[name='qty_producing']")
    private WebElement QUANTITY_PRODUCING_FIELD;

    @FindBy(xpath = "//span[@name='product_uom_qty']")
    private WebElement CONSUME_QUANTITY;

    @FindBy(css = "input[name='quantity_done']")
    private WebElement CONSUME_QUANTITY_FIELD;

    @FindBy(xpath = "//a[text()='Manufacturing Orders']")
    private WebElement MANUFACTURING_ORDERS_BREADCRUMB;

    @FindBy(xpath = "//span[text()='Mark as Done']/parent::button[@class='btn btn-primary']")
    private WebElement MARK_AS_DONE_BUTTON;

    @FindBy(xpath = "//div[@name='state']/button[@title='Current state']")
    private WebElement CURRENT_STATUS;

    @FindBy(css = "a[name='product_id'] span")
    private WebElement PRODUCT_NAME;

    @FindBy(css = "span[name='qty_producing']")
    private WebElement ORDER_QUANTITY;

    @FindBy(css = "td[name='quantity_done']")
    private WebElement ORDER_DONE_QUANTITY;

    @Step
    public void clickOnConfirmButton() {
        clickOnElement(CONFIRM_BUTTON);
    }

    @Step
    public void clickOnSaveButton() {
        clickOnElement(SAVE_BUTTON);
    }

    @Step
    public void clickOnAddALine() {
        clickOnElement(ADD_A_LINE);
    }

    @Step
    public void selectProductOnAddALine(String productName) {
        String xpath = "//ul[contains(@style, 'display: block')]/li[@class='ui-menu-item']/a[text()='%s']";
        inputAutocompleteDropdown(PRODUCT_LINE_DROPDOWN, xpath, productName);
    }

    @Step
    public void selectProduct(String productName) {
        String xpath = "//ul[contains(@style, 'display: block')]/li[@class='ui-menu-item']/a[text()='%s']";
        inputAutocompleteDropdown(PRODUCT_DROPDOWN, xpath, productName);
    }

    @Step void inputProductQuantity(String quantity) {
        inputField(QUANTITY, quantity);
    }

    @Step
    public void updateConsumeQuantity(String quantity) {
        clickOnElement(CONSUME_QUANTITY);
        inputField(CONSUME_QUANTITY_FIELD, quantity);
        clickOnElement(SAVE_BUTTON);
    }

    @Step
    public void updateQuantityProducing(String quantity) {
        clickOnElement(QUANTITY_PRODUCING);
        inputField(QUANTITY_PRODUCING_FIELD, quantity);
        clickOnElement(SAVE_BUTTON);
    }

    @Step
    public void addALineProduct(String productName) {
        clickOnAddALine();
        selectProductOnAddALine(productName);
    }

    @Step
    public void clickOnMarkAsDoneButton() {
        clickOnElement(MARK_AS_DONE_BUTTON);
    }

    @Step
    public void verifyTheCurrentState(String status) {
        sleep(2);
        String currentStatus = getTextFromElement(CURRENT_STATUS);
        Assert.assertEquals(currentStatus, status);
    }

    @Step
    public void openCreateOrderPage(Product product){
        LoginPage loginPage = new LoginPage();
        LandingPage landingPage = loginPage.login();
        InventoryPage inventoryPage = landingPage.redirectToInventoryPage();
        ProductsPage productsPage = inventoryPage.redirectToProductsPage();
        CreateProductPage createProductPage = productsPage.redirectToCreateProductPage();
        createProductPage.createProductPageIsDisplayed();
        createProductPage.createNewProduct(product);
        landingPage = createProductPage.clickOnHomeMenu();
        ManufacturingPage manufacturingPage = landingPage.redirectToManufacturingPage();
        manufacturingPage.redirectToCreateOrdersPage();
    }

    @Step
    public void createNewOrderTest(Product product) {
        Product productInformation = product;
        String productName = productInformation.getProductName();
        int quantity = 1;

        openCreateOrderPage(productInformation);
        selectProduct(productName);
        addALineProduct(productName);
        clickOnSaveButton();
        verifyTheCurrentState(OrderStatus.DRAFT.getValue());
        clickOnConfirmButton();
        verifyTheCurrentState(OrderStatus.CONFIRMED.getValue());
        updateConsumeQuantity(String.valueOf(quantity));
        verifyTheCurrentState(OrderStatus.IN_PROGRESS.getValue());
        updateQuantityProducing(String.valueOf(quantity));
        verifyTheCurrentState(OrderStatus.TO_CLOSE.getValue());
        clickOnMarkAsDoneButton();
        verifyTheCurrentState(OrderStatus.DONE.getValue());

        String actualOrderProductName = getTextFromElement(PRODUCT_NAME);
        String actualOrderQuantity = Utilities.getNumberFromString(getTextFromElement(ORDER_QUANTITY));
        String actualOrderDoneQuantity = Utilities.getNumberFromString(getTextFromElement(ORDER_DONE_QUANTITY));

        Assert.assertEquals(actualOrderProductName, productName);
        Assert.assertEquals(Integer.parseInt(actualOrderQuantity), quantity);
        Assert.assertEquals(Integer.parseInt(actualOrderDoneQuantity), quantity);
    }

}
