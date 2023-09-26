package pages;

import base.FrameworkConfig;
import com.microsoft.playwright.Page;

public class LoginPage {

    Page page = FrameworkConfig.LocalPage;

    String txtUserName = "#UserName";
    String txtPassword = "#Password";
    String btnLogin = "input:type('Log in')";

    public HomePage Login(String userName, String password) {
        page.fill(txtUserName, userName);
        page.fill(txtPassword, password);
        page.click(btnLogin);
        return new HomePage();
    }
}
