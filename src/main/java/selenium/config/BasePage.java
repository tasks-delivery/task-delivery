package selenium.config;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class BasePage extends ConciseAPI {

    /*
TODO: rework elements without public
 */
    public SelenideElement btnSignIn = $(By.xpath("//*[@class='top-bar']//*[text()='Sign up']")),
    btnDocs = $(By.xpath("//*[@class='top-bar']//*[text()='Docs']")),
    btnBlog = $(By.xpath("//*[@class='top-bar']//*[text()='Blog']")),
    btnSupport = $(By.xpath("//*[@class='top-bar']//*[text()='Support']")),
    btnAbout = $(By.xpath("//*[@class='top-bar']//*[text()='About']")),
    tdLogo = $(By.xpath("//*[@class='top-bar']//IMG[@src='/resources/img/bomb.png']/self::IMG")),
    appName = $(By.xpath("//*[@class='top-bar']//SPAN[text()='Task-delivery']/self::SPAN"));

    public WebDriver driver(){
        return driver;
    }

    public  BasePage(WebDriver driver){
        this.driver = driver;
    }

}
