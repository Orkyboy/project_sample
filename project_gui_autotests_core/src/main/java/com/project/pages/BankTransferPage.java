package com.project.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@Getter
public class BankTransferPage extends BasePage {


    @FindBy(xpath = "//android.widget.TextView[@text = 'Add a new beneficiary']") //bad locator bacause of translation
    private MobileElement addNewBenBtn;

    @FindBy(xpath = "//*[@resource-id = 'com.revolut.revolut.test:id/list_header_text']")
    private MobileElement selLbl;

    @PostConstruct
    private void init() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

}
