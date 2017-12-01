package uitest.firstPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uitest.config.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class FirstPage extends BasePage {

    SelenideElement btnAddContacts = $(By.className("add-contact"));

    public FirstPage(WebDriver driver) {
        super(driver);
    }
}
