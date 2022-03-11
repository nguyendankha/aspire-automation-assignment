package com.aspire.auto.enums.page;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public enum Login {
    TITLE("Odoo"),
    URL("/web/login"),
    EMAIL_FIELD_LABEL("Email"),
    EMAIL_FIELD_PLACEHOLDER("Email"),
    PASSWORD_FIELD_LABEL("Password"),
    PASSWORD_FIELD_PLACEHOLDER("Password"),
    LOGIN_BUTTON_LABEL("Log in");

    private final String VALUE;

    Login(String value) {
        this.VALUE = value;
    }

    public String getValue() {
        return VALUE;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
