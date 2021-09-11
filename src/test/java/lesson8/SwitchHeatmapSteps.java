package lesson8;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lesson8.WInthingsHealthmate.WithingsHealthmateTimelinePage;
import org.junit.jupiter.api.Assumptions;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class SwitchHeatmapSteps {

    @And("I assume the heatmap is on and in weekly mode")
    public void iAssumeTheHeatmapIsOnAndInWeeklyMode() {
        // Предусловие - heatmap включен
        Assumptions.assumeTrue($(By.xpath(WithingsHealthmateTimelinePage.editHeatmapLayoutButtonXpath))
                .shouldBe(Condition.visible, Duration.ofSeconds(30)).isDisplayed());
        // Предусловие - heatmap находится в помесячном режиме
        Assumptions.assumeTrue($(By.xpath("//*[local-name() = 'text' and @class='navig-item uppercase']"))
                .shouldBe(Condition.visible, Duration.ofSeconds(30)).getText().equals("В ЭТОМ МЕСЯЦЕ"));
    }

    @When("I click change layout button")
    public void iClickChangeLayoutButton() {
        new WithingsHealthmateTimelinePage().clickHeatmapLayoutButton();
    }

    @And("I click default button near the daily layout block")
    public void iClickDefaultButtonNearTheDailyLayoutBlock() {
        new WithingsHealthmateTimelinePage().clickSetAsDefaultButton();
    }

    @And("I click slider twice")
    public void iClickSliderTwice() {
        new WithingsHealthmateTimelinePage().clickHeatmapSlideButtonTwice();
    }

    @And("I click side panel close button")
    public void iClickSidePanelCloseButton() {
        new WithingsHealthmateTimelinePage().clickSidePanelCloseButton();
    }

    @Then("the heatmap is switched to daily mode")
    public void theHeatmapIsSwitchedToDailyMode() {
        $(By.xpath("//*[local-name() = 'text' and @class='navig-item uppercase']"))
                .shouldBe(Condition.visible, Duration.ofSeconds(30)).getText().equals("СЕГОДНЯ");
    }
}
