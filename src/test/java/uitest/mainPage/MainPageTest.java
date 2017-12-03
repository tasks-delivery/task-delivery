package uitest.mainPage;

import org.testng.annotations.Test;
import uitest.config.BaseTest;
import uitest.contacts.ContactsListPage;
import uitest.organizations.OrganizationsListPage;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTest extends BaseTest {

    MainPage mainPage;
    ContactsListPage contactsListPage;
    OrganizationsListPage organizationsListPage;

    public MainPageTest(){
        organizationsListPage = new OrganizationsListPage(driver);
        mainPage = new MainPage(driver);
        contactsListPage = new ContactsListPage(driver);
    }

    @Test
    public void firstTest(){
        open(baseUrl);
        $(mainPage.btnContacts).click();
        $(contactsListPage.btnAddContact).shouldBe(visible);
        $(organizationsListPage.btnAddOrganization).shouldBe(visible);
    }

}