package selenium.support;

import org.testng.annotations.Test;
import selenium.config.BaseTest;
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

}