package com.project.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TypeSecurityCodeBlock {

    @Autowired
    private AppiumDriver driver;

    @Value("#{'${user.default.code:1,2,4,5}'.split(',')}")
    private List<String> userCode;

    public void typeCode(List<String> digits) {
        for (String dig : digits) {
            MobileElement digEl = (MobileElement) driver.findElementByXPath(String.format("//*[@resource-id = 'com.revolut.revolut.test:id/digit%s']", dig));
            digEl.click();
        }
    }

    public void typeCode() {
        typeCode(userCode);
    }
}
