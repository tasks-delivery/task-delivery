package selenium.organizations;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.config.BaseTest;
import selenium.mainPage.MainPage;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AddOrganizationsPageTest extends BaseTest {

    AddOrganizationsPage addOrganizationsPage;
    OrganizationsListPage organizationsListPage;
    MainPage mainPage;

    public AddOrganizationsPageTest(){
        addOrganizationsPage = new AddOrganizationsPage(driver);
        organizationsListPage = new OrganizationsListPage(driver);
        mainPage = new MainPage(driver);
    }

    @BeforeMethod
    public void preconditions(){
        open(baseUrl);
        $(mainPage.btnOrganization).click();
        $(organizationsListPage.btnAddOrganizations).click();
    }

    @Test(description = "Verify that organization name is shown in list of uitest.organizations")
    public void addNewContactWithFirstName(){
        $(addOrganizationsPage.fieldOrganizationName).val("testOrgName");
        $(addOrganizationsPage.btnAdd).click();
        Selenide.confirm(addOrganizationsPage.confirmSuccesfully);
        $(organizationsListPage.h3Title).shouldHave(text(organizationsListPage.organizationTitle));
        $(byText("testOrgName")).shouldBe(visible);
    }

    @Test(description = "Verify that email isn't shown")
    public void addNewContactWithEmail(){
        $(addOrganizationsPage.fieldEmail).val("testorg@mail.ru");
        $(addOrganizationsPage.btnAdd).click();
        Selenide.confirm(addOrganizationsPage.confirmSuccesfully);
        $(organizationsListPage.h3Title).shouldHave(text(organizationsListPage.organizationTitle));
        $(byText("testorg@mail.ru")).shouldNotBe(visible);
    }

    @Test(description = "Verify that phone isn't shown")
    public void addNewContactWithPhone(){
        $(addOrganizationsPage.fieldPhone).val("+123456");
        $(addOrganizationsPage.btnAdd).click();
        Selenide.confirm(addOrganizationsPage.confirmSuccesfully);
        $(organizationsListPage.h3Title).shouldHave(text(organizationsListPage.organizationTitle));
        $(byText("+123456")).shouldNotBe(visible);;
    }

    @Test(description = "Verify that street isn't shown")
    public void addNewContactWithStreet(){
        $(addOrganizationsPage.fieldStreet).val("testOrgStreet");
        $(addOrganizationsPage.btnAdd).click();
        Selenide.confirm(addOrganizationsPage.confirmSuccesfully);
        $(organizationsListPage.h3Title).shouldHave(text(organizationsListPage.organizationTitle));
        $(byText("testOrgStreet")).shouldNotBe(visible);
    }

    @Test(description = "Verify that number isn't shown")
    public void addNewContactWitNumber(){
        $(addOrganizationsPage.fieldNumber).val("123456");
        $(addOrganizationsPage.btnAdd).click();
        Selenide.confirm(addOrganizationsPage.confirmSuccesfully);
        $(organizationsListPage.h3Title).shouldHave(text(organizationsListPage.organizationTitle));
        $(byText("123456")).shouldNotBe(visible);
    }

    @Test(description = "Verify that postalCode isn't shown")
    public void addNewContactWithPostalCode(){
        $(addOrganizationsPage.fieldPostalCode).val("123456");
        $(addOrganizationsPage.btnAdd).click();
        Selenide.confirm(addOrganizationsPage.confirmSuccesfully);
        $(organizationsListPage.h3Title).shouldHave(text(organizationsListPage.organizationTitle));
        $(byText("123456")).shouldNotBe(visible);
    }

    @Test(description = "Verify that country isn't shown")
    public void addNewContactWithCountry(){
        $(addOrganizationsPage.fieldCountry).val("testOrgCountry");
        $(addOrganizationsPage.btnAdd).click();
        Selenide.confirm(addOrganizationsPage.confirmSuccesfully);
        $(organizationsListPage.h3Title).shouldHave(text(organizationsListPage.organizationTitle));
        $(byText("testOrgCountry")).shouldNotBe(visible);
    }

    @Test(description = "Verify that city isn't shown without first name or last name")
    public void addNewContactWithCity(){
        $(addOrganizationsPage.fieldCity).val("testOrgCity");
        $(addOrganizationsPage.btnAdd).click();
        Selenide.confirm(addOrganizationsPage.confirmSuccesfully);
        $(organizationsListPage.h3Title).shouldHave(text(organizationsListPage.organizationTitle));
        $(byText("testOrgCity")).shouldNotBe(visible);
    }

    @Test(description = "Verify that province isn't shown without first name or last name")
    public void addNewContactWithProvince(){
        $(addOrganizationsPage.fieldProvince).val("testOrgProvince");
        $(addOrganizationsPage.btnAdd).click();
        Selenide.confirm(addOrganizationsPage.confirmSuccesfully);
        $(organizationsListPage.h3Title).shouldHave(text(organizationsListPage.organizationTitle));
        $(byText("testOrgProvince")).shouldNotBe(visible);
    }

    @Test(description = "Verify that only first name and last name of contact are shown in uitest.contacts list")
    public void addNewContactWithAllData(){
        $(addOrganizationsPage.fieldOrganizationName).val("testAllDataOrgName");
        $(addOrganizationsPage.fieldEmail).val("testalldataorgemail@mail.ru");
        $(addOrganizationsPage.fieldPhone).val("++123456");
        $(addOrganizationsPage.fieldNumber).val("1234567");
        $(addOrganizationsPage.fieldStreet).val("testAllDataOrgStreet");
        $(addOrganizationsPage.fieldProvince).val("testAllDataOrgProvince");
        $(addOrganizationsPage.fieldCity).val("testAllDataOrgCity");
        $(addOrganizationsPage.fieldPostalCode).val("1234567");
        $(addOrganizationsPage.fieldCountry).val("testAllDataOrgCountry");
        $(addOrganizationsPage.btnAdd).click();
        Selenide.confirm(addOrganizationsPage.confirmSuccesfully);
        $(organizationsListPage.h3Title).shouldHave(text(organizationsListPage.organizationTitle));
        $(byText("testAllDataOrgName")).shouldBe(visible);
        $(byText("++123456")).shouldNotBe(visible);
        $(byText("testalldataorgemail@mail.ru")).shouldNotBe(visible);
        $(byText("1234567")).shouldNotBe(visible);
        $(byText("testAllDataOrgStreet")).shouldNotBe(visible);
        $(byText("testAllDataOrgProvince")).shouldNotBe(visible);
        $(byText("testAllDataOrgCity")).shouldNotBe(visible);
        $(byText("1234567")).shouldNotBe(visible);
        $(byText("testAllDataOrgCountry")).shouldNotBe(visible);
    }

}