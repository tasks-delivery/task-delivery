package selenium.loginAndRegistration;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import selenium.config.BaseTest;
import selenium.main.MainPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.Keys.ESCAPE;
import static org.testng.Assert.*;

public class LoginModalWindowTest extends BaseTest {

    LoginModalWindow loginModalWindow;
    MainPage mainPage;

    private LoginModalWindowTest(){
        mainPage = new MainPage(driver);
        loginModalWindow = new LoginModalWindow(driver);
    }

    @Test(description = "Registration modal window  should not be visible")
    public void registrationWindowShouldNotBeVisible(){
        open(baseUrl);
        $(loginModalWindow.regModalWindow).shouldNotBe(visible);
    }

    @Test(description = "Registration modal window  should not be visible by clicking on 'Sign up'")
    public void registrationWindowShouldBeVisibleByClicking(){
        open(baseUrl);
        $(mainPage.btnSignIn).click();
        $(loginModalWindow.regModalWindow).shouldBe(visible);
    }

    @Test(enabled = false, description = "Login to the system")
    public void loginToSystem(){
    }

    @Test(description = "Registration modal window  should not be visible by clicking on 'Sign up'")
    public void linkForCreationNewAcc(){
        open(baseUrl);
        $(mainPage.btnSignIn).click();
        $(loginModalWindow.regModalWindow).shouldBe(visible);
    }

    @Test(enabled = false, description = "Create new acc")
    public void createNewAcc(){

    }

    @Test(enabled = false, description = "Validation message should visibile if request contains invalid data")
    public void invalidLoginToSystem(){

    }

    @Test(description = "All necessary elements should be visible on modal window")
    public void webElementOnTheLoginModalWindow(){
        open(baseUrl);
        $(mainPage.btnSignIn).click();
        $(loginModalWindow.btnLogin).shouldBe(visible).exists();
        $(loginModalWindow.fieldUsername).shouldBe(visible).exists();
        $(loginModalWindow.fieldPassword).shouldBe(visible).exists();
        $(loginModalWindow.linkCreateAcc).shouldBe(visible).exists();
        $(loginModalWindow.usernamePlaceholder).shouldBe(visible).exists();
        $(loginModalWindow.passwordPlaceholder).shouldBe(visible).exists();
    }

    @Test(description = "Close login modal window  by press 'Esc' button ")
    public void closeWindowByESC(){
        open(baseUrl);
        $(mainPage.btnSignIn).click();
        $(loginModalWindow.regModalWindow).shouldBe(visible);
        $(loginModalWindow.regModalWindow).sendKeys(ESCAPE);

    }

}