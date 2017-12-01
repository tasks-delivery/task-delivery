package uitest.config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public abstract class ConciseAPI {

    public WebDriver driver;

 //   public String baseUrl = "http://localhost:8080";
/*
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        System.setProperty("webdriver.ie.driver", "src\\main\\resources\\IEDriverServer.exe");
        Configuration.browser = "marionette";
        Configuration.timeout = 8000;
    //    Configuration.baseUrl = "http://localhost:8080";
    }
    */
        @Parameters({"browser", "browserVersion", "remote", "timeout", "baseUrl"})
        @BeforeClass
        public void setUp(String browsers, String version, String server, Integer time, String url) {
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        System.setProperty("webdriver.ie.driver", "src\\main\\resources\\IEDriverServer.exe");
        Configuration.browser = browsers;
        Configuration.browserVersion = version;
        Configuration.remote = server;
        Configuration.timeout = time;
        Configuration.baseUrl = url;
        }



}
