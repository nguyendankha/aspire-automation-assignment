package com.aspire.auto.data;

import com.aspire.auto.model.Account;
import com.aspire.auto.model.AccountBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.aspire.auto.config.ConfigurationManager.configuration;

public class AccountDataFactory {
    private static final Logger logger = LogManager.getLogger(AccountDataFactory.class);

    public AccountDataFactory() {}

    public Account getAccountInfo() {
        Account account = new AccountBuilder().email(configuration().email()).password(configuration().password()).build();
        logger.info(account);
        return account;
    }
}
