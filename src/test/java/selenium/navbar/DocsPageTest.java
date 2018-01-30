package selenium.navbar;

import org.testng.annotations.Test;
import selenium.config.BaseTest;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DocsPageTest extends BaseTest {

    DocsPage docsPage;

    public DocsPageTest(){
        docsPage = new DocsPage(driver);
    }

    @Test(description = "Docs page should be visible by clicking 'Docs' in navbar panel")
    public void redirectToDocsPage(){
        open(baseUrl);
        $(docsPage.btnDocs).click();
        $(docsPage.rightColumn).shouldHave(text("Test docs right column"));
        $(docsPage.leftColumn).shouldHave(text("Test docs left column"));
    }

    @Test(description = "Verify navbar elements")
    public void navBarShouldBeVisibleOnDocsPage(){
        open(baseUrl);
        $(docsPage.btnDocs).click();
        $(docsPage.btnAbout).shouldBe(visible).shouldHave(text("About")).exists();
        $(docsPage.btnBlog).shouldBe(visible).shouldHave(text("Blog")).exists();
        $(docsPage.btnDocs).shouldBe(visible).shouldHave(text("Docs")).exists();
        $(docsPage.btnSignIn).shouldBe(visible).shouldHave(text("Sign up")).exists();
        $(docsPage.btnSupport).shouldBe(visible).shouldHave(text("Support")).exists();
        $(docsPage.appName).shouldBe(visible);
        $(docsPage.tdLogo).shouldBe(visible).exists();
    }

    @Test(description = "Footer with link to github should be visible")
    public void footerWithTextAndLinkElementsShouldBeVisible(){
        open(baseUrl);
        $(docsPage.btnDocs).click();
        $(docsPage.footer).shouldHave(text(docsPage.copyrightTaskDelivery2018));
        $(docsPage.footerLinks).shouldHave(attribute("href", docsPage.linkToGitHubRepo));
    }
}