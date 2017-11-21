package com.project.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Component
@Getter
public class TypeSmsCodeBlock extends BasePage{

    @AndroidFindBy(xpath = "//*[@resource-id = 'com.revolut.revolut.test:id/debug_sms_code']")
    private MobileElement debugSmsCode;

    @AndroidFindBy(xpath = "//*[@resource-id = 'com.revolut.revolut.test:id/sms_editor']")
    private MobileElement codeInput;

    @PostConstruct
    private void init() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    public void enterCode() {
        codeInput.sendKeys(debugSmsCode.getText());
    }
}
