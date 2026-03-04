package step_definitions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.csyk.browser.BrowserManager;

import java.awt.*;

public class HomePage_Steps {
    public BrowserManager browserManager;
    public HomePage_Steps(BrowserManager browserManager) {
        this.browserManager = browserManager;
    }

    @Given("I navigate to the webdriveruniversity homepage")
    public void i_navigate_to_the_webdriveruniversity_homepage() {
        browserManager.page.navigate("https://www.webdriveruniversity.com/");
//        page.navigate("https://tshuservicedesktst.service-now.com");
//        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("User name")).fill("Tesztautomata_robot");
//        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("Ee0&LqGei");
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();
//        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("All")).click();
//        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter search term to filter")).fill("New call");
//        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("New Call 1 of")).click();
//        page.pause();
    }

    @When("I click on the contact us button")
    public void i_click_on_the_contact_us_button() {
        browserManager.page = browserManager.browserContext.waitForPage(() -> {
            browserManager.page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("CONTACT US Contact Us Form")).click();
        });

        browserManager.page.bringToFront();
    }

    @When("I click on login portal button")
    public void i_click_on_the_login_portal_button() {
        browserManager.page = browserManager.browserContext.waitForPage(() -> {
            browserManager.page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("LOGIN PORTAL Login Portal")).click();
        });

        browserManager.page.bringToFront();
    }
}
