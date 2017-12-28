package uitest.organizations;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uitest.config.BasePage;
import static com.codeborne.selenide.Selenide.$;

public class OrganizationsListPage extends BasePage {

    public String organizationTitle = "Organizations";

    public SelenideElement btnAddOrganizations = $(By.className("add-organization"));
    SelenideElement h3Title = $(By.xpath("//h3"));

    public OrganizationsListPage(WebDriver driver) {
        super(driver);
    }
}
