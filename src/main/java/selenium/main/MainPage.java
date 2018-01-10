package selenium.main;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.config.BasePage;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {

    SelenideElement infoText = $(By.className("highlights")),
    applicationImg = $(By.xpath("//*[@class='home-banner']//*[@src='/resources/img/error404.png']")),
    reportImg = $(By.xpath("//*[@class='home-banner']//*[@src='/resources/img/report.png']")),
    manageImg = $(By.xpath("//*[@class='home-banner']//*[@src='/resources/img/manage.png']")),
    testCaseImg = $(By.xpath("//*[@class='home-banner']//*[@src='/resources/img/test-case.png']")),
    specImg = $(By.xpath("//*[@class='home-banner']//*[@src='/resources/img/spec.png']")),
    textSpecImg = $(By.xpath("//*[@src='/resources/img/spec.png']/parent::*//*[text()='Combines test specs into test coverage scenarios']")),
    textReportImg = $(By.xpath("//*[@src='/resources/img/report.png']/parent::*//*[text()='Generates progress reports']")),
    textTestCaseImg = $(By.xpath("//*[@src='/resources/img/test-case.png']/parent::*//*[text()='Keeps track of the progress through testing scenarios']")),
    textManageImg = $(By.xpath("//*[@src='/resources/img/manage.png']/parent::*//*[text()='Manage requirements, features and use-cases']"));

    public MainPage(WebDriver driver) {
        super(driver);
    }
}
