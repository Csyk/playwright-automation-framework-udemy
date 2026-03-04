package step_definitions.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.csyk.browser.BrowserManager;

public class Hooks {
    private final BrowserManager browserManager;

    public Hooks(BrowserManager browserManager) {
        this.browserManager = browserManager;
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("\nExecuting test suite...");
    }

    @AfterAll
    public static void  afterAll() {
        System.out.println("\nFinished executing the test suite!");
    }

    @Before
    public void setup() {
        browserManager.setUp();
    }

    @After
    public void tearDown() {
        browserManager.tearDown();
    }
}
