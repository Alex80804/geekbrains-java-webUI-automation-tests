package lesson8;

import io.cucumber.java.en.Given;
import lesson7.CustomEventListener;
import lesson8.ApplanaCrm.ApplanaCrmLoginPage;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.addListener;

public class CommonStepsApplana {
    @Given("I am authorized at Applana site")
    public void iAmAuthorizedAtApplanaSite() {
        CustomEventListener.logger = LoggerFactory.getLogger(this.getClass());
        addListener(new CustomEventListener());
        open("https://crm.geekbrains.space/user/login");
        new ApplanaCrmLoginPage()
                .fillLogin("Applanatest1")
                .fillPassword("Student2020!")
                .clickLoginButton();
    }

    @Given("I am at Applana's main page")
    public void iAmAtApplanaSMainPage() {
        open("https://crm.geekbrains.space/");
    }
}
