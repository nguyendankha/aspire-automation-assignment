package com.aspire.auto.utils;

import com.aspire.auto.config.IRetry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.TestNGException;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {
    private static final int DEFAULT_RETRY_INTERVAL = 2;
    private static final Logger logger = LogManager.getLogger(Utilities.class);

    public static HashMap<?, ?> readYamlFile(InputStream inputStream) {
        try {
            Yaml yaml = new Yaml();
            return yaml.loadAs(inputStream, HashMap.class);
        } catch (Exception e) {
            logger.error("Read YAML file error.");
            e.printStackTrace();
            return null;
        }
    }

    public static String extractNumberFromString(String text) {
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(text);
        while(matcher.find()){
            return (matcher.group(1));
        }
        return null;
    }

    public static String getNumberFromString(String text) {
        String result = extractNumberFromString(text);
        result = String.valueOf(new Double(result).intValue());
        return result;
    }

    public static void retryUntilNoError(IRetry retry, int interval, int maxTimeout){
        long startTime = System.currentTimeMillis();
        Throwable throwable = null;
        while (System.currentTimeMillis() - startTime < maxTimeout * 1000) {
            try {
                throwable = null;
                retry.retry();
                break;
            } catch (Throwable error) {
                logger.info(String.valueOf(throwable = error));
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("------- Retry -------");
            }
        }
        if (null != throwable)
            throw new TestNGException(throwable);
    }
}
