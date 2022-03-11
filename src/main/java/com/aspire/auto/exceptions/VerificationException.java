package com.aspire.auto.exceptions;

import org.testng.TestNGException;

public class VerificationException extends TestNGException {
    public VerificationException(TestNGException exception) {
        super(String.format("The Verification Is Failed."));
    }

}
