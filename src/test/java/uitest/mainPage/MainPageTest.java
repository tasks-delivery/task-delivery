package uitest.mainPage;

import org.testng.annotations.Test;
import uitest.config.BaseTest;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTest extends BaseTest {

    MainPage mainPage;
    SecondPage secondPage;

    public MainPageTest(){
        mainPage = new MainPage(driver);
        secondPage = new SecondPage(driver);
    }

    @Test
    public void firstTest(){
        open(baseUrl);
        $(mainPage.btnContacts).click();
        $(secondPage.btnAddContacts).shouldNotBe(visible);

    }

}