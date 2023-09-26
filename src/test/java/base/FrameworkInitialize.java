package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;

public class FrameworkInitialize {

    public Page InitializePlaywright() {
        // Initialize the browser
        BrowserInitialize browserInitialize = new BrowserInitialize();

        // Set the launch Options
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.headless = false;
        launchOptions.devtools = true;

        // Get Browser
        var browser = browserInitialize.GetBrowser("chromium", launchOptions);

        //Get browserContext
        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions();
        contextOptions.locale = "en/US";

        var context = browserInitialize.GetBrowserContext(browser, contextOptions);

        // Get Page
        return browserInitialize.GetPage(context);
    }
}
