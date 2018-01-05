package selenium.blog;

import org.testng.annotations.Test;
import selenium.config.BaseTest;
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

}