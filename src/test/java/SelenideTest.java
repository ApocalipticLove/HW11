import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {
    @Test
    public void selenideTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть страницу github", () -> {
        open("https://github.com/");
        });
        step("Перейти в репозиторий Selenide в github", () -> {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("selenide");
        $(".header-search-input").submit();
        $(linkText("selenide/selenide")).click();
        });
        step("Перейти в раздел Wiki", () -> {
        $("#wiki-tab").click();
        });
        step("Провека наличия раздела Soft Assertions", () -> {
        $(".js-wiki-more-pages-link").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        });
        step("Перейти на страницу Soft Assertions", () -> {
        $("#wiki-pages-box").find(byText("SoftAssertions")).click();
        });
        step("Првоерка наличия примера кода для JUnit5", () -> {
        $("#user-content-3-using-junit5-extend-test-class").shouldBe(Condition.visible);
        });
    }
}
