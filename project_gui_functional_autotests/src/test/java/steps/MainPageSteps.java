package steps;

import com.project.pages.LoginPage;
import com.project.pages.MainPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPageSteps extends BaseSteps{

    @Autowired
    private MainPage mainPage;


    @Then("^Main Page is displayed$")
    public void mainPageIsDisplayed() {
        assertThat(mainPage.isPageDisplayed())
                .as("Main page s displayed")
                .isTrue();
    }

    @Given("^I am on the Main Page$")
    public void iAmOnTheMainPage() {
        if (!mainPage.isPageDisplayed()
                && driverUtils.isElementDisplayed(mainPage.getHeaderBlock().getCloseBtn())) {
            mainPage.getHeaderBlock().getCloseBtn().click();
        }
        if (!mainPage.isPageDisplayed()) {
            throw new IllegalStateException("Not on the main page and no close btn is displayed");
        }
    }

    @When("^I click transfer button$")
    public void iClickTransferButton() {
        mainPage.getTransferButton().click();
    }
}
