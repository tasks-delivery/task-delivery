package uitest.mainPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uitest.config.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {

    SelenideElement btnContacts = $(By.id("contacts"));

    public MainPage(WebDriver driver) {
        super(driver);
    }
}
