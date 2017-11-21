package steps;

import com.project.pages.BankTransferPage;
import com.project.pages.StartPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.TouchAction;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;


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

    @Then("^first beneficiary item contains newly created information$")
    public void firstBeneficiaryItemContainsNewlyCreatedInformation() {
        String firstName = stepContainer.getValueAsString(AddBeneficiaryPageSteps.FIRST_NAME_KEY);
        String lastName = stepContainer.getValueAsString(AddBeneficiaryPageSteps.LAST_NAME_KEY);
        String accNum = stepContainer.getValueAsString(AddBeneficiaryPageSteps.ACCOUNT_NUMBER_KEY);
        String sortCode = stepContainer.getValueAsString(AddBeneficiaryPageSteps.SORT_CODE_KEY);
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(bankTransferPage.getBeneficiaryNameAndCurrency(0))
                .as("Name is correct")
                .startsWith(firstName + " " + lastName);
        assertions.assertThat(bankTransferPage.getBeneficiaryAccountNumber(0))
                .as("Account Number is correct")
                .endsWith(accNum);
        assertions.assertThat(bankTransferPage.getBeneficiarySortCode(0))
                .endsWith(sortCode);
        assertions.assertAll();
    }
}
