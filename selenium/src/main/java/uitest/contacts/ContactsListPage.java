package uitest.contacts;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uitest.config.BasePage;
import static com.codeborne.selenide.Selenide.$;

public class ContactsListPage extends BasePage {

    public String contactTitle = "Contacts";

    public SelenideElement btnAddContact = $(By.className("add-contact"));
    SelenideElement h3Title = $(By.xpath("//h3"));

    public ContactsListPage(WebDriver driver) {
        super(driver);
    }
}
