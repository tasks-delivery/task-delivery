package selenium.about;

import org.testng.annotations.Test;
import selenium.config.BaseTest;
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
}