package uitest.mainPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uitest.config.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class SecondPage extends BasePage {

    SelenideElement btnAddContacts = $(By.className("add-contact"));

    public SecondPage(WebDriver driver) {
        super(driver);
    }
}
