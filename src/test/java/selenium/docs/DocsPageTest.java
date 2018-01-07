package selenium.docs;

import org.testng.annotations.Test;
import selenium.config.BaseTest;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
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
        $(byText("Docs page")).shouldBe(visible).exists();
    }
}