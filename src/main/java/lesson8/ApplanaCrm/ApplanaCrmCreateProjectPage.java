package lesson8.ApplanaCrm;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class ApplanaCrmCreateProjectPage {

    public static final String crmProjectNameInputXpath = "//input[contains(@id, 'crm_project_name')]";
    private SelenideElement crmProjectNameInput = $(By.xpath(crmProjectNameInputXpath));

    public static final String crmOrganizationSelectXpath = "//a[@class='select2-choice select2-default']";
    private SelenideElement crmOrganizationSelect = $(By.xpath(crmOrganizationSelectXpath));

    public static final String crmOrganizationInputXpath = "//div[@id='select2-drop']//input";
    private SelenideElement crmOrganizationInput = $(By.xpath(crmOrganizationInputXpath));

    public static final String crmOrganizationValueXpath = "//div[contains(text(), 'Organisation_1')]";
    private SelenideElement crmOrganizationValue = $(By.xpath(crmOrganizationValueXpath));

    public static final String businessUnitSelectXpath = "//select[contains(@id, 'crm_project_businessUnit')]";
    private SelenideElement businessUnitSelect = $(By.xpath(businessUnitSelectXpath));

    public static final String curatorSelectXpath = "//select[contains(@id, 'crm_project_curator')]";
    private SelenideElement curatorSelect = $(By.xpath(curatorSelectXpath));

    public static final String rpSelectXpath = "//select[contains(@id, 'crm_project_rp')]";
    private SelenideElement rpSelect = $(By.xpath(rpSelectXpath));

    public static final String administratorSelectXpath = "//select[contains(@id, 'crm_project_administrator')]";
    private SelenideElement administratorSelect = $(By.xpath(administratorSelectXpath));

    public static final String managerSelectXpath = "//select[contains(@id, 'crm_project_manager')]";
    private SelenideElement managerSelect = $(By.xpath(managerSelectXpath));

    public static final String saveButtonXpath = "//button[contains(text(), 'Сохранить и закрыть')]";
    private SelenideElement saveButton = $(By.xpath(saveButtonXpath));

    @Step("Заполнение наименования проекта")
    public ApplanaCrmCreateProjectPage fillProjectName(String projectName) {
        crmProjectNameInput.shouldBe(Condition.visible, Duration.ofSeconds(10)).sendKeys(projectName);
        return this;
    }

    @Step("Клик на комбобокс выбора организации")
    public ApplanaCrmCreateProjectPage clickCrmOrganizationSelect() {
        crmOrganizationSelect.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return this;
    }

    @Step("Заполнение поля поиска по наименованию")
    public ApplanaCrmCreateProjectPage fillCrmOrganizationInput(String organizationPart) {
        crmOrganizationInput.shouldBe(Condition.visible, Duration.ofSeconds(10)).sendKeys(organizationPart);
        return this;
    }

    @Step("Выбор организации из списка")
    public ApplanaCrmCreateProjectPage chooseCrmOrganizationValue() {
        crmOrganizationValue.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return this;
    }

    @Step("Выбор подразделения")
    public ApplanaCrmCreateProjectPage selectBusinessUnit(String businessUnit) {
        businessUnitSelect.selectOptionContainingText(businessUnit);
        //new Select(businessUnitSelect).selectByVisibleText(businessUnit);
        return this;
    }

    @Step("Выбор куратора")
    public ApplanaCrmCreateProjectPage selectCurator(String curator) {
        curatorSelect.selectOptionContainingText(curator);
        return this;
    }

    @Step("Выбор РП")
    public ApplanaCrmCreateProjectPage selectRp(String rp) {
        rpSelect.selectOptionContainingText(rp);
        return this;
    }

    @Step("Выбор администратора")
    public ApplanaCrmCreateProjectPage selectAdministrator(String administrator) {
        administratorSelect.selectOptionContainingText(administrator);
        return this;
    }

    @Step("Выбор менеджера")
    public ApplanaCrmCreateProjectPage selectManager(String manager) {
        managerSelect.selectOptionContainingText(manager);
        return this;
    }

    @Step("Клик на кнопку сохранить и закрыть")
    public void saveButtonClick() {
        saveButton.click();
    }

}
