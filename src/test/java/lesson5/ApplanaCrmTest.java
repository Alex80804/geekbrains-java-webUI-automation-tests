package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplanaCrmTest {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;

    void userAuthentication() {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }

    @BeforeEach
    void initDrivers() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 10);
    }

    @Test
    void projectCreationTest() {
        userAuthentication();
        driver.get("https://crm.geekbrains.space/project/my");
        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id, 'crm_project_name')]")));

        driver.findElement(By.xpath("//input[contains(@id, 'crm_project_name')]"))
                .sendKeys("Тестовый проект7 AlexL New");

        driver.findElement(By.xpath("//a[@class='select2-choice select2-default']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='select2-drop']//input")));

        driver.findElement(By.xpath("//div[@id='select2-drop']//input"))
                .sendKeys("test");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), 'Organisation_1')]")));

        driver.findElement(By.xpath("//div[contains(text(), 'Organisation_1')]")).click();

        Select businessUnitSelect = new Select(driver
                .findElement(By.xpath("//select[contains(@id, 'crm_project_businessUnit')]")));
        businessUnitSelect.selectByVisibleText("Research & Development");

        Select curatorSelect = new Select(driver
                .findElement(By.xpath("//select[contains(@id, 'crm_project_curator')]")));
        curatorSelect.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select rpSelect = new Select(driver
                .findElement(By.xpath("//select[contains(@id, 'crm_project_rp')]")));
        rpSelect.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select administratorSelect = new Select(driver
                .findElement(By.xpath("//select[contains(@id, 'crm_project_administrator')]")));
        administratorSelect.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select managerSelect = new Select(driver
                .findElement(By.xpath("//select[contains(@id, 'crm_project_manager')]")));
        managerSelect.selectByVisibleText("Applanatest Applanatest Applanatest");

        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Проект сохранен']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//div[text()='Проект сохранен']")).isDisplayed());
    }

    @Test
    void contactPersonCreationTest() {
        userAuthentication();
        driver.get("https://crm.geekbrains.space/contact/");

        driver.findElement(By.xpath("//a[text()='Создать контактное лицо']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id, 'crm_contact_lastName')]")));

        driver.findElement(By.xpath("//input[contains(@id, 'crm_contact_lastName')]")).sendKeys("Пупкин");
        driver.findElement(By.xpath("//input[contains(@id, 'crm_contact_firstName')]")).sendKeys("Василий");

        driver.findElement(By.xpath("//a[@class='select2-choice select2-default']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='select2-drop']//input")));

        driver.findElement(By.xpath("//div[@id='select2-drop']//input"))
                .sendKeys("test");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), 'Organisation_1')]")));

        driver.findElement(By.xpath("//div[contains(text(), 'Organisation_1')]")).click();

        driver.findElement(By.xpath("//input[contains(@id, 'crm_contact_jobTitle')]")).sendKeys("Главный");

        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Контактное лицо сохранено']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//div[text()='Контактное лицо сохранено']")).isDisplayed());

    }

    @AfterEach
    void terminate() {
        driver.quit();
    }
}
