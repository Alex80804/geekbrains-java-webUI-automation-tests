package lesson6.ApplanaCrm;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ApplanaCrmCreateProjectPage extends ApplanaCrmBasePage{
    public ApplanaCrmCreateProjectPage(WebDriver driver) {
        super(driver);
    }

    public static final String crmProjectNameInputXpath = "//input[contains(@id, 'crm_project_name')]";
    @FindBy(xpath = crmProjectNameInputXpath)
    private WebElement crmProjectNameInput;

    public static final String crmOrganizationSelectXpath = "//a[@class='select2-choice select2-default']";
    @FindBy(xpath = crmOrganizationSelectXpath)
    private WebElement crmOrganizationSelect;

    public static final String crmOrganizationInputXpath = "//div[@id='select2-drop']//input";
    @FindBy(xpath = crmOrganizationInputXpath)
    private WebElement crmOrganizationInput;

    public static final String crmOrganizationValueXpath = "//div[contains(text(), 'Organisation_1')]";
    @FindBy(xpath = crmOrganizationValueXpath)
    private WebElement crmOrganizationValue;

    public static final String businessUnitSelectXpath = "//select[contains(@id, 'crm_project_businessUnit')]";
    @FindBy(xpath = businessUnitSelectXpath)
    private WebElement businessUnitSelect;

    public static final String curatorSelectXpath = "//select[contains(@id, 'crm_project_curator')]";
    @FindBy(xpath = curatorSelectXpath)
    private WebElement curatorSelect;

    public static final String rpSelectXpath = "//select[contains(@id, 'crm_project_rp')]";
    @FindBy(xpath = rpSelectXpath)
    private WebElement rpSelect;

    public static final String administratorSelectXpath = "//select[contains(@id, 'crm_project_administrator')]";
    @FindBy(xpath = administratorSelectXpath)
    private WebElement administratorSelect;

    public static final String managerSelectXpath = "//select[contains(@id, 'crm_project_manager')]";
    @FindBy(xpath = managerSelectXpath)
    private WebElement managerSelect;

    public static final String saveButtonXpath="//button[contains(text(), 'Сохранить и закрыть')]";
    @FindBy(xpath = saveButtonXpath)
    private WebElement saveButton;

    @Step("Заполнение наименования проекта")
    public ApplanaCrmCreateProjectPage fillProjectName(String projectName) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(crmProjectNameInputXpath)));
        crmProjectNameInput.sendKeys(projectName);
        return this;
    }

    @Step("КЛик на комбобокс выбора организации")
    public ApplanaCrmCreateProjectPage clickCrmOrganizationSelect() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(crmOrganizationSelectXpath)));
        crmOrganizationSelect.click();
        return this;
    }

    @Step("Заполнение поля поиска по наименованию")
    public ApplanaCrmCreateProjectPage fillCrmOrganizationInput(String organizationPart) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(crmOrganizationInputXpath)));
        crmOrganizationInput.sendKeys(organizationPart);
        return this;
    }

    @Step("Выбор организации из списка")
    public ApplanaCrmCreateProjectPage chooseCrmOrganizationValue() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(crmOrganizationValueXpath)));
        crmOrganizationValue.click();
        return this;
    }

    @Step("Выбор подразделения")
    public ApplanaCrmCreateProjectPage selectBusinessUnit(String businessUnit) {
        new Select(businessUnitSelect).selectByVisibleText(businessUnit);
        return this;
    }

    @Step("Выбор куратора")
    public ApplanaCrmCreateProjectPage selectCurator(String curator) {
        new Select(curatorSelect).selectByVisibleText(curator);
        return this;
    }

    @Step("Выбор РП")
    public ApplanaCrmCreateProjectPage selectRp(String rp) {
        new Select(rpSelect).selectByVisibleText(rp);
        return this;
    }

    @Step("Выбор администратора")
    public ApplanaCrmCreateProjectPage selectAdministrator(String administrator) {
        new Select(administratorSelect).selectByVisibleText(administrator);
        return this;
    }

    @Step("Выбор менеджера")
    public ApplanaCrmCreateProjectPage selectManager(String manager) {
        new Select(managerSelect).selectByVisibleText(manager);
        return this;
    }

    @Step("Клик на кнопку сохранить и закрыть")
    public void saveButtonClick() {
        saveButton.click();
    }

}
