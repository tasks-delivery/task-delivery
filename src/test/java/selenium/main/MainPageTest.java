package selenium.main;

import org.testng.annotations.Test;
import selenium.config.BaseTest;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTest extends BaseTest {

    MainPage mainPage;

    public MainPageTest(){
        mainPage = new MainPage(driver);
    }

    @Test(enabled = false, description = "Check text near picture")
    public void textNearPictureShouldBeVisible(){
        open(baseUrl);
        $(mainPage.infoText).shouldHave(text("Generates progress reports"))
        .shouldHave(text("Keeps track of the progress through testing scenarios"))
        .shouldHave(text("Combines test specs into test coverage scenarios"))
        .shouldHave(text("Manage requirements, features and use-cases"));
    }

    @Test(description = "Verify menu item in top bar")
    public void menuItemInTopBarShouldVisible(){
        open(baseUrl);
        $(mainPage.btnAbout).shouldBe(visible).shouldHave(text("About")).exists();
        $(mainPage.btnBlog).shouldBe(visible).shouldHave(text("Blog")).exists();
        $(mainPage.btnDocs).shouldBe(visible).shouldHave(text("Docs")).exists();
        $(mainPage.btnSignIn).shouldBe(visible).shouldHave(text("Sign up")).exists();
        $(mainPage.btnSupport).shouldBe(visible).shouldHave(text("Support")).exists();
        $(mainPage.appName).shouldBe(visible);
        $(mainPage.tdLogo).shouldBe(visible).exists();
    }

    @Test(enabled = false, description = "Verify big button 'Registration' and 'How it works'")
    public void buttonsRegistrationAndHowItWorksShouldBeVisible(){
        open(baseUrl);
        $(mainPage.btnRegistration).shouldBe(visible).shouldHave(text("Registration")).exists();
        $(mainPage.btnHowItWork).shouldBe(visible).shouldHave(text("How it works")).exists();
    }

    @Test(enabled = false, description = "Picture with application should be visible")
    public void pictureWithApplication(){
        open(baseUrl);
        $(mainPage.applicationPicture).shouldBe(visible).exists();
    }

    @Test(enabled = false, description = "Pictures near text should be visible")
    public void picturesNearTextInfo(){
        open(baseUrl);
        $(mainPage.bugPicture).shouldBe(visible).exists();
        $(mainPage.managePicture).shouldBe(visible).exists();
        $(mainPage.scenariosPicture).shouldBe(visible).exists();
        $(mainPage.specsPicture).shouldBe(visible).exists();
    }

}