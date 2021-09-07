package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson6.WithingsHealthmate.WithingsHealthmateLoginPage;
import lesson6.WithingsHealthmate.WithingsHealthmateTimelinePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WithingsHealthmatePagesTest {
    public static WebDriver driver;
    public static WebDriverWait webDriverWait;

    void userAuthentication() {
        new WithingsHealthmateLoginPage(driver)
                .clickCookieOK()
                .fillEmail("xserv32@gmail.com")
                .fillPassword("c0mxy64sS32")
                .clickLoginButton();
    }

    @BeforeAll
    static void driverSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void driversCreate() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 10);
    }

    @Test
    void LoginPageTest() throws InterruptedException {
        String assertElementXpath = "//div[@class='user']";
        userAuthentication();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(assertElementXpath)));
        Assertions.assertTrue(driver.findElement(By.xpath(assertElementXpath)).isDisplayed());
    }

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

    @AfterEach
    void terminate() {
        driver.quit();
    }
}
