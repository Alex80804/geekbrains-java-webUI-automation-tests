package lesson8;

import com.codeborne.selenide.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import lesson7.CustomEventListener;
import lesson8.WInthingsHealthmate.WithingsHealthmateLoginPage;
import lesson8.WInthingsHealthmate.WithingsHealthmateTimelinePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Story("Тестирование страниц Withings Healthmate")
public class WithingsHealthmatePagesTest {

    public static Conditional driver;

    private void userAuthentication() {
        CustomEventListener.logger = LoggerFactory.getLogger(this.getClass());
        addListener(new CustomEventListener());
        open("https://account.withings.com/connectionwou/account_login?r=https://healthmate.withings.com/");

        new WithingsHealthmateLoginPage()
                .clickCookieOK()
                .fillEmail("xserv32@gmail.com")
                .fillPassword("c0mxy64sS32")
                .clickLoginButton();
    }

    @BeforeAll
    static void driverSetup() {
        driver = Selenide.webdriver();
    }

    @Description("Тест страницы логина")
    @Test
    void LoginPageTest() throws InterruptedException {
        String assertElementXpath = "//div[@class='user']";
        userAuthentication();

        assertTrue($(By.xpath(assertElementXpath))
                .shouldBe(Condition.visible, Duration.ofSeconds(30)).isDisplayed());
    }

    @Description("Тест логаута")
    @Test
    void LogoutTest() throws InterruptedException {
        userAuthentication();
        open("https://healthmate.withings.com/timeline");
        Cookie sessionCookie = driver.driver().getWebDriver().manage().getCookieNamed("session_key");
        new WithingsHealthmateTimelinePage()
                .clickUserIcon()
                .clickLogoutMenuItem();

        $(By.xpath("//button[text()='Вход']")).shouldBe(Condition.visible, Duration.ofSeconds(30));
        Assertions.assertNull(driver.driver().getWebDriver().manage().getCookieNamed("session_key"));
    }

    @Description("Тест добавления температуры")
    @Test
    void addTemperatureTest() throws InterruptedException {
        String tempToAdd = "36.3";

        userAuthentication();
        open("https://healthmate.withings.com/timeline");

        new WithingsHealthmateTimelinePage()
                .clickAddMeasurementIcon()
                .clickAddTemperatureIcon()
                .inputTemperature(tempToAdd)
                .saveTemperature();

        $(By.xpath("//div[contains(text(), '°C')]")).shouldBe(Condition.visible, Duration.ofSeconds(30));
        List<SelenideElement> temps = $$(By.xpath("//div[contains(text(), '°C')]"));
        CustomEventListener.logger.info("TEMP - " + temps.get(0).getText());
        Assertions.assertEquals(tempToAdd + " °C", temps.get(0).getText());
    }

    @Description("Тест переключения heatmap в ежедневный режим")
    @Test
    void switchDashToDailyModeTest() {

        userAuthentication();

        open("https://healthmate.withings.com/timeline");
        // Предусловие - heatmap включен
        Assumptions.assumeTrue($(By.xpath(WithingsHealthmateTimelinePage.editHeatmapLayoutButtonXpath))
                .shouldBe(Condition.visible, Duration.ofSeconds(30)).isDisplayed());
        // Предусловие - heatmap находится в помесячном режиме
        Assumptions.assumeTrue($(By.xpath("//*[local-name() = 'text' and @class='navig-item uppercase']"))
                .shouldBe(Condition.visible, Duration.ofSeconds(30)).getText().equals("В ЭТОМ МЕСЯЦЕ"));

        new WithingsHealthmateTimelinePage()
                .clickHeatmapLayoutButton()
                .clickSetAsDefaultButton()
                .clickHeatmapSlideButtonTwice()
                .clickSidePanelCloseButton();
        assertTrue($(By.xpath("//*[local-name() = 'text' and @class='navig-item uppercase']"))
                .shouldBe(Condition.visible, Duration.ofSeconds(30)).getText().equals("СЕГОДНЯ"));
    }

    @Description("Завершение")
    @AfterEach
    public void terminate() {

        LogEntries logs = driver.driver().getWebDriver().manage().logs().get(LogType.BROWSER);
        Iterator<LogEntry> logEntriesIterator = logs.iterator();
        while (logEntriesIterator.hasNext()) {
            String logString = logEntriesIterator.next().toString();
            Allure.addAttachment("console log", logString);
            CustomEventListener.logger.info("console log " + logString);
        }
        driver.driver().getWebDriver().quit();
    }
}
