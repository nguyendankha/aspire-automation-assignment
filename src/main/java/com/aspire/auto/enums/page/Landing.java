package com.aspire.auto.enums.page;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public enum Landing {
    TITLE("Odoo"),
    URL("&action=menu"),
    DISCUSS_ICON_LABEL("Discuss"),
    INVENTORY_ICON_LABEL("Inventory"),
    MANUFACTURING_ICON_LABEL("Manufacturing");

    private final String VALUE;


    Landing(String value) {
        this.VALUE = value;
    }

    public String getValue() {
        return VALUE;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
