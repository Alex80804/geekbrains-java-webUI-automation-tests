package lesson8;

import com.codeborne.selenide.Selenide;
import io.cucumber.junit.Cucumber;
import org.junit.After;
import org.junit.runner.RunWith;

import static lesson8.WithingsHealthmatePagesTest.driver;

@RunWith(Cucumber.class)
public class StepDefinitions {
    @After
    public void after() {
        Selenide.webdriver().driver().clearCookies();
        driver.driver().getWebDriver().quit();
    }
}
