package com.project.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Component
@Getter
public class StartPage extends BasePage {

    @FindBy(xpath = "//*[@resource-id = 'com.revolut.revolut.test:id/header_next']")
    private MobileElement skipLbl;

    @PostConstruct
    private void init() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }
}
