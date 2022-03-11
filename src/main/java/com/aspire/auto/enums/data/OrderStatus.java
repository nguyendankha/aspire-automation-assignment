package com.aspire.auto.enums.data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public enum OrderStatus {
    DRAFT("DRAFT"),
    CONFIRMED("CONFIRMED"),
    IN_PROGRESS("IN PROGRESS"),
    TO_CLOSE("TO CLOSE"),
    DONE("DONE");

    private final String VALUE;

    OrderStatus(String value) {
        this.VALUE = value;
    }

    public String getValue() {
        return VALUE;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
