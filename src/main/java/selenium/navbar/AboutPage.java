package selenium.navbar;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.config.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class AboutPage extends BasePage {

    SelenideElement aboutInfo = $(By.className("about-list"));

    public AboutPage(WebDriver driver) {
        super(driver);
    }
}
