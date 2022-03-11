package com.aspire.auto.enums.data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Random;

public enum ProductType {
//    CONSUMABLE("Consumable"),
//    SERVICE("Service"),
    STORABLE_PRODUCT("Storable Product");

    private final String VALUE;

    ProductType(String value) {
        this.VALUE = value;
    }

    public String getValue() {
        return VALUE;
    }

    public static ProductType getProductType() {
        return values()[new Random().nextInt(values().length)];
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
