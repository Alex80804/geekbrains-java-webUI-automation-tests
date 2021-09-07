package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import lesson6.ApplanaCrm.ApplanaCrmContactPersonListPage;
import lesson6.ApplanaCrm.ApplanaCrmLoginPage;
import lesson6.ApplanaCrm.ApplanaCrmProjectListPage;
import lesson7.CustomEventListener;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;

public class ApplanaCrmPagesTest {
    public static EventFiringWebDriver driver;
    public static WebDriverWait webDriverWait;

    void userAuthentication() {
        new ApplanaCrmLoginPage(driver)
                .fillLogin("Applanatest1")
                .fillPassword("Student2020!")
                .clickLoginButton();
    }

    @BeforeAll
    static void driverSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void driversInit() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new CustomEventListener());
        webDriverWait = new WebDriverWait(driver, 10);
    }

    @Description("Тест создания проекта")
    @Test
    void crmCreateProjectTest() {
        userAuthentication();

        new ApplanaCrmProjectListPage(driver)
                .createProjectButtonClick()
                .fillProjectName("Тестовый проект9 AlexL New")
                .clickCrmOrganizationSelect()
                .fillCrmOrganizationInput("test")
                .chooseCrmOrganizationValue()
                .selectBusinessUnit("Research & Development")
                .selectCurator("Applanatest Applanatest Applanatest")
                .selectRp("Applanatest Applanatest Applanatest")
                .selectAdministrator("Applanatest Applanatest Applanatest")
                .selectManager("Applanatest Applanatest Applanatest")
                .saveButtonClick();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Проект сохранен']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//div[text()='Проект сохранен']")).isDisplayed());
    }

    @Description("Тест создания контактного лица")
    @Test
    void crmCreateContactPersonTest() {
        userAuthentication();

        new ApplanaCrmContactPersonListPage(driver)
                .clickCreateButton()
                .fillLastName("Пупкин")
                .fillFirstName("Вассилий")
                .clickCrmOrganizationSelect()
                .fillCrmOrganizationInput("test")
                .chooseCrmOrganizationValue()
                .fillJobTitle("Главный")
                .clickSaveButton();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Контактное лицо сохранено']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//div[text()='Контактное лицо сохранено']")).isDisplayed());
    }

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
