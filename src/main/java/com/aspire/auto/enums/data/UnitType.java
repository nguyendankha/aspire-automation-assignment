package com.aspire.auto.enums.data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Random;

public enum UnitType {
    IN3("in³"),
    MM("mm"),
    G("g"),
    CM("cm"),
    IN("in"),
    OZ("oz"),
    FL_OZ("fl oz (US)");

    private final String VALUE;

    UnitType(String value) {
        this.VALUE = value;
    }

    public String getValue() {
        return VALUE;
    }

    public static UnitType getUnitType() {
        return values()[new Random().nextInt(values().length)];
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
