package selenium.config;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class BasePage extends ConciseAPI {

    /*
TODO: rework element without public
 */
    public SelenideElement btnSignIn = $(By.xpath("//*[@class='top-bar']//*[text()='Sign up']")),
    btnDocs = $(By.xpath("//*[@class='top-bar']//*[text()='Docs']")),
    btnBlog = $(By.xpath("//*[@class='top-bar']//*[text()='Blog']")),
    btnSupport = $(By.xpath("//*[@class='top-bar']//*[text()='Support']")),
    btnAbout = $(By.xpath("//*[@class='top-bar']//*[text()='About']"));

    public WebDriver driver(){
        return driver;
    }

    public  BasePage(WebDriver driver){
        this.driver = driver;
    }

}
