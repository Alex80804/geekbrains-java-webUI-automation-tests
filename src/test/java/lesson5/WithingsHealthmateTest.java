package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WithingsHealthmateTest {
    public static WebDriver driver;
    public static WebDriverWait webDriverWait;

    void userAuthentication() {
        driver.get("https://account.withings.com/connectionwou/account_login?r=https://healthmate.withings.com/");
        driver.findElement(By.xpath("//button[@class='accept-selection']")).click();
        driver.findElement(By.name("email")).sendKeys("xserv32@gmail.com");
        driver.findElement(By.name("password")).sendKeys("c0mxy64sS32");
        driver.findElement(By.xpath("//button[text()='Вход']")).click();
    }

    @BeforeEach
    void initDrivers() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 10);

    }

    @Test
    void userAuthTest() throws InterruptedException {
        userAuthentication();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='user']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='user']")).isDisplayed());
    }

    @Test
    void addTemperatureTest() throws InterruptedException {

        String tempToAdd = "36.3";

        userAuthentication();

        driver.get("https://healthmate.withings.com/timeline");

        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@class='addbutton menu']/div/span[@class='HMIcons_plus']")));
        driver.findElement(By.xpath("//div[@class='addbutton menu']/div/span[@class='HMIcons_plus']")).click();

        webDriverWait.until(ExpectedConditions
                .visibilityOf(driver.findElement(By.xpath("//li[@data-trigger='app:temperature:list:add']//span"))));
        driver.findElement(By.xpath("//li[@data-trigger='app:temperature:list:add']//span")).click();

        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//input[@class='temperatureInput']")));
        driver.findElement(By.xpath("//input[@class='temperatureInput']")).sendKeys(tempToAdd);
        driver.findElement(By.xpath("//span[text()='Сохранить']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), '°C')]")));

        List<WebElement> temps = driver.findElements(By.xpath("//div[contains(text(), '°C')]"));
        Assertions.assertEquals(tempToAdd + " °C", temps.get(0).getText());
    }

    @Test
    void userLogoutTest() {
        userAuthentication();

        Cookie sessionCookie = driver.manage().getCookieNamed("session_key");
        System.out.println(sessionCookie.toString());

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='user']")));
        driver.findElement(By.xpath("//div[@class='user']")).click();
        driver.findElement(By.xpath("//li[@class='js-logout']")).click();

        Assertions.assertNull(driver.manage().getCookieNamed("session_key"));
    }

    @Test
    void switchDashToDailyMode() throws InterruptedException {

        userAuthentication();
        // Ждем загрузки страницы
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Journal']")));
        // Предусловие - heatmap включен
        Assumptions.assumeTrue(driver.findElement(By.xpath("//span[@class='js-manage HMIcons_edit']")).isDisplayed());
        // Предусловие - heatmap находится в помесячном режиме
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[local-name() = 'text' and @class='navig-item uppercase']")));
        Assumptions.assumeTrue(driver.findElement(By.xpath("//*[local-name() = 'text' and @class='navig-item uppercase']")).getText().equals("В ЭТОМ МЕСЯЦЕ"));
        driver.findElement(By.xpath("//span[@class='js-manage HMIcons_edit']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='heatmap-daily']//div[@class=' val button uppercase js-default']"))));
        driver.findElement(By.xpath("//div[@class='heatmap-daily']//div[@class=' val button uppercase js-default']")).click();
        driver.findElement(By.xpath("//div[@class='slide-button']")).click();
        driver.findElement(By.xpath("//div[@class='slide-button']")).click();
        driver.findElement(By.xpath("//div[@class='HMIcons_close action js-close']")).click();

        Assertions.assertTrue(driver.findElement(By.xpath("//*[local-name() = 'text' and @class='navig-item uppercase']")).getText().equals("СЕГОДНЯ"));
    }

    @AfterEach
    void terminate() {
        driver.quit();
    }
}
