package com.aspire.auto.test;

import com.aspire.auto.base.BaseWeb;
import com.aspire.auto.page.landing.LandingPage;
import org.testng.annotations.Test;

public class LandingPageNavigationTest extends BaseWeb {
    @Test(description = "Navigation To Inventory Page")
    public void navigateToInventoryPage() {
        LandingPage landingPage = new LandingPage();
        landingPage.verifyInventoryPageDisplayed();
    }

    @Test(description = "Navigation To Manufacturing Page")
    public void navigateToManufacturingPage() {
        LandingPage landingPage = new LandingPage();
        landingPage.verifyManufacturingPageDisplayed();
    }
}
