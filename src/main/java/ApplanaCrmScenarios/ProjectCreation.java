package ApplanaCrmScenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectCreation {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;

    public static void main(String[] args) throws InterruptedException {
        loginToCRM();
        driver.get("https://crm.geekbrains.space/project/my");
        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id, 'crm_project_name')]")));

        driver.findElement(By.xpath("//input[contains(@id, 'crm_project_name')]"))
                .sendKeys("Тестовый проект3 AlexL New");

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

        Thread.sleep(5000);
    }

    public static void loginToCRM() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 10);

        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
