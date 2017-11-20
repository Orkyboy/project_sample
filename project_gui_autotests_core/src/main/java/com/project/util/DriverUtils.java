package com.project.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.concurrent.TimeUnit;


@Component
public class DriverUtils {

    private final Logger logger = LoggerFactory.getLogger(DriverUtils.class);

    @Autowired
    private AppiumDriver driver;

    @Value("${driver.timeout.default:30000}")
    private int defaultTimeout;

    @Value("${driver.timeout.element:30000}")
    private int defaultElementTimeout;

    @Value("${thread.sleep.time:5000}")
    public int sleepTime;

    public void setWaitingTimeout(int milliseconds) {
        driver.manage().timeouts().implicitlyWait(milliseconds, TimeUnit.MILLISECONDS);
    }

    public void sleep() {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean isElementDisplayed(MobileElement element) {
        setWaitingTimeout(100);
        try {
            return element.isDisplayed();
        }
        catch (NoSuchElementException ex) {
            logger.warn("Element is not displayed: " + element.getTagName());
            return false;
        }
        finally {
            setWaitingTimeout(defaultTimeout);
        }
    }

    public boolean isElementDisplayed(By by) {
        setWaitingTimeout(100);
        try {
            return driver.findElement(by).isDisplayed();
        }
        catch (NoSuchElementException ex) {
            logger.warn("Element is not displayed, found by: " + by);
            return false;
        }
        finally {
            setWaitingTimeout(defaultTimeout);
        }
    }


    public boolean waitForProcess() {
        By processElem = By.xpath("");
        try {
            Wait<WebDriver> wait = new WebDriverWait(driver, defaultElementTimeout / 1000, 1000);
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
            logger.info("Wait for process...");
            wait.until(ExpectedConditions.invisibilityOfElementLocated(processElem));
            logger.info("Process element not displayed");
            return true;
        }catch (TimeoutException ex) {
            ex.printStackTrace();
            Assert.fail("Infinite loading!");
            return false;
        } finally {
            setWaitingTimeout(defaultTimeout);
        }
    }

}
