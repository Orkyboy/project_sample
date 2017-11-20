package steps;

import com.project.pages.BankTransferPage;
import com.project.pages.StartPage;
import com.project.pages.TypeSmsCodeBlock;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.touch.SingleTapAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BankTransferPageSteps extends BaseSteps{

    @Autowired
    private BankTransferPage bankTransferPage;

    @Autowired
    private StartPage startPage;


    @Then("^'Add a new beneficiary' button is displayed$")
    public void addANewBeneficiaryButtonIsDisplayed() {
        assertThat(driverUtils.isElementDisplayed(bankTransferPage.getAddNewBenBtn()))
                .as("'Add a new beneficiary' button is displayed")
                .isTrue();
    }

    @When("^I press on 'Add a new beneficiary' button$")
    public void iPressOnAddANewBeneficiaryButton() {
//        bankTransferPage.getAddNewBenBtn().click();
        TouchAction a2 = new TouchAction(driver);
        a2.tap(216, 503).perform();
    }
}
