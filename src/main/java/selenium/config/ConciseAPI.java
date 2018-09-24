package selenium.config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class ConciseAPI  {

    public WebDriver driver;

    @Parameters({"browser", "browserVersion", "headless", "remote", "timeout", "baseUrl"})
    @BeforeClass
    public void setUp(String browsers, String version, Boolean mode, String server, Integer time, String url) {
    Configuration.browser = browsers;
    Configuration.browserVersion = version;
    Configuration.headless = mode;
    Configuration.remote = server;
    Configuration.timeout = time;
    Configuration.baseUrl = url;
    }

}
