package WithingsHealthmateScenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserAuthorization {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;

    public static void main(String[] args) throws InterruptedException {
        loginToWithingsAccount();
        Thread.sleep(5000);
        driver.quit();
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
