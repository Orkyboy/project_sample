package com.project.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Component
public class TypeSmsCodeBlock extends BasePage{

    @FindBy(xpath = "//*[@resource-id = 'com.revolut.revolut.test:id/debug_sms_code']")
    private MobileElement debugSmsCode;

    @FindBy(xpath = "//*[@resource-id = 'com.revolut.revolut.test:id/sms_editor']")
    private MobileElement codeInput;

    @PostConstruct
    private void init() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    public void enterCode() {
        codeInput.sendKeys(debugSmsCode.getText());
    }
}
