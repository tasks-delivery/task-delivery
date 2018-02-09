package selenium.loginAndRegistration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium.config.BaseTest;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SignUpPageTest extends BaseTest {

    SignUpPage signUpPage;

    private SignUpPageTest(){
        signUpPage = new SignUpPage(driver);
    }

    @BeforeClass
    public void preconditions(){
        signUpPage.createNewUser("testuser","testpassword","testpassword");
        signUpPage.logoutFromSystem();
        refresh();
    }

    @Test(description = "Registration page should  be visible by clicking on 'Create an account'")
    public void getRegistrationPageByClickingCreateAnAccount(){
        open(baseUrl);
        $(signUpPage.btnSignIn).click();
        $(signUpPage.linkCreateAcc).click();
        $(signUpPage.fieldUsername).shouldBe(visible).exists();
        $(signUpPage.fieldPass).shouldBe(visible).exists();
        $(signUpPage.fieldPassConfirm).shouldBe(visible).exists();
        $(signUpPage.usernamePlaceholder).shouldBe(visible).exists();
        $(signUpPage.passPlaceholder).shouldBe(visible).exists();
        $(signUpPage.passConfirmPlaceholder).shouldBe(visible).exists();
        $(signUpPage.btnSubmit).shouldBe(visible).exists();
    }

    @Test(description = "Registration page should  be visible by clicking on 'Sign up'")
    public void getLoginPageByClickingSignUp(){
        open(baseUrl);
        $(signUpPage.btnSignIn).click();
        $(signUpPage.btnLogin).shouldBe(visible).exists();
        $(signUpPage.fieldUsername).shouldBe(visible).exists();
        $(signUpPage.fieldPass).shouldBe(visible).exists();
        $(signUpPage.linkCreateAcc).shouldBe(visible).exists();
        $(signUpPage.usernamePlaceholder).shouldBe(visible).exists();
        $(signUpPage.passPlaceholder).shouldBe(visible).exists();
    }

    @Test(description = "Login to the system")
    public void loginToSystem(){
        signUpPage.loginToSystem("testuser","testpassword");
        $(signUpPage.userInfo).shouldHave(text("Welcome testuser")).exists();
        $(signUpPage.logoutForm).shouldBe(visible);
        signUpPage.logoutFromSystem();
    }

    @Test(description = "Create new acc")
    public void createNewAcc(){
        signUpPage.createNewUser("testing","123456789","123456789");
        $(signUpPage.userInfo).shouldHave(text("Welcome testing")).exists();
        $(signUpPage.logoutForm).shouldBe(visible);
        signUpPage.logoutFromSystem();
    }

    @Test(description = "Validation message should visibile if username contains invalid data")
    public void loginWithInvalidUsername(){
        signUpPage.loginToSystem("testuser1","testpassword");
        $(signUpPage.logoutForm).shouldNotBe(visible);
        $(signUpPage.loginFormError).shouldHave(text(signUpPage.yourUsernameAndPasswordIsInvalid));
    }

    @Test(description = "Validation message should visibile if password contains invalid data")
    public void loginWithInvalidPassword(){
        signUpPage.loginToSystem("testuser","testpassword1");
        $(signUpPage.logoutForm).shouldNotBe(visible);
        $(signUpPage.loginFormError).shouldHave(text(signUpPage.yourUsernameAndPasswordIsInvalid));
    }

    @Test(description = "Validation message should visibile if username contains invalid data")
    public void registrationWithInvalidUsername(){
        signUpPage.createNewUser("user", "123456789", "123456789");
        $(signUpPage.logoutForm).shouldNotBe(visible);
        $(signUpPage.userError).shouldHave(text(signUpPage.pleaseUseBetween6And32Characters));
        $(signUpPage.userError).shouldHave(text(signUpPage.pleaseUseBetween6And32Characters));
    }

    @Test(description = "Validation message should visibile if password contains invalid data")
    public void registrationWithInvalidPassword(){
        signUpPage.createNewUser("validuser", "pass", "123456789");
        $(signUpPage.passError).shouldHave(text(signUpPage.tryOneWithAtLeast8Characters));
        $(signUpPage.logoutForm).shouldNotBe(visible);
    }

    @Test(description = "Validation message should visibile if confirm password contains invalid data")
    public void registrationWithInvalidConfirmPassword(){
        signUpPage.createNewUser("validuser", "validpass", "123456789");
        $(signUpPage.confirmPassError).shouldHave(text(signUpPage.thesePasswordsDoNotMatch));
        $(signUpPage.logoutForm).shouldNotBe(visible);
    }

    @Test(description = "validation for requirement field should be visible")
    public void validationForRequiredFieldsRegistrationPage(){
        signUpPage.createNewUser("", "", "");
        $(signUpPage.userError).shouldHave(text(signUpPage.thisFieldIsRequired));
        $(signUpPage.passError).shouldHave(text(signUpPage.thisFieldIsRequired));
        $(signUpPage.confirmPassError).shouldHave(text(signUpPage.thisFieldIsRequired));
    }

    @Test(description = "It is possbile to logout from the system")
    public void logoutFromSystem(){
        signUpPage.loginToSystem("testuser","testpassword");
        signUpPage.logoutFromSystem();
        $(signUpPage.logoutForm).shouldNotBe(visible);
        $(byText(signUpPage.youHaveBeenLoggedOutSuccessfully)).shouldBe(visible);
    }

    @Test(description = "Same user should not be created")
    public void createDuplicateUser(){
        signUpPage.createNewUser("testuser","testpassword","testpassword");
        $(signUpPage.userError).shouldHave(text(signUpPage.SomeoneAlreadyHasThatUsername));
        $(signUpPage.logoutForm).shouldNotBe(visible);
    }

    @Test(description = "Verify navbar elements")
    public void navBarShouldBeVisibleOnRegistrationPage(){
        open(baseUrl);
        $(signUpPage.btnSignIn).click();
        $(signUpPage.linkCreateAcc).click();
        $(signUpPage.btnAbout).shouldBe(visible).shouldHave(text("About")).exists();
        $(signUpPage.btnBlog).shouldBe(visible).shouldHave(text("Blog")).exists();
        $(signUpPage.btnDocs).shouldBe(visible).shouldHave(text("Docs")).exists();
        $(signUpPage.btnSignIn).shouldBe(visible).shouldHave(text("Sign up")).exists();
        $(signUpPage.btnSupport).shouldBe(visible).shouldHave(text("Support")).exists();
        $(signUpPage.appName).shouldBe(visible);
        $(signUpPage.tdLogo).shouldBe(visible).exists();
    }

    @Test(description = "Verify navbar elements")
    public void navBarShouldBeVisibleOnLoginPage(){
        open(baseUrl);
        $(signUpPage.btnSignIn).click();
        $(signUpPage.btnAbout).shouldBe(visible).shouldHave(text("About")).exists();
        $(signUpPage.btnBlog).shouldBe(visible).shouldHave(text("Blog")).exists();
        $(signUpPage.btnDocs).shouldBe(visible).shouldHave(text("Docs")).exists();
        $(signUpPage.btnSignIn).shouldBe(visible).shouldHave(text("Sign up")).exists();
        $(signUpPage.btnSupport).shouldBe(visible).shouldHave(text("Support")).exists();
        $(signUpPage.appName).shouldBe(visible);
        $(signUpPage.tdLogo).shouldBe(visible).exists();
    }

    @Test(description = "Footer with link to github should be visible on login page")
    public void footerWithTextAndLinkElementsShouldBeVisibleOnLoginPage(){
        open(baseUrl);
        $(signUpPage.btnSignIn).click();
        $(signUpPage.footer).shouldHave(text(signUpPage.copyrightTaskDelivery2018));
        $(signUpPage.footerLinks).shouldHave(attribute("href", signUpPage.linkToGitHubRepo));
    }

    @Test(description = "Footer with link to github should be visible on registration page")
    public void footerWithTextAndLinkElementsShouldBeVisibleOnRegistrationPage(){
        open(baseUrl);
        $(signUpPage.btnSignIn).click();
        $(signUpPage.linkCreateAcc).click();
        $(signUpPage.footer).shouldHave(text(signUpPage.copyrightTaskDelivery2018));
        $(signUpPage.footerLinks).shouldHave(attribute("href", signUpPage.linkToGitHubRepo));
    }

}