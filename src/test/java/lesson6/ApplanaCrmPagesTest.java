package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson6.ApplanaCrm.ApplanaCrmContactPersonListPage;
import lesson6.ApplanaCrm.ApplanaCrmLoginPage;
import lesson6.ApplanaCrm.ApplanaCrmProjectListPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplanaCrmPagesTest {
    public static WebDriver driver;
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
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 10);
    }

    @Test
    void crmCreateProjectTest() {
        userAuthentication();

        new ApplanaCrmProjectListPage(driver)
                .createProjectButtonClick()
                .fillProjectName("Тестовый проект8 AlexL New")
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
        driver.quit();
    }
}
