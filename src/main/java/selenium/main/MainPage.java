package selenium.main;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.config.BasePage;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {

    SelenideElement btnHowItWork = $(By.xpath("//A[@class='big-button'][text()='How it works']/self::A")),
    btnRegistration = $(By.xpath("//A[@class='big-button'][text()='Registration']/self::A")),
    btnDocs = $(By.xpath("//*[@class='top-bar']//*[text()='Docs']")),
    btnBlog = $(By.xpath("//*[@class='top-bar']//*[text()='Blog']")),
    btnSupport = $(By.xpath("//*[@class='top-bar']//*[text()='Support']")),
    btnAbout = $(By.xpath("//*[@class='top-bar']//*[text()='About']")),
    btnSignIn = $(By.xpath("//*[@class='top-bar']//*[text()='Sign in']")),
    infoText = $(By.className("highlights")),
    tdLogo = $(By.xpath("//*[@class='top-bar']//IMG[@src='images/bomb.png']/self::IMG")),
    applicationPicture = $(By.xpath("//IMG[@src='images/error404.png']/self::IMG")),
    bugPicture = $(By.xpath("//IMG[@src='images/bug.png']/self::IMG")),
    managePicture = $(By.xpath("//IMG[@src='images/manage.png']/self::IMG")),
    scenariosPicture = $(By.xpath("//IMG[@src='images/scenarios.png']/self::IMG")),
    specsPicture = $(By.xpath("//IMG[@src='images/specs.png']/self::IMG"));

    public MainPage(WebDriver driver) {
        super(driver);
    }
}
