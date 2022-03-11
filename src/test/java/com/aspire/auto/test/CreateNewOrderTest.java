package com.aspire.auto.test;

import com.aspire.auto.base.BaseWeb;
import com.aspire.auto.model.Product;
import com.aspire.auto.page.inventory.products.CreateProductPage;
import com.aspire.auto.page.manufacturing.orders.CreateOrdersPage;
import org.testng.annotations.Test;

public class CreateNewOrderTest extends BaseWeb {
    @Test(description = "Create New Order Test")
    public void createNewOrderTest() {
        CreateProductPage createProductPage = new CreateProductPage();
        CreateOrdersPage createOrdersPage = new CreateOrdersPage();
        Product product = createProductPage.getProductInformation();
        createOrdersPage.createNewOrderTest(product);
    }
}
