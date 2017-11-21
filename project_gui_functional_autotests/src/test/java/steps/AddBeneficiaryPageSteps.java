package steps;

import com.project.pages.AddBeneficiaryPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;

import static io.qala.datagen.RandomShortApi.english;
import static io.qala.datagen.RandomShortApi.integer;
import static io.qala.datagen.RandomShortApi.numeric;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AddBeneficiaryPageSteps extends BaseSteps{

    @Autowired
    private AddBeneficiaryPage addBeneficiaryPage;

    public static final String FIRST_NAME_KEY = "firstName";
    public static final String LAST_NAME_KEY = "lastName";
    public static final String ACCOUNT_NUMBER_KEY = "accNumber";
    public static final String SORT_CODE_KEY = "sortCode";

    @When("^I choose \"([^\"]*)\" transfer type$")
    public void iChooseTransferType(String typeText) {
        addBeneficiaryPage.chooseTransferType(typeText);
    }

    @When("^I click 'Next' button$")
    public void iClickNextButton() {
        addBeneficiaryPage.getNextBtn().click();
    }

    @When("^I select random country$")
    public void iSelectRandomCountry() {
        addBeneficiaryPage.selectRandomCountry();
    }

    @When("^I select random currency$")
    public void iSelectRandomCurrency() {
        addBeneficiaryPage.selectRandomCurrency();
    }

    @When("^I type random first name$")
    public void iTypeRandomFirstName() {
        String firstName = english(5, 20);
        addBeneficiaryPage.getFirstName().sendKeys(firstName);
        stepContainer.store(FIRST_NAME_KEY, firstName);
    }

    @When("^I type random last name$")
    public void iTypeRandomLastName() {
        String lastName = english(5, 20);
        addBeneficiaryPage.getLastName().sendKeys(lastName);
        stepContainer.store(LAST_NAME_KEY, lastName);
    }

    @When("^I type random account number$")
    public void iTypeRandomAccountNumber() {
        String accNum = numeric(8);
        addBeneficiaryPage.getAccountNumber().sendKeys(accNum);
        stepContainer.store(ACCOUNT_NUMBER_KEY, accNum);
    }

    @When("^I type random sort code$")
    public void iTypeRandomSortCode() {
        String sortCode = numeric(6);
        addBeneficiaryPage.getSortCode().sendKeys(sortCode);
        stepContainer.store(SORT_CODE_KEY, sortCode);
    }

    @Then("^'Successfully Created' message is displayed with right name$")
    public void successfullyCreatedMessageIsDisplayedWithRightName() {
        String firstName = stepContainer.getValueAsString(FIRST_NAME_KEY);
        String lastName = stepContainer.getValueAsString(LAST_NAME_KEY);
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(driverUtils.isElementDisplayed(addBeneficiaryPage.getSuccessIcon()))
                .as("Success icon is displayed")
                .isTrue();
        assertThat(driverUtils.isElementDisplayed(addBeneficiaryPage.getSuccessMessage()))
                .as("Success message is displayed")
                .isTrue();
        assertions.assertThat(addBeneficiaryPage.getSuccessMessage().getText().trim())
                .as("Success message is correct")
                .isEqualTo(String.format("Beneficiary %s %s was successfully created", firstName, lastName));
        assertions.assertAll();
    }

    @And("^I click 'Done' button$")
    public void iClickDoneButton() {
        addBeneficiaryPage.getDoneBtn().click();
    }
}
