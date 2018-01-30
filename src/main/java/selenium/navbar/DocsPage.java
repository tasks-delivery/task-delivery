package selenium.navbar;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.config.BasePage;
import static com.codeborne.selenide.Selenide.$;

public class DocsPage extends BasePage {

    SelenideElement leftColumn = $(By.className("left-column")),
    rightColumn = $(By.className("right-column"));

    public DocsPage(WebDriver driver) {
        super(driver);
    }
}
