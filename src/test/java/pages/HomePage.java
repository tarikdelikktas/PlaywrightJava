package pages;

import base.FrameworkConfig;
import com.microsoft.playwright.Page;

public class HomePage {

    Page page = FrameworkConfig.LocalPage;

    String lnkEmployee = "text='Employee List'";
    String btnCreateNew = "text='Create New'";
    String lnkLogin = "text='Login'";
    String lnkLogOff = "text='Log off'";
    String btnDelete = "input[type=\"submit\"]";

    public LoginPage ClickLogin() {
        page.click(lnkLogin);
        return new LoginPage();
    }

    public void ClickEmployeeList() { page.click(lnkEmployee);}

    public CreateUserPage ClickCreateNew() {
        page.click(btnCreateNew);
        return new CreateUserPage();
    }

    public void ClickLogOff() { page.click(lnkLogOff);}

    public void DeleteCreateUser(String userName) {
        String locator = String.format("//td[normalize-space(.)='%s']/parent::tr//td[normalize-space(.)='Delete']", userName);
        page.click(locator);
        page.click(btnDelete);
    }
}
