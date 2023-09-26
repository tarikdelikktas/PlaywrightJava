import base.FrameworkInitialize;
import org.testng.annotations.BeforeTest;
import base.FrameworkConfig;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class FirstTest {
    @BeforeTest
    public void setupPlaywright() {
        FrameworkConfig.LocalPage = new FrameworkInitialize().InitializePlaywright();
    }

    @Test
    public void testNavigation() {
        FrameworkConfig.LocalPage.navigate("https://amazon.com/");
    }

    @Test
    public void testLogin() {
        FrameworkConfig.LocalPage.navigate("http://eaapp.somee.com/");
        HomePage homePage = new HomePage();
        var loginPage = homePage.ClickLogin();
        homePage = loginPage.Login("username", "password");
        homePage.ClickEmployeeList();
    }
}
