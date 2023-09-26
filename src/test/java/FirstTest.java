import base.FrameworkInitialize;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import base.FrameworkConfig;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.awt.*;

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
    public void testCreateUser() {
        FrameworkConfig.LocalPage.navigate("http://eaapp.somee.com/");
        HomePage homePage = new HomePage();
        var loginPage = homePage.ClickLogin();
        homePage = loginPage.Login("username", "password");
        homePage.ClickEmployeeList();

        //Create New User
        var createUserPage = homePage.ClickCreateNew();
        homePage = createUserPage.CreateUser("Tarik Deliktas", "15000", "40", "10", "senioraitomation@engineer.com");

        //Delete User
        homePage.DeleteCreateUser("Tarik Deliktas");

        //Log off
        homePage.ClickLogOff();
    }

    @AfterTest
    public void cleanUp() throws Exception {
        FrameworkConfig.LocalPage.click();
        FrameworkConfig.Playwright.close();
        FrameworkConfig.Browser.close();
    }
}
