package selenium.project;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium.config.BaseTest;
import selenium.dashboard.DashboardPage;
import selenium.loginAndRegistration.SignUpPage;

import java.awt.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectPageTest extends BaseTest {

    SignUpPage signUpPage;
    ProjectPage projectPage;
    DashboardPage dashboardPage;

    public ProjectPageTest(){
        signUpPage = new SignUpPage(driver);
        projectPage = new ProjectPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @BeforeClass
    public void preconditions() throws AWTException {
        signUpPage.createNewUser("testproject", "password", "password");
    }

    @Test(description = "Project page for user with invalid auth token should not be visible")
    public void getProjectPageWithInvalidAuthToken() throws AWTException {
        signUpPage.logoutFromSystem();
        open(baseUrl + "project");
        $(projectPage.title).shouldNotHave(text("New project"));
        signUpPage.loginToSystem("testproject", "password");
    }

    @Test(description = "Create new project")
    public void createNewProject(){
        open(baseUrl + "dashboard");
        $(dashboardPage.btnCreateProject).click();
        $(projectPage.fieldProjectName).val("testproject");
        $(projectPage.btnSubmitProject).shouldBe(enabled).click();
        $(dashboardPage.projectsTable).shouldHave(text("testproject"));
        $(projectPage.title).shouldNotHave(text("New project"));
    }

    @Test(description = "Verify navbar elements")
    public void navBarShouldBeVisible(){
        open(baseUrl + "project");
        $(signUpPage.btnAbout).shouldBe(visible).shouldHave(text("About")).exists();
        $(signUpPage.btnBlog).shouldBe(visible).shouldHave(text("Blog")).exists();
        $(signUpPage.btnDocs).shouldBe(visible).shouldHave(text("Docs")).exists();
        $(signUpPage.btnSignIn).shouldNotBe(visible);
        $(signUpPage.btnSupport).shouldBe(visible).shouldHave(text("Support")).exists();
        $(signUpPage.appName).shouldBe(visible);
        $(signUpPage.btnLogout).shouldBe(visible);
        $(signUpPage.tdLogo).shouldBe(visible).exists();
    }

    @Test(description = "Footer with link to github should be visible")
    public void footerWithTextAndLinkElementsShouldBeVisible(){
        open(baseUrl + "project");
        $(signUpPage.footer).shouldHave(text(signUpPage.copyrightTaskDelivery2018));
        $(signUpPage.footerLinks).shouldHave(attribute("href", signUpPage.linkToGitHubRepo));
    }

}