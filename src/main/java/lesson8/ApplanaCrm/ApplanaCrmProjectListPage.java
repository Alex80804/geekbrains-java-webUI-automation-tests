package lesson8.ApplanaCrm;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ApplanaCrmProjectListPage {

    private SelenideElement createProjectButton = $(By.xpath("//a[text()='Создать проект']"));

    @Step("Клик на кнопку создать проект")
    public ApplanaCrmCreateProjectPage createProjectButtonClick() {
        createProjectButton.shouldBe(Condition.visible).click();
        return page(ApplanaCrmCreateProjectPage.class);
    }
}