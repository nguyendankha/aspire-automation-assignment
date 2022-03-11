package com.aspire.auto.base;

import com.aspire.auto.driver.DriverManager;
import com.aspire.auto.driver.TargetFactory;
import com.aspire.auto.report.AllureManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static com.aspire.auto.config.ConfigurationManager.configuration;

@Listeners({TestListener.class})
public abstract class BaseWeb {

    @BeforeSuite
    public void beforeSuite() {
        AllureManager.setAllureEnvironmentInformation();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void preCondition(@Optional("chrome") String browser) {
        WebDriver driver = new TargetFactory().createInstance(browser);
        DriverManager.setDriver(driver);

        DriverManager.getDriver().get(configuration().url());
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        DriverManager.quit();
    }
}
