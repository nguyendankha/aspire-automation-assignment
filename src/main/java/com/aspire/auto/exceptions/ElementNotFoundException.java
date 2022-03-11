package com.aspire.auto.exceptions;

import org.openqa.selenium.WebElement;
import org.testng.TestNGException;

public class ElementNotFoundException extends TestNGException {
    public ElementNotFoundException(WebElement element) {
        super(String.format("Element is not found. \n %s", element));
    }
}
