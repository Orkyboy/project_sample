package com.project.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@Getter
public class SelectPaymentMethodPage extends BasePage {


    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView")
    private List<MobileElement> options;

    @PostConstruct
    private void init() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    public void selectOption(String optionName) {
        for (MobileElement opt: options) {
            if (opt.getText().trim().equals(optionName)) {
                opt.click();
                return;
            }
        }
        throw new IllegalArgumentException("No option was found: " + optionName);
    }
}
