package pages;

import base.FrameworkConfig;
import com.microsoft.playwright.Page;

public class CreateUserPage {

    Page page = FrameworkConfig.LocalPage;

    String txtName = "input[name=\"Name\"]";

    String txtSalary = "input[name=\"Salary\"]";

    String txtDuration = "input[name=\"Duration\"]";

    String txtGrade = "input[name=\"Grade\"]";

    String txtEmail = "input[name=\"Email\"]";

    String btnCreate = "input[name=\"submit\"]";

    public HomePage CreateUser(String name, String salary, String duration, String grade, String email) {
        page.fill(txtName, name);
        page.fill(txtSalary, salary);
        page.fill(txtDuration, duration);
        page.fill(txtGrade, grade);
        page.fill(txtEmail, email);

        page.click(btnCreate);
        return new HomePage();
    }
}
