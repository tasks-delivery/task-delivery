package selenium.config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public abstract class ConciseAPI  {

    public WebDriver driver;

    String currentDir = System.getProperty("user.dir");

    static{
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "warn");
    }

    @Parameters({"browser", "browserVersion", "headless", "remote", "timeout", "baseUrl"})
    @BeforeClass
    public void setUp(String browsers, String version, Boolean mode, String server, Integer time, String url) {
    System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/windows/geckodriver.exe");
    System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/windows/chromedriver.exe");
    System.setProperty("webdriver.ie.driver", "src/main/resources/drivers/windows/IEDriverServer.exe");
    Configuration.browser = browsers;
    Configuration.browserVersion = version;
    Configuration.headless = mode;
    Configuration.remote = server;
    Configuration.timeout = time;
    Configuration.baseUrl = url;
    }

}
