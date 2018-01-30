package selenium.navbar;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.config.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class BlogPage extends BasePage {

    SelenideElement blogInfo = $(By.className("blog-list"));

    public BlogPage(WebDriver driver) {
        super(driver);
    }
}
