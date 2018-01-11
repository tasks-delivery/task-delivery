package selenium.main;

import org.testng.annotations.Test;
import selenium.config.BaseTest;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTest extends BaseTest {

    MainPage mainPage;

    public MainPageTest(){
        mainPage = new MainPage(driver);
    }

    @Test(description = "Check text near picture")
    public void textNearPictureShouldBeVisible(){
        open(baseUrl);
        $(mainPage.textTestCaseImg).shouldHave(text("Keeps track of the progress through testing scenarios"));
        $(mainPage.textManageImg).shouldHave(text("Manage requirements, features and use-cases"));
        $(mainPage.textReportImg).shouldHave(text("Generates progress reports"));
        $(mainPage.textSpecImg).shouldHave(text("Combines test specs into test coverage scenarios"));
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

    @Test(description = "Pictures in the middle page part should be visible")
    public void picturesMiddlePagePart(){
        open(baseUrl);
        $(mainPage.applicationImg).shouldBe(visible).exists();
        $(mainPage.reportImg).shouldBe(visible).exists();
        $(mainPage.manageImg).shouldBe(visible).exists();
        $(mainPage.testCaseImg).shouldBe(visible).exists();
        $(mainPage.specImg).shouldBe(visible).exists();
    }

    @Test(description = "Footer with link to github should be visible")
    public void footerWithTextAndLinkElementsShouldBeVisible(){
        open(baseUrl);
        $(mainPage.footer).shouldHave(text(mainPage.copyrightTaskDelivery2018)).shouldBe(visible).exists();
        $(mainPage.footerLinks).shouldHave(attribute("href", mainPage.linkToGitHubRepo));
    }

}