package com.project.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Component
@Getter
public class HeaderBlock {

    @Autowired
    private AppiumDriver driver;

    @AndroidFindBy(xpath = "//*[@resource-id = 'com.revolut.revolut.test:id/menu_action_info']")
    private MobileElement infoBtn;

    @AndroidFindBy(xpath = "//*[@resource-id = 'android.widget.ImageButton']")
    private MobileElement closeBtn;

    @PostConstruct
    private void init() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

}
