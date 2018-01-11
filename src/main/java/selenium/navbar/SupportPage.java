package selenium.navbar;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.config.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class SupportPage extends BasePage {

    SelenideElement supportInfo = $(By.className("support-list"));

    public SupportPage(WebDriver driver) {
        super(driver);
    }
}
