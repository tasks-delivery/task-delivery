package selenium.config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public abstract class ConciseAPI  {

    public WebDriver driver;

    static{
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "warn");
    }

    String currentDir = System.getProperty("user.dir");

    @Parameters({"browser", "browserVersion", "headless", "remote", "timeout", "baseUrl"})
    @BeforeClass
    public void setUp(String browsers, String version, Boolean mode, String server, Integer time, String url) {
    System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/windows/geckodriver.exe");
    System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/windows/chromedriver.exe");
    System.setProperty("webdriver.ie.driver", "src/main/resources/drivers/windows/IEDriverServer.exe");
    Configuration.browser = browsers;
    Configuration.browserVersion = version;
<<<<<<< HEAD
    Configuration.headless = mode;
=======
 //   Configuration.headless = mode;
>>>>>>> 6e455b12c35d8a29ddf7e94511b0bdf8d05170c5
    Configuration.remote = server;
    Configuration.timeout = time;
    Configuration.baseUrl = url;
    }

}
