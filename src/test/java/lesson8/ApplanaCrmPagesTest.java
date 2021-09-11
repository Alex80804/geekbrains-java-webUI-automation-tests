package lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Conditional;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import lesson7.CustomEventListener;
import lesson8.ApplanaCrm.ApplanaCrmContactPersonListPage;
import lesson8.ApplanaCrm.ApplanaCrmLoginPage;
import lesson8.ApplanaCrm.ApplanaCrmProjectListPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Iterator;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.addListener;

public class ApplanaCrmPagesTest {

    public static Conditional driver;

    void userAuthentication() {
        CustomEventListener.logger = LoggerFactory.getLogger(this.getClass());
        addListener(new CustomEventListener());
        open("https://crm.geekbrains.space/user/login");
        new ApplanaCrmLoginPage()
                .fillLogin("Applanatest1")
                .fillPassword("Student2020!")
                .clickLoginButton();
    }

    @BeforeAll
    static void driverSetup() {
        driver = Selenide.webdriver();
    }

    @Description("Тест создания проекта")
    @Test
    void crmCreateProjectTest() {
        userAuthentication();
        open("https://crm.geekbrains.space/project/my");

        new ApplanaCrmProjectListPage()
                .createProjectButtonClick()
                .fillProjectName("Тестовый проект11 AlexL New")
                .clickCrmOrganizationSelect()
                .fillCrmOrganizationInput("test")
                .chooseCrmOrganizationValue()
                .selectBusinessUnit("Research & Development")
                .selectCurator("Applanatest Applanatest Applanatest")
                .selectRp("Applanatest Applanatest Applanatest")
                .selectAdministrator("Applanatest Applanatest Applanatest")
                .selectManager("Applanatest Applanatest Applanatest")
                .saveButtonClick();

        Assertions.assertTrue($(By.xpath("//div[text()='Проект сохранен']")).
                shouldBe(Condition.visible, Duration.ofSeconds(30)).isDisplayed());
    }

    @Description("Тест создания контактного лица")
    @Test
    void crmCreateContactPersonTest() {
        userAuthentication();
        open("https://crm.geekbrains.space/contact/");
        new ApplanaCrmContactPersonListPage()
                .clickCreateButton()
                .fillLastName("Пупкин")
                .fillFirstName("Вассилий")
                .clickCrmOrganizationSelect()
                .fillCrmOrganizationInput("test")
                .chooseCrmOrganizationValue()
                .fillJobTitle("Главный")
                .clickSaveButton();

        Assertions.assertTrue($(By.xpath("//div[text()='Контактное лицо сохранено']")).
                shouldBe(Condition.visible, Duration.ofSeconds(30)).isDisplayed());
    }

    @AfterEach
    void terminate() {
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
