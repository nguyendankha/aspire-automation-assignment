package com.aspire.auto.enums.data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Random;

public enum ProductCategory {
    ALL("All"),
    ALL_EXPENSES("All / Expenses"),
    ALL_SALEABLE("All / Saleable");

    private final String VALUE;

    ProductCategory(String value) {
        this.VALUE = value;
    }

    public String getValue() {
        return VALUE;
    }

    public static ProductCategory getProductCategory() {
        return values()[new Random().nextInt(values().length)];
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
