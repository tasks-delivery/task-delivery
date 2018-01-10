package selenium.about;

import org.testng.annotations.Test;
import selenium.config.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AboutPageTest extends BaseTest {

    AboutPage aboutPage;

    public AboutPageTest(){
        aboutPage = new AboutPage(driver);
    }

    @Test(description = "Docs page should be visible by clicking 'Docs' in navbar panel")
    public void redirectToDocsPage(){
        open(baseUrl);
        $(aboutPage.btnAbout).click();
        $(byText("About page")).shouldBe(visible).exists();
    }

    @Test(description = "Verify navbar elements")
    public void navBarShouldBeVisibleOnAboutPage(){
        open(baseUrl);
        $(aboutPage.btnAbout).click();
        $(aboutPage.btnAbout).shouldBe(visible).shouldHave(text("About")).exists();
        $(aboutPage.btnBlog).shouldBe(visible).shouldHave(text("Blog")).exists();
        $(aboutPage.btnDocs).shouldBe(visible).shouldHave(text("Docs")).exists();
        $(aboutPage.btnSignIn).shouldBe(visible).shouldHave(text("Sign up")).exists();
        $(aboutPage.btnSupport).shouldBe(visible).shouldHave(text("Support")).exists();
        $(aboutPage.appName).shouldBe(visible);
        $(aboutPage.tdLogo).shouldBe(visible).exists();
    }
}