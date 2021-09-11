package lesson8.ApplanaCrm;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class ApplanaCrmCreateContactPersonPage {

    public static final String lastNameXpath = "//input[contains(@id, 'crm_contact_lastName')]";
    private SelenideElement lastNameInput = $(By.xpath(lastNameXpath));

    public static final String firstNameXpath = "//input[contains(@id, 'crm_contact_firstName')]";
    private SelenideElement firstNameInput = $(By.xpath(firstNameXpath));

    public static final String crmOrganizationSelectXpath = "//a[@class='select2-choice select2-default']";
    private SelenideElement crmOrganizationSelect = $(By.xpath(crmOrganizationSelectXpath));

    public static final String crmOrganizationInputXpath = "//div[@id='select2-drop']//input";
    private SelenideElement crmOrganizationInput = $(By.xpath(crmOrganizationInputXpath));

    public static final String crmOrganizationValueXpath = "//div[contains(text(), 'Organisation_1')]";
    private SelenideElement crmOrganizationValue = $(By.xpath(crmOrganizationValueXpath));

    public static final String jobTitleXpath = "//input[contains(@id, 'crm_contact_jobTitle')]";
    private SelenideElement jobTitleInput = $(By.xpath(jobTitleXpath));

    public static final String saveButtonXpath = "//button[contains(text(), 'Сохранить и закрыть')]";
    private SelenideElement saveButton = $(By.xpath(saveButtonXpath));

    @Step("Заполнение фамилии")
    public ApplanaCrmCreateContactPersonPage fillLastName(String lastName) {
        lastNameInput.shouldBe(Condition.visible, Duration.ofSeconds(10)).sendKeys(lastName);
        return this;
    }

    @Step("Заполнение имени")
    public ApplanaCrmCreateContactPersonPage fillFirstName(String firstName) {
        firstNameInput.shouldBe(Condition.visible, Duration.ofSeconds(10)).sendKeys(firstName);
        return this;
    }

    @Step("Клик на комбобокс выбора организации")
    public ApplanaCrmCreateContactPersonPage clickCrmOrganizationSelect() {
        crmOrganizationSelect.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return this;
    }

    @Step("Заполнение поиска организации")
    public ApplanaCrmCreateContactPersonPage fillCrmOrganizationInput(String organizationPart) {
        crmOrganizationInput.shouldBe(Condition.visible, Duration.ofSeconds(10)).sendKeys(organizationPart);
        return this;
    }

    @Step("Выбор значения поиска организации")
    public ApplanaCrmCreateContactPersonPage chooseCrmOrganizationValue() {
        crmOrganizationValue.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return this;
    }

    @Step("Заполнение позиции контактного лица")
    public ApplanaCrmCreateContactPersonPage fillJobTitle(String jobTitle) {
        jobTitleInput.shouldBe(Condition.visible, Duration.ofSeconds(10)).sendKeys(jobTitle);
        return this;
    }

    @Step("Нажатие на кнопку сохранить и закрыть")
    public void clickSaveButton() {
        saveButton.click();
    }
}
