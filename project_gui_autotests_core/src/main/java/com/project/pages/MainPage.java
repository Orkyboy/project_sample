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
public class MainPage extends BasePage {

    @FindBy(xpath = "//*[@resource-id = 'com.revolut.revolut.test:id/uic_wallet_pager']")
    private MobileElement walletBalance;

    @FindBy(xpath = "//*[@resource-id = 'com.revolut.revolut.test:id/button_transfer']")
    private MobileElement transferButton;

    @PostConstruct
    private void init() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    public boolean isPageDisplayed() {
        return driverUtils.isElementDisplayed(walletBalance) &&
                driverUtils.isElementDisplayed(transferButton);
    }
}
