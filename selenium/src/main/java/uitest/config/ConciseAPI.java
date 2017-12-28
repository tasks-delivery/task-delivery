package uitest.config;

import com.codeborne.selenide.Configuration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import static com.codeborne.selenide.Configuration.browser;

public abstract class ConciseAPI  {

    public WebDriver driver;
    /*
        static{
            System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
            System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "warn");
            String hubAddress = (System.getProperty("hubAddress") == null) ? "http://0.0.0.0:4444/wd/hub" : System.getProperty("hubAddress");

        }

        @BeforeSuite
        public void deployTestApp(){
            SpringApplication.run(SimpleCrmApplication.class);
        }
    */
        @Parameters({"browser", "browserVersion", "remote", "headless", "timeout", "baseUrl"})
        @BeforeClass
        public void setUp(String browsers, String version, String server, Boolean mode, Integer time, String url) {
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\winDrivers\\chromedriver.exe");
        System.setProperty("webdriver.ie.driver", "src\\main\\resources\\IEDriverServer.exe");
        browser = browsers;
        Configuration.browserVersion = version;
        Configuration.remote = server;
        Configuration.headless = mode;
        Configuration.timeout = time;
        Configuration.baseUrl = url;
        }


}
