package ApplanaCrmScenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPersonCreation {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;

    public static void main(String[] args) {
        loginToCRM();
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
