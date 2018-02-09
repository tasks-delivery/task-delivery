package selenium.dashboard;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium.config.BaseTest;
import selenium.loginAndRegistration.SignUpPage;
import selenium.project.ProjectPage;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DashboardPageTest extends BaseTest{

    SignUpPage signUpPage;
    ProjectPage projectPage;
    DashboardPage dashboardPage;

    public DashboardPageTest(){
        signUpPage = new SignUpPage(driver);
        projectPage = new ProjectPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @BeforeClass
    public void preconditions(){
        signUpPage.logoutFromSystem();
        signUpPage.createNewUser("testdashboard", "password", "password");
    }

    @Test(description = "Project page for user with invalid auth token should not be visible")
    public void getProjectPageWithInvalidAuthToken(){
        signUpPage.logoutFromSystem();
        open(baseUrl + "dashboard");
        $(dashboardPage.btnCreateProject).shouldNotBe(visible);
        $(dashboardPage.projectsTable).shouldNotBe(visible);
        signUpPage.loginToSystem("testdashboard", "password");
    }

    @Test(description = "Verify navbar elements")
    public void navBarShouldBeVisible(){
        open(baseUrl + "dashboard");
        $(dashboardPage.btnAbout).shouldBe(visible).shouldHave(text("About")).exists();
        $(dashboardPage.btnBlog).shouldBe(visible).shouldHave(text("Blog")).exists();
        $(dashboardPage.btnDocs).shouldBe(visible).shouldHave(text("Docs")).exists();
        $(dashboardPage.btnSignIn).shouldNotBe(visible);
        $(dashboardPage.btnSupport).shouldBe(visible).shouldHave(text("Support")).exists();
        $(dashboardPage.appName).shouldBe(visible);
        $(dashboardPage.btnLogout).shouldBe(visible);
        $(dashboardPage.tdLogo).shouldBe(visible).exists();
    }

    @Test(description = "Footer with link to github should be visible")
    public void footerWithTextAndLinkElementsShouldBeVisible(){
        open(baseUrl + "dashboard");
        $(signUpPage.footer).shouldHave(text(signUpPage.copyrightTaskDelivery2018));
        $(signUpPage.footerLinks).shouldHave(attribute("href", signUpPage.linkToGitHubRepo));
    }

}