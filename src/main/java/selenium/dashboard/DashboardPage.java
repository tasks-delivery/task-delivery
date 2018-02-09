package selenium.dashboard;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.config.BasePage;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage extends BasePage {

    public SelenideElement projectsTable = $(By.xpath("//*[@class='project-list']"));
    public SelenideElement btnCreateProject = $(By.xpath("//*[@class='add-project']"));

    public DashboardPage(WebDriver driver) {
        super(driver);
    }
}
