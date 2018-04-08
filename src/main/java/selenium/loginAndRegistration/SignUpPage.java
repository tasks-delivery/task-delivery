package selenium.loginAndRegistration;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.config.BasePage;

import java.awt.*;
import java.awt.event.KeyEvent;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
//import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.open;

public class SignUpPage extends BasePage {

    public String yourUsernameAndPasswordIsInvalid = "Your username and password is invalid.";
    public String pleaseUseBetween6And32Characters = "Please use between 6 and 32 characters.";
    public String thisFieldIsRequired = "This field is required.";
    public String tryOneWithAtLeast8Characters = "Try one with at least 8 characters.";
    public String thesePasswordsDoNotMatch = "These passwords don\'t match.";
    public String youHaveBeenLoggedOutSuccessfully = "You have been logged out successfully.";
    public String SomeoneAlreadyHasThatUsername = "Someone already has that username.";

    SelenideElement fieldUsername = $(By.name("username")),
    fieldPass = $(By.name("password")),
    fieldPassConfirm = $(By.name("passwordConfirm")),
    btnLogin = $(By.xpath("//*[@class='login']//BUTTON[text()='Login']/self::BUTTON")),
    btnSubmit = $(By.xpath("//*[@class='registration']//button[text()='Submit']/self::BUTTON")),

    linkCreateAcc = $(By.xpath("//*[@class='login']//a[text()='Create an account']/self::A")),
    usernamePlaceholder = $(By.xpath("//INPUT[@placeholder='Username']/self::INPUT")),
    passPlaceholder = $(By.xpath("//INPUT[@placeholder='Password']/self::INPUT")),
    passConfirmPlaceholder = $(By.xpath("//INPUT[@placeholder='Confirm your password']/self::INPUT")),
    userInfo = $(By.xpath("//*[@class='welcome-user']")),
    loginFormError = $(By.xpath("//*[@class='login']//SPAN[text()='Your username and password is invalid.']/self::SPAN")),
    logoutForm = $(By.id("logoutForm")),
    userError = $(By.xpath("//SPAN[@id='username.errors']/self::SPAN")),
    passError = $(By.xpath("//SPAN[@id='password.errors']/self::SPAN")),
    confirmPassError = $(By.xpath("//SPAN[@id='passwordConfirm.errors']/self::SPAN"));

    public void logoutFromSystem(){
        open(baseUrl);
        Selenide.refresh();
        $(btnLogout).click();
    }

    public void createNewUser(String username, String password, String confirm) throws AWTException {
        open(baseUrl);
        $(btnSignIn).click();
        $(linkCreateAcc).click();
        $(fieldUsername).val(username);
        $(fieldPass).val(password);
        $(fieldPassConfirm).val(confirm);
        $(btnSubmit).click();
     //   Selenide.switchTo().alert().dismiss();
        $(footer).click();
    }

    public void loginToSystem(String username, String password) throws AWTException {
        open(baseUrl);
        $(btnSignIn).click();
        $(fieldUsername).val(username);
        $(fieldPass).val(password);
        $(btnLogin).click();
     //   Selenide.switchTo().alert().dismiss();
        $(footer).click();
    }

    public SignUpPage(WebDriver driver) {
        super(driver);
    }
}
