package lesson3.WithingsHealthmateScenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddTemperature {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;

    public static void main(String[] args) throws InterruptedException {
        loginToWithingsAccount();

        driver.get("https://healthmate.withings.com/timeline");

        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@class='addbutton menu']/div/span[@class='HMIcons_plus']")));
        driver.findElement(By.xpath("//div[@class='addbutton menu']/div/span[@class='HMIcons_plus']")).click();
        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[@class='HMIcons_temperature']")));
        driver.findElement(By.xpath("//span[@class='HMIcons_temperature']")).click();
        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//input[@class='temperatureInput']")));
        driver.findElement(By.xpath("//input[@class='temperatureInput']")).sendKeys("36");
        driver.findElement(By.xpath("//span[text()='Сохранить']")).click();

        Thread.sleep(5000);
        driver.quit();
    }

    public static void addTemperature() {

    }

    public static void loginToWithingsAccount() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 10);

        driver.get("https://account.withings.com/connectionwou/account_login?r=https://healthmate.withings.com/");
        driver.findElement(By.xpath("//button[@class='accept-selection']")).click();
        driver.findElement(By.name("email")).sendKeys("xserv32@gmail.com");
        driver.findElement(By.name("password")).sendKeys("c0mxy64sS32");
        driver.findElement(By.xpath("//button[text()='Вход']")).click();

    }
}
