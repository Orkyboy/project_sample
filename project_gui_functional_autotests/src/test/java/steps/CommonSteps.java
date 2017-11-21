package steps;

import com.project.pages.LoginPage;
import com.project.pages.TypeSecurityCodeBlock;
import com.project.pages.TypeSmsCodeBlock;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

public class CommonSteps extends BaseSteps{

    @Autowired
    private TypeSmsCodeBlock typeSmsCodeBlock;

    @Autowired
    private TypeSecurityCodeBlock typeSecurityCodeBlock;

    @When("^I enter SMS code$")
    public void iEnterSMSCode() {
        typeSmsCodeBlock.enterCode();
    }

    @When("^I skip all info by 'Not now' button$")
    public void iSkipAllInfoByNotNowButton() {
        String notNowBtnPath = "//*[@resource-id = 'com.revolut.revolut.test:id/uic_header_next']";
        while (driverUtils.isElementDisplayed(By.xpath(notNowBtnPath))) {
            driver.findElementByXPath(notNowBtnPath).click();
        }
    }

    @When("^I type security code$")
    public void iTypeSecurityCode() {
        typeSecurityCodeBlock.typeCode();
    }

    @Given("^fail$")
    public void fail() {
        Assert.fail("For failed test in report. You can watch on screenshot :)");
    }
}
