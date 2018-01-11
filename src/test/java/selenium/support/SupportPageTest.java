package selenium.support;

import org.testng.annotations.Test;
import selenium.config.BaseTest;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SupportPageTest extends BaseTest {

    SupportPage supportPage;

    public SupportPageTest(){
        supportPage = new SupportPage(driver);
    }

    @Test(description = "Docs page should be visible by clicking 'Docs' in navbar panel")
    public void redirectToDocsPage(){
        open(baseUrl);
        $(supportPage.btnSupport).click();
        $(byText("Support page")).shouldBe(visible).exists();
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

    @Test(enabled = false, description = "Footer with link to github should be visible")
    public void footerWithTextAndLinkElementsShouldBeVisible(){
        open(baseUrl);
        $(supportPage.btnSupport).click();
        $(supportPage.footer).shouldHave(text(supportPage.copyrightTaskDelivery2018)).shouldBe(visible).exists();
        $(supportPage.footerLinks).shouldHave(attribute("href", supportPage.linkToGitHubRepo));
    }

}