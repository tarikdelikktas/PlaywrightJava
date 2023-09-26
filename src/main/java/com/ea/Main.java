package com.ea;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Geolocation;

public class Main {

    public static void main(String[] args) throws Exception {
        // Navigation();
        NetworkInterception();
;    }
    private static void Navigation(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.firefox();

            BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
            launchOptions.devtools = true;
            launchOptions.headless = false;

            Browser browser = browserType.launch(launchOptions);

            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
            .setViewportSize(2560, 1440)
            .setDeviceScaleFactor(2)
            .setLocale("us-US")
            .setTimezoneId("America/Los_Angeles"));

            Page page = context.newPage();
            page.navigate("http://www.todomvc.com/");
            Object dimensions = page.evaluate("() => {\n" +
                    "  return {\n" +
                    "      width: document.documentElement.clientWidth,\n" +
                    "      height: document.documentElement.clientHeight,\n" +
                    "      deviceScaleFactor: window.devicePixelRatio\n" +
                    "  }\n" +
                    "}");
            System.out.println(dimensions);
        }
    }

    public static void NetworkInterception() throws Exception {
        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.devtools = true;
        launchOptions.headless = false;

        Browser browser = browserType.launch(launchOptions);
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.route("xx/x", route -> {
            if(route.request().resourceType().equalsIgnoreCase("image"))
                route.abort();
            else
                route.resume();
        });

    }
}