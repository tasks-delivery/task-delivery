package selenium.organizations;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.config.BasePage;
import static com.codeborne.selenide.Selenide.$;

public class AddOrganizationsPage extends BasePage {

    public String confirmSuccesfully = "Organization succesfully created!";

    SelenideElement fieldEmail = $(By.name("email"));
    SelenideElement fieldPhone = $(By.name("phone"));
    SelenideElement dropdownOrganizationType = $(By.name("organizationTypeId"));
    SelenideElement fieldStreet = $(By.name("street"));
    SelenideElement fieldCity = $(By.name("city"));
    SelenideElement fieldCountry = $(By.name("country"));
    SelenideElement fieldPostalCode = $(By.name("postalCode"));
    SelenideElement fieldNumber = $(By.name("number"));
    SelenideElement fieldProvince = $(By.name("province"));
    SelenideElement btnAdd = $(By.xpath("//*[@type='submit']"));
    SelenideElement fieldOrganizationName = $(By.name("name"));

    public AddOrganizationsPage(WebDriver driver) {
        super(driver);
    }
}
