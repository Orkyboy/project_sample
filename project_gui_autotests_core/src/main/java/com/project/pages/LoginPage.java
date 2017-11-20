package com.project.pages;

import com.project.util.DriverUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
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
public class LoginPage extends BasePage {


    @Value("${user.telCode:+44}")
    private String userTelCode;

    @Value("${user.tel:1217104665}")
    private String userTel;

    @Value("#{'${user.default.code:1,2,4,5}'.split(',')}")
    private List<String> userCode;

    @FindBy(xpath = "//*[@resource-id = 'com.revolut.revolut.test:id/uic_edit_country_code']")
    private MobileElement countryField;

    @FindBy(xpath = "//*[@resource-id = 'com.revolut.revolut.test:id/search_src_text']")
    private MobileElement searchField;

    @FindBy(xpath = "//*[@resource-id = 'com.revolut.revolut.test:id/country_item']")
    private MobileElement firstCountryItem;

    @FindBy(xpath = "//*[@resource-id = 'com.revolut.revolut.test:id/uic_edit_phone_number']")
    private MobileElement telField;

    @FindBy(xpath = "//*[@resource-id = 'com.revolut.revolut.test:id/signup_next']")
    private MobileElement nextBtn;

    @PostConstruct
    private void init() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    public void login(String telCode, String tel, List<String> code) {
        countryField.click();
        searchField.sendKeys(telCode);
        firstCountryItem.click();
        telField.sendKeys(tel);
        nextBtn.click();
        typeCodeBlock.typeCode(code);
    }

    public void login() {
        login(userTelCode, userTel, userCode);
    }
}
