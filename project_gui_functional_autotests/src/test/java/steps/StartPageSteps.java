package steps;

import com.project.pages.StartPage;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class StartPageSteps extends BaseSteps{

    @Autowired
    private StartPage startPage;

    @Given("^I skip login info$")
    public void iSkipLoginInfo() {
        startPage.getSkipLbl().click();
    }
}
