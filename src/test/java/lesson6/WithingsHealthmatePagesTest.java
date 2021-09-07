package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import lesson6.WithingsHealthmate.WithingsHealthmateLoginPage;
import lesson6.WithingsHealthmate.WithingsHealthmateTimelinePage;
import lesson7.CustomEventListener;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

@Story("Тестирование страниц Withings Healthmate")
public class WithingsHealthmatePagesTest {
    //public static WebDriver driver;
    public static EventFiringWebDriver driver;
    public static WebDriverWait webDriverWait;

    void userAuthentication() {
        new WithingsHealthmateLoginPage(driver)
                .clickCookieOK()
                .fillEmail("xserv32@gmail.com")
                .fillPassword("c0mxy64sS32")
                .clickLoginButton();
    }

    @Description("Инициализация")
    @BeforeAll
    static void driverSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @Description("Создание драйверов")
    @BeforeEach
    void driversCreate() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new CustomEventListener());
        webDriverWait = new WebDriverWait(driver, 10);
    }

    @Description("Тест страницы логина")
    @Test
    void LoginPageTest() throws InterruptedException {
        String assertElementXpath = "//div[@class='user']";
        userAuthentication();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(assertElementXpath)));
        Assertions.assertTrue(driver.findElement(By.xpath(assertElementXpath)).isDisplayed());
    }

    @Description("Тест логаута")
    @Test
    void LogoutTest() throws InterruptedException {
        Cookie sessionCookie = driver.manage().getCookieNamed("session_key");
        userAuthentication();
        new WithingsHealthmateTimelinePage(driver)
                .clickUserIcon()
                .clickLogoutMenuItem();

        Thread.sleep(5000);
        Assertions.assertNull(driver.manage().getCookieNamed("session_key"));
    }

    @Description("Тест добавления температуры")
    @Test
    void addTemperatureTest() throws InterruptedException {
        String tempToAdd = "36.3";

        userAuthentication();
        new WithingsHealthmateTimelinePage(driver)
                .clickAddMeasurementIcon()
                .clickAddTemperatureIcon()
                .inputTemperature(tempToAdd)
                .saveTemperature();

        Thread.sleep(1000);
        //webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), '°C')]")));
        List<WebElement> temps = driver.findElements(By.xpath("//div[contains(text(), '°C')]"));
        Assertions.assertEquals(tempToAdd + " °C", temps.get(0).getText());
    }

    @Description("Тест переключения heatmap в ежедневный режим")
    @Test
    void switchDashToDailyModeTest() {

        userAuthentication();

        // Ждем загрузки страницы
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Journal']")));
        // Предусловие - heatmap включен
        Assumptions.assumeTrue(driver.findElement(By.xpath(WithingsHealthmateTimelinePage.editHeatmapLayoutButtonXpath)).isDisplayed());
        // Предусловие - heatmap находится в помесячном режиме
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[local-name() = 'text' and @class='navig-item uppercase']")));
        Assumptions.assumeTrue(driver.findElement(By.xpath("//*[local-name() = 'text' and @class='navig-item uppercase']")).getText().equals("В ЭТОМ МЕСЯЦЕ"));

        new WithingsHealthmateTimelinePage(driver)
                .clickHeatmapLayoutButton()
                .clickSetAsDefaultButton()
                .clickHeatmapSlideButtonTwice()
                .clickSidePanelCloseButton();

        Assertions.assertTrue(driver.findElement(By.xpath("//*[local-name() = 'text' and @class='navig-item uppercase']")).getText().equals("СЕГОДНЯ"));
    }

    @Description("Завершение")
    @AfterEach
    void terminate() {
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        Iterator<LogEntry> logEntriesIterator = logs.iterator();
        while(logEntriesIterator.hasNext()) {
            Allure.addAttachment("console log", logEntriesIterator.next().toString());
        }
        driver.quit();
    }
}
