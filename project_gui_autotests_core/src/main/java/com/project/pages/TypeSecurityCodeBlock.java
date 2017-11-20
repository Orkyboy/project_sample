package com.project.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TypeSecurityCodeBlock {

    @Autowired
    private AppiumDriver driver;

    public void typeCode(List<String> digits) {
        for (String dig : digits) {
            MobileElement digEl = (MobileElement) driver.findElementByXPath(String.format("//*[@resource-id = 'com.revolut.revolut.test:id/digit%s']", dig));
            digEl.click();
        }
    }
}
