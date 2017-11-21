package com.project.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.qala.datagen.RandomShortApi.integer;

@Component
@Getter
public class AddBeneficiaryPage extends BasePage {

    @AndroidFindBy(xpath = "//*[@resource-id = 'com.revolut.revolut.test:id/items_type_group']//android.widget.TextView")
    private List<MobileElement> transferTypes;

    @AndroidFindBy(id = "button_next")
    private MobileElement nextBtn;

    @AndroidFindBy(id = "operation_status_button")
    private MobileElement doneBtn;

    @AndroidFindBy(id = "edit_country")
    private MobileElement countryField;

    @AndroidFindBy(xpath = "//*[@resource-id = 'com.revolut.revolut.test:id/countriesList']/android.widget.LinearLayout")
    private List<MobileElement> countries;

    @AndroidFindBy(id = "edit_currency")
    private MobileElement currencyField;

    @AndroidFindBy(id = "currency")
    private List<MobileElement> currencies;

    @AndroidFindBy(id = "first_name")
    private MobileElement firstName;

    @AndroidFindBy(id = "last_name")
    private MobileElement lastName;

    @AndroidFindBy(id = "server_field_0")
    private MobileElement accountNumber;

    @AndroidFindBy(id = "server_field_1")
    private MobileElement sortCode;

    @AndroidFindBy(id = "operation_state_icon_fixed")
    private MobileElement successIcon;

    @AndroidFindBy(id = "operation_state_title")
    private MobileElement successMessage;


    @PostConstruct
    private void init() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
    }


    public void chooseTransferType(String type) {
        for (MobileElement typeEl : transferTypes) {
            String s = typeEl.getText();
            if (typeEl.getText().trim().equals(type)) {
                typeEl.click();
                return;
            }
        }
        throw new IllegalArgumentException("No transfer type was found:" + type);
    }

    public void selectRandomCountry() {
        countryField.click();
        countries.get(integer(countries.size()-1)).click();
    }
    public void selectRandomCurrency() {
        currencyField.click();
        currencies.get(integer(currencies.size()-1)).click();
    }
}
