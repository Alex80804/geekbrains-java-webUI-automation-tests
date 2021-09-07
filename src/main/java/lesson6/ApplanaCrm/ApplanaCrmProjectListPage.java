package lesson6.ApplanaCrm;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplanaCrmProjectListPage extends ApplanaCrmBasePage{
    public ApplanaCrmProjectListPage(WebDriver driver) {
        super(driver);
        driver.get("https://crm.geekbrains.space/project/my");
    }
    @FindBy(xpath = "//a[text()='Создать проект']")
    private WebElement createProjectButton;

    @Step("Клик на кнопку создать проект")
    public ApplanaCrmCreateProjectPage createProjectButtonClick() {
        createProjectButton.click();
        return new ApplanaCrmCreateProjectPage(driver);
    }
}
