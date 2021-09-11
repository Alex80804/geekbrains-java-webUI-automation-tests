package lesson8;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lesson8.ApplanaCrm.ApplanaCrmCreateProjectPage;
import lesson8.ApplanaCrm.ApplanaCrmProjectListPage;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AddNewProjectSteps {
    @When("I go to project list page")
    public void iGoToProjectListPage() {
        open("https://crm.geekbrains.space/project/my");
    }

    @And("I click create project button")
    public void iClickCreateProjectButton() {
        new ApplanaCrmProjectListPage().createProjectButtonClick();
    }

    @And("I fill project name {string}")
    public void iFillProjectNameProjectName(String projectName) {
        new ApplanaCrmCreateProjectPage().fillProjectName(projectName);
    }

    @And("I search organizations for project with {string} substring and choose one from the dropdown list")
    public void iChooseOrganizationFromTheDropdownList(String orgString) {
        new ApplanaCrmCreateProjectPage()
                .clickCrmOrganizationSelect()
                .fillCrmOrganizationInput(orgString)
                .chooseCrmOrganizationValue();
    }

    @And("I select business unit {string}")
    public void iSelectBusinessUnitBusinessUnit(String businessUnit) {
        new ApplanaCrmCreateProjectPage().selectBusinessUnit(businessUnit);
    }

    @And("I select curator {string}")
    public void iSelectCuratorCurator(String curator) {
        new ApplanaCrmCreateProjectPage().selectCurator(curator);
    }

    @And("I select rp {string}")
    public void iSelectRpRp(String rp) {
        new ApplanaCrmCreateProjectPage().selectRp(rp);
    }

    @And("I select administrator {string}")
    public void iSelectAdministratorAdministrator(String administrator) {
        new ApplanaCrmCreateProjectPage().selectAdministrator(administrator);
    }

    @And("I select manager {string}")
    public void iSelectManagerManager(String manager) {
        new ApplanaCrmCreateProjectPage().selectManager(manager);
    }

    @And("I click save project button")
    public void iClickSaveProjectButton() {
        new ApplanaCrmCreateProjectPage().saveButtonClick();
    }

    @Then("a success message project saved is shown")
    public void aSuccessMessageIsShown() {
        $(By.xpath("//div[text()='Проект сохранен']")).shouldBe(Condition.visible, Duration.ofSeconds(30));
    }
}
