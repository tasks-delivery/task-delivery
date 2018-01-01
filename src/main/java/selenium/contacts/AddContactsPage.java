package selenium.contacts;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.config.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class AddContactsPage extends BasePage {

    public String confirmSuccesfully = "Contact succesfully created!";

    SelenideElement fieldFirstName = $(By.name("firstName"));
    SelenideElement fieldLastName = $(By.name("lastName"));
    SelenideElement fieldEmail = $(By.name("email"));
    SelenideElement fieldPhone = $(By.name("phone"));
    SelenideElement dropdownOrganization = $(By.name("organizationId"));
    SelenideElement fieldStreet = $(By.name("street"));
    SelenideElement fieldCity = $(By.name("city"));
    SelenideElement fieldCountry = $(By.name("country"));
    SelenideElement fieldPostalCode = $(By.name("postalCode"));
    SelenideElement fieldNumber = $(By.name("number"));
    SelenideElement fieldProvince = $(By.name("province"));
    SelenideElement btnAdd = $(By.xpath("//*[@type='submit']"));

    public AddContactsPage(WebDriver driver) {
        super(driver);
    }
}
