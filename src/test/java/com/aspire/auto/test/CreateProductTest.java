package com.aspire.auto.test;

import com.aspire.auto.base.BaseWeb;
import com.aspire.auto.model.Product;
import com.aspire.auto.page.inventory.products.CreateProductPage;
import org.testng.annotations.Test;

public class CreateProductTest extends BaseWeb {
    @Test(description = "Create New Product Test")
    public void createNewProduct() {
        CreateProductPage createProductPage = new CreateProductPage();
        Product product = createProductPage.getProductInformation();
        createProductPage.createNewProductTest(product);
    }
}
