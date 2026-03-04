package step_definitions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.datafaker.Faker;
import org.csyk.browser.BrowserManager;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertTrue;

public class ContactUs_Steps {
    public BrowserManager browserManager;
    private final Faker faker = new Faker();

    public ContactUs_Steps(BrowserManager browserManager) {
        this.browserManager = browserManager;
    }

    @And("I type a first name")
    public void i_type_a_first_name() {
        browserManager.page.getByPlaceholder("First Name").fill("Joe");
    }

    @And("I type a last name")
    public void i_type_a_last_name() {
        browserManager.page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name")).fill("Blogs");
    }

    @And("I enter an email address")
    public void i_enter_an_email_address() {
        browserManager.page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Address")).fill("joe_blogs@example.hu");
    }

    @And("I type a comment")
    public void i_type_a_comment() {
        browserManager.page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Comments")).fill("Hello World!");
    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        Page.WaitForSelectorOptions options = new Page.WaitForSelectorOptions().setTimeout(10000);
        browserManager.page.waitForSelector("input[value='SUBMIT']", options);
        browserManager.page.click("input[value='SUBMIT']");
    }


    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        //#contact_reply h1
        browserManager.page.waitForSelector("#contact_reply h1", new Page.WaitForSelectorOptions().setTimeout(10000));

        Locator locator = browserManager.page.locator("#contact_reply h1");
        assertThat(locator).isVisible();
        assertThat(locator).hasText("Thank You for your Message!");
    }

    @Then("I should be presented with a unsuccessful contact us submission message")
    public void i_should_be_presented_with_a_unsuccessful_contact_us_submission_message() {
        browserManager.page.waitForSelector("body");
        Locator bodyElement = browserManager.page.locator("body");
        String bodyText = bodyElement.textContent();
        Pattern pattern = Pattern.compile("Error: (all fields are required|Invalid email address)");
        Matcher matcher = pattern.matcher(bodyText);
        assertTrue(matcher.find(), "The body text does not match the expected error message. Found Text: " + bodyText);
    }

    @And("I type a specific first name {string}")
    public void i_type_a_specific_first_name(String firstName) {
        browserManager.page.getByPlaceholder("First Name").fill(firstName);
    }

    @And("I type a specific last name {string}")
    public void i_type_a_specific_last_name(String lastName) {
        browserManager.page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name")).fill(lastName);
    }

    @And("I enter a specific email address {string}")
    public void i_enter_a_specific_email_address(String emailAddress) {
        browserManager.page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Address")).fill(emailAddress);
    }

    @And("I type specific text {string} and I number {int} within the comment input field")
    public void i_type_specific_text_and_i_number_within_the_comment_input_field(String word, Integer number) {
        browserManager.page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Comments")).fill(word + " " + number);
    }

    @And("I type a random first name")
    public void i_type_a_random_first_name() {
        String randomFirstName = faker.name().firstName();
        browserManager.page.getByPlaceholder("First Name").fill(randomFirstName);
    }
    @And("I type a random last name")
    public void i_type_a_random_last_name() {
        String randomLastName = faker.name().lastName();
        browserManager.page.getByPlaceholder("Last Name").fill(randomLastName);
    }
    @And("I enter a random email address")
    public void i_enter_a_random_email_address() {
        String randomEmail = faker.internet().emailAddress();
        browserManager.page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Address")).fill(randomEmail);
    }

    @And("I type a first name {word} and a last name {word}")
    public void i_type_a_first_name_john_and_a_last_name_jones(String firstName, String lastName) {
        browserManager.page.getByPlaceholder("First Name").fill(firstName);
        browserManager.page.getByPlaceholder("Last Name").fill(lastName);

    }
    @And("I type an email address {string} and a comment {string}")
    public void i_type_an_email_address_and_a_comment(String email, String comment) {
        browserManager.page.getByPlaceholder("Email Address").fill(email);
        browserManager.page.getByPlaceholder("Comments").fill(comment);
    }
    @Then("I should be presented with a header text {string}")
    public void i_should_be_presented_with_a_header_text(String expectedMessage) {
        browserManager.page.waitForSelector("//h1 | //body");

        List<String> texts = browserManager.page.locator("//h1 | //body").allInnerTexts();
        String foundText = "";
        boolean found = false;
        for (String text : texts) {
            if(text.contains(expectedMessage)) {
                foundText = text;
                found = true;
            } else {
                foundText = text;
            }
        }
        assertTrue(found, "The element does not contain the expected message. Expected message: " + foundText
        + ", to be equal to: " + expectedMessage);
    }
}
