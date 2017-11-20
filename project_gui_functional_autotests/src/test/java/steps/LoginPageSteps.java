package steps;

import com.project.pages.LoginPage;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginPageSteps extends BaseSteps{

    @Autowired
    private LoginPage loginPage;

    @When("^I log in as default user$")
    public void iLoginAsDefaultUser() {
        loginPage.login();
    }
}
