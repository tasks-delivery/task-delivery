package selenium.navbar;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium.config.BaseTest;
import selenium.loginAndRegistration.SignUpPage;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BlogPageTest extends BaseTest {

    BlogPage blogPage;
    SignUpPage signUpPage;

    public BlogPageTest(){
        blogPage = new BlogPage(driver);
        signUpPage = new SignUpPage(driver);
    }

    @BeforeClass
    public void preconditions(){
        signUpPage.createNewUser("testblog", "password", "password");
        signUpPage.logoutFromSystem();
    }

    @Test(description = "Docs page should be visible by clicking 'Docs' in navbar panel")
    public void redirectToDocsPage(){
        open(baseUrl);
        $(blogPage.btnBlog).click();
        $(blogPage.blogInfo).shouldHave(text("Test blog content"));
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
        $(blogPage.footer).shouldHave(text(blogPage.copyrightTaskDelivery2018));
        $(blogPage.footerLinks).shouldHave(attribute("href", blogPage.linkToGitHubRepo));
    }

    @Test(description = "Verify logout button")
    public void logoutButtonShouldBeVisible() {
        signUpPage.loginToSystem("testblog", "password");
        $(blogPage.btnAbout).click();
        $(blogPage.btnAbout).shouldBe(visible).shouldHave(text("About")).exists();
        $(blogPage.btnBlog).shouldBe(visible).shouldHave(text("Blog")).exists();
        $(blogPage.btnDocs).shouldBe(visible).shouldHave(text("Docs")).exists();
        $(blogPage.btnSignIn).shouldNotBe(visible);
        $(blogPage.btnSupport).shouldBe(visible).shouldHave(text("Support")).exists();
        $(blogPage.btnLogout).shouldBe(visible);
        $(blogPage.appName).shouldBe(visible);
        $(blogPage.tdLogo).shouldBe(visible).exists();
        signUpPage.logoutFromSystem();
    }

}