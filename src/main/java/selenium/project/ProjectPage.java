package selenium.project;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.config.BasePage;
import static com.codeborne.selenide.Selenide.$;

public class ProjectPage extends BasePage {

    SelenideElement title = $(By.xpath("//*[@class='projects-title']")),
    btnSubmitProject = $(By.xpath("//*[@class='project-save']")),
    fieldProjectName = $(By.id("project-name"));

    public ProjectPage(WebDriver driver) {
        super(driver);
    }
}
