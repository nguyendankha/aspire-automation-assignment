package com.aspire.auto.model;

import com.aspire.auto.enums.data.ProductCategory;
import com.aspire.auto.enums.data.ProductType;
import com.aspire.auto.enums.data.UnitType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Product {

    private String productName;
    private ProductType productType;
    private UnitType unitType;
    private ProductCategory productCategory;
    private int salesPrice;
    private int cost;
    private int quantity;

    public Product(String productName, ProductType productType, UnitType unitType, ProductCategory productCategory, int salesPrice, int cost, int quantity) {
        this.productName = productName;
        this.productType = productType;
        this.unitType = unitType;
        this.productCategory = productCategory;
        this.salesPrice = salesPrice;
        this.cost = cost;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public int getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(int salesPrice) {
        this.salesPrice = salesPrice;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
