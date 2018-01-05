package selenium.loginAndRegistration;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.config.BasePage;
import static com.codeborne.selenide.Selenide.$;

public class LoginModalWindow extends BasePage {

    SelenideElement regModalWindow = $(By.xpath("//*[@class='reg']")),
    fieldUsername = $(By.name("username")),
    fieldPassword = $(By.name("password")),
    btnLogin = $(By.xpath("//BUTTON[text()='Log In']/self::BUTTON")),
    linkCreateAcc = $(By.xpath("//A[@href='/registration'][text()='Create an account']/self::A")),
    usernamePlaceholder = $(By.xpath("//INPUT[@placeholder='Username']/self::INPUT")),
    passwordPlaceholder = $(By.xpath("//INPUT[@placeholder='Password']/self::INPUT"));

    public LoginModalWindow(WebDriver driver) {
        super(driver);
    }
}
