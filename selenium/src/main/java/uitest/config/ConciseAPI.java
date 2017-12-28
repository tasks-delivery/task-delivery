package uitest.config;

import com.codeborne.selenide.Configuration;
import com.tloureiro.SimpleCrmApplication;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public abstract class ConciseAPI  {

    public WebDriver driver;

        @BeforeSuite
        public void deployTestApp(){
            SpringApplication.run(SimpleCrmApplication.class);
        }

        @Parameters({"browser", "browserVersion", "remote", "headless", "timeout", "baseUrl"})
        @BeforeClass
        public void setUp(String browsers, String version, String server, Boolean mode, Integer time, String url) {
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\winDrivers\\chromedriver.exe");
        System.setProperty("webdriver.ie.driver", "src\\main\\resources\\IEDriverServer.exe");
            Configuration.browser = browsers;
        Configuration.browserVersion = version;
        Configuration.remote = server;
        Configuration.headless = mode;
        Configuration.timeout = time;
        Configuration.baseUrl = url;
        }


}
