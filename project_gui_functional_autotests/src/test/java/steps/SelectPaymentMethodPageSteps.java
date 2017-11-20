package steps;

import com.project.pages.SelectPaymentMethodPage;
import com.project.pages.TypeSmsCodeBlock;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

public class SelectPaymentMethodPageSteps extends BaseSteps{

    @Autowired
    private SelectPaymentMethodPage selectPaymentMethodPage;

    @When("^I select \"([^\"]*)\" option$")
    public void iSelectOption(String optionName) {
        selectPaymentMethodPage.selectOption(optionName);
    }
}
