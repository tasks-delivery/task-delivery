package uitest.config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import static com.codeborne.selenide.Configuration.browser;

public abstract class ConciseAPI {

    public WebDriver driver;
/*
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        System.setProperty("webdriver.ie.driver", "src\\main\\resources\\IEDriverServer.exe");
        Configuration.browser = "chrome";
        Configuration.headless = true;
        Configuration.timeout = 8000;
        Configuration.baseUrl = "http://localhost:8080";
    }
   */

    static{
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "warn");
    }

        @Parameters({"browser", "browserVersion", "remote", "timeout", "baseUrl"})
        @BeforeClass
        public void setUp(String browsers, Boolean mode, String version, String server, Integer time, String url) {
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        System.setProperty("webdriver.ie.driver", "src\\main\\resources\\IEDriverServer.exe");
        browser = browsers;
        Configuration.browserVersion = version;
        Configuration.remote = server;
        Configuration.timeout = time;
        Configuration.baseUrl = url;
        }

}
