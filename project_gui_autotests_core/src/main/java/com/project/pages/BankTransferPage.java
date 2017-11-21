package com.project.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.By;
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

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Add a new beneficiary']") //bad locator bacause of translation
    private MobileElement addNewBenBtn;

    @AndroidFindBy(id = "list_header_text")
    private MobileElement selLbl;

    @AndroidFindBy(id = "item_text_content")
    private List<MobileElement> beneficiaryItems;

    @PostConstruct
    private void init() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    public String getBeneficiaryNameAndCurrency(int index) {
        return beneficiaryItems.get(index).findElement(By.id("item_title")).getText().trim();
    }

    public String getBeneficiaryAccountNumber(int index) {
        return beneficiaryItems.get(index).findElement(By.id("item_subtitle1")).getText();
    }

    public String getBeneficiarySortCode(int index) {
        return beneficiaryItems.get(index).findElement(By.id("item_subtitle2")).getText();
    }
}
