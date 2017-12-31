package uitest.contacts;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uitest.config.BaseTest;
import uitest.mainPage.MainPage;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AddContactsPageTest extends BaseTest {

    AddContactsPage addContactsPage;
    ContactsListPage contactsListPage;
    MainPage mainPage;

    public AddContactsPageTest(){
        mainPage = new MainPage(driver);
        contactsListPage = new ContactsListPage(driver);
        addContactsPage = new AddContactsPage(driver);
    }

    @BeforeMethod
    public void preconditions(){
        open(baseUrl);
        $(mainPage.btnContacts).click();
        $(contactsListPage.btnAddContact).click();
    }

    @Test(description = "Verify that first name is shown in list of uitest.contacts")
    public void addNewContactWithFirstName(){
        $(addContactsPage.fieldFirstName).val("testFirstName");
        $(addContactsPage.btnAdd).click();
        Selenide.confirm(addContactsPage.confirmSuccesfully);
        $(contactsListPage.h3Title).shouldHave(text(contactsListPage.contactTitle));
        $(byText("testFirstName")).shouldBe(visible);
    }

    @Test(description = "Verify that last name is shown in list of uitest.contacts")
    public void addNewContactWithLastName(){
        $(addContactsPage.fieldLastName).val("testLastName");
        $(addContactsPage.btnAdd).click();
        Selenide.confirm(addContactsPage.confirmSuccesfully);
        $(contactsListPage.h3Title).shouldHave(text(contactsListPage.contactTitle));
        $(byText("testLastName")).shouldBe(visible);
    }

    @Test(description = "Verify that email isn't shown")
    public void addNewContactWithEmail(){
        $(addContactsPage.fieldEmail).val("test@mail.ru");
        $(addContactsPage.btnAdd).click();
        Selenide.confirm(addContactsPage.confirmSuccesfully);
        $(contactsListPage.h3Title).shouldHave(text(contactsListPage.contactTitle));
        $(byText("test@mail.ru")).shouldNotBe(visible);
    }

    @Test(description = "Verify that phone isn't shown")
    public void addNewContactWithPhone(){
        $(addContactsPage.fieldPhone).val("+123456");
        $(addContactsPage.btnAdd).click();
        Selenide.confirm(addContactsPage.confirmSuccesfully);
        $(contactsListPage.h3Title).shouldHave(text(contactsListPage.contactTitle));
        $(byText("+123456")).shouldNotBe(visible);;
    }

    @Test(description = "Verify that street isn't shown")
    public void addNewContactWithStreet(){
        $(addContactsPage.fieldStreet).val("testStreet");
        $(addContactsPage.btnAdd).click();
        Selenide.confirm(addContactsPage.confirmSuccesfully);
        $(contactsListPage.h3Title).shouldHave(text(contactsListPage.contactTitle));
        $(byText("testStreet")).shouldNotBe(visible);
    }

    @Test(description = "Verify that number isn't shown")
    public void addNewContactWitNumber(){
        $(addContactsPage.fieldNumber).val("123456");
        $(addContactsPage.btnAdd).click();
        Selenide.confirm("Contact succesfully created!");
        $(contactsListPage.h3Title).shouldHave(text(contactsListPage.contactTitle));
        $(byText("123456")).shouldNotBe(visible);
    }

    @Test(description = "Verify that postalCode isn't shown")
    public void addNewContactWithPostalCode(){
        $(addContactsPage.fieldPostalCode).val("123456");
        $(addContactsPage.btnAdd).click();
        Selenide.confirm(addContactsPage.confirmSuccesfully);
        $(contactsListPage.h3Title).shouldHave(text(contactsListPage.contactTitle));
        $(byText("123456")).shouldNotBe(visible);
    }

    @Test(description = "Verify that country isn't shown")
    public void addNewContactWithCountry(){
        $(addContactsPage.fieldCountry).val("testCountry");
        $(addContactsPage.btnAdd).click();
        Selenide.confirm(addContactsPage.confirmSuccesfully);
        $(contactsListPage.h3Title).shouldHave(text(contactsListPage.contactTitle));
        $(byText("testCountry")).shouldNotBe(visible);
    }

    @Test(description = "Verify that city isn't shown")
    public void addNewContactWithCity(){
        $(addContactsPage.fieldCity).val("testCity");
        $(addContactsPage.btnAdd).click();
        Selenide.confirm(addContactsPage.confirmSuccesfully);
        $(contactsListPage.h3Title).shouldHave(text(contactsListPage.contactTitle));
        $(byText("testCity")).shouldNotBe(visible);
    }

    @Test(description = "Verify that province isn't shown")
    public void addNewContactWithProvince(){
        $(addContactsPage.fieldProvince).val("testProvince");
        $(addContactsPage.btnAdd).click();
        Selenide.confirm(addContactsPage.confirmSuccesfully);
        $(contactsListPage.h3Title).shouldHave(text(contactsListPage.contactTitle));
        $(byText("testProvince")).shouldNotBe(visible);
    }

    @Test(description = "Verify that only first name and last name of contact are shown in uitest.contacts list")
    public void addNewContactWithAllData(){
        $(addContactsPage.fieldFirstName).val("testAllDataFirstName");
        $(addContactsPage.fieldLastName).val("testAllDataLasttName");
        $(addContactsPage.fieldEmail).val("testalldataemail@mail.ru");
        $(addContactsPage.fieldPhone).val("++123456");
        $(addContactsPage.fieldNumber).val("1234567");
        $(addContactsPage.fieldStreet).val("testAllDataStreet");
        $(addContactsPage.fieldProvince).val("testAllDataProvince");
        $(addContactsPage.fieldCity).val("testAllDataCity");
        $(addContactsPage.fieldPostalCode).val("1234567");
        $(addContactsPage.fieldCountry).val("testAllDataCountry");
        $(addContactsPage.btnAdd).click();
        Selenide.confirm(addContactsPage.confirmSuccesfully);
        $(contactsListPage.h3Title).shouldHave(text(contactsListPage.contactTitle));
        $(byText("testAllDataFirstName testAllDataLasttName")).shouldBe(visible);
        $(byText("++123456")).shouldNotBe(visible);
        $(byText("testalldataemail@mail.ru")).shouldNotBe(visible);
        $(byText("1234567")).shouldNotBe(visible);
        $(byText("testAllDataStreet")).shouldNotBe(visible);
        $(byText("testAllDataProvince")).shouldNotBe(visible);
        $(byText("testAllDataCity")).shouldNotBe(visible);
        $(byText("1234567")).shouldNotBe(visible);
        $(byText("testAllDataCountry")).shouldNotBe(visible);
    }

}