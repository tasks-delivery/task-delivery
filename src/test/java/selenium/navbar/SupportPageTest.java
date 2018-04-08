package selenium.navbar;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium.config.BaseTest;
import selenium.loginAndRegistration.SignUpPage;

import java.awt.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SupportPageTest extends BaseTest {

    SupportPage supportPage;
    SignUpPage signUpPage;

    public SupportPageTest(){
        supportPage = new SupportPage(driver);
        signUpPage = new SignUpPage(driver);
    }

    @BeforeClass
    public void preconditions() throws AWTException {
        signUpPage.createNewUser("testsupport", "password", "password");
        signUpPage.logoutFromSystem();
    }

    @Test(description = "Docs page should be visible by clicking 'Docs' in navbar panel")
    public void redirectToDocsPage(){
        open(baseUrl);
        $(supportPage.btnSupport).click();
        $(supportPage.supportInfo).shouldHave(text("Test support content"));
    }

    @Test(description = "Verify navbar elements")
    public void navBarShouldBeVisibleOnSupportPage(){
        open(baseUrl);
        $(supportPage.btnSupport).click();
        $(supportPage.btnAbout).shouldBe(visible).shouldHave(text("About")).exists();
        $(supportPage.btnBlog).shouldBe(visible).shouldHave(text("Blog")).exists();
        $(supportPage.btnDocs).shouldBe(visible).shouldHave(text("Docs")).exists();
        $(supportPage.btnSignIn).shouldBe(visible).shouldHave(text("Sign up")).exists();
        $(supportPage.btnSupport).shouldBe(visible).shouldHave(text("Support")).exists();
        $(supportPage.appName).shouldBe(visible);
        $(supportPage.tdLogo).shouldBe(visible).exists();
    }

    @Test(description = "Footer with link to github should be visible")
    public void footerWithTextAndLinkElementsShouldBeVisible(){
        open(baseUrl);
        $(supportPage.btnSupport).click();
        $(supportPage.footer).shouldHave(text(supportPage.copyrightTaskDelivery2018));
        $(supportPage.footerLinks).shouldHave(attribute("href", supportPage.linkToGitHubRepo));
    }

    @Test(description = "Verify logout button")
    public void logoutButtonShouldBeVisible() throws AWTException {
        signUpPage.loginToSystem("testsupport", "password");
        $(supportPage.btnAbout).click();
        $(supportPage.btnAbout).shouldBe(visible).shouldHave(text("About")).exists();
        $(supportPage.btnBlog).shouldBe(visible).shouldHave(text("Blog")).exists();
        $(supportPage.btnDocs).shouldBe(visible).shouldHave(text("Docs")).exists();
        $(supportPage.btnSignIn).shouldNotBe(visible);
        $(supportPage.btnSupport).shouldBe(visible).shouldHave(text("Support")).exists();
        $(supportPage.btnLogout).shouldBe(visible);
        $(supportPage.appName).shouldBe(visible);
        $(supportPage.tdLogo).shouldBe(visible).exists();
        signUpPage.logoutFromSystem();
    }

}