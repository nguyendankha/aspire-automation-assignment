package com.aspire.auto.data;

import com.aspire.auto.enums.data.ProductCategory;
import com.aspire.auto.enums.data.ProductType;
import com.aspire.auto.enums.data.UnitType;
import com.aspire.auto.model.Product;
import com.aspire.auto.model.ProductBuilder;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.util.Random;

import static com.aspire.auto.config.ConfigurationManager.configuration;

public class ProductDataFactory {
    private final Faker faker;
    private static final Logger logger = LogManager.getLogger(ProductDataFactory.class);

    public ProductDataFactory() {
        faker = new Faker(new Locale(configuration().faker()));
    }

    public Product getProductData() {
        Product product = new ProductBuilder().productName(faker.name().fullName()).productType(ProductType.getProductType()).unitType(UnitType.getUnitType()).productCategory(ProductCategory.getProductCategory()).salesPrice(generateSalesPrice()).cost(generateCost()).quantity(generateQuantity()).build();

        logger.info(product);
        return product;
    }

    public int generateSalesPrice() {
        int number = 0;
        while (number < 1) {
            number = generateRandomIntNumber();
        }
        System.out.println(number);
        return number;
    }

    public int generateCost() {
        int number = 0;
        while (number < 1) {
            number = generateRandomIntNumber();
        }
        System.out.println(number);
        return number;
    }

    public int generateQuantity() {
        int number = 0;
        while (number < 10) {
            number = generateRandomIntNumber();
        }
        System.out.println(number);
        return number;
    }

    public int generateRandomIntNumber() {
        Random rd = new Random();
        return rd.nextInt(100);
    }
}
