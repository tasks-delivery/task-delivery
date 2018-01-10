package selenium.blog;

import org.testng.annotations.Test;
import selenium.config.BaseTest;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BlogPageTest extends BaseTest {

    BlogPage blogPage;

    public BlogPageTest(){
        blogPage = new BlogPage(driver);
    }

    @Test(description = "Docs page should be visible by clicking 'Docs' in navbar panel")
    public void redirectToDocsPage(){
        open(baseUrl);
        $(blogPage.btnBlog).click();
        $(byText("Blog page")).shouldBe(visible).exists();
    }

    @Test(description = "Verify navbar elements")
    public void navBarShouldBeVisibleOnBlogPage(){
        open(baseUrl);
        $(blogPage.btnBlog).click();
        $(blogPage.btnAbout).shouldBe(visible).shouldHave(text("About")).exists();
        $(blogPage.btnBlog).shouldBe(visible).shouldHave(text("Blog")).exists();
        $(blogPage.btnDocs).shouldBe(visible).shouldHave(text("Docs")).exists();
        $(blogPage.btnSignIn).shouldBe(visible).shouldHave(text("Sign up")).exists();
        $(blogPage.btnSupport).shouldBe(visible).shouldHave(text("Support")).exists();
        $(blogPage.appName).shouldBe(visible);
        $(blogPage.tdLogo).shouldBe(visible).exists();
    }

    @Test(description = "Footer with link to github should be visible")
    public void footerWithTextAndLinkElementsShouldBeVisible(){
        open(baseUrl);
        $(blogPage.btnBlog).click();
        $(blogPage.footer).shouldHave(text(blogPage.copyrightTaskDelivery2018)).shouldBe(visible).exists();
        $(blogPage.footerLinks).shouldHave(attribute("href", blogPage.linkToGitHubRepo));
    }

}