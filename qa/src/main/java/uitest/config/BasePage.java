package uitest.config;

import org.openqa.selenium.WebDriver;

public class BasePage extends ConciseAPI {

    public WebDriver driver(){
        return driver;
    }

    public  BasePage(WebDriver driver){
        this.driver = driver;
    }

}
