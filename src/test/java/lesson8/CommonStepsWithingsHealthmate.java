package lesson8;

import io.cucumber.java.en.Given;
import lesson7.CustomEventListener;
import lesson8.WInthingsHealthmate.WithingsHealthmateLoginPage;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverRunner.addListener;

public class CommonStepsWithingsHealthmate {
    @Given("I am authorized at WithingsHealthmate site")
    public void iAmAuthorized() {

        CustomEventListener.logger = LoggerFactory.getLogger(this.getClass());
        addListener(new CustomEventListener());
        webdriver().driver().clearCookies();
        open("https://account.withings.com/connectionwou/account_login?r=https://healthmate.withings.com/");

        new WithingsHealthmateLoginPage()
                .clickCookieOK()
                .fillEmail("xserv32@gmail.com")
                .fillPassword("c0mxy64sS32")
                .clickLoginButton();

    }

    @Given("I am at WithingsHealthmate's main page")
    public void iAmAtTheMainPage() {
        open("https://healthmate.withings.com/timeline");
    }
}
