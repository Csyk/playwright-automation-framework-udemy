package org.csyk.browser;

import com.microsoft.playwright.*;

import java.awt.*;

public class BrowserManager {

    public Playwright playwright;
    public Page page;
    public BrowserContext browserContext;
    public Browser browser;

    public void setUp() {
        System.out.println("Setting up playwright...");
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screensize.getWidth();
        int height = (int) screensize.getHeight();

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
        page = browserContext.newPage();
        System.out.println("Playwright setup complete!");
    }

    public void tearDown() {
        System.out.println("Tearing down Playwright...");
        if(page != null) {
            page.close();
        }
        if(browser != null) {
            browser.close();
        }
        if(playwright != null) {
            playwright.close();
        }
        System.out.println("Playwright teardown complete!");
    }
}
