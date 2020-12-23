import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class AlfaTest {
    @Test
    void archiveDepositsSizeTest() {
        open("https://alfabank.ru/make-money/");

        $$(byText("Депозиты")).find(visible).parent().click();
        $$x("//*[@data-test-id='button']").find(text("Архивные счета и депозиты")).click();
        $x("//*[@data-test-id='tabs-list-tabTitle-2']").preceding(0).click();
        $$x("//*[@data-widget-name='CatalogCard']").shouldHave(CollectionCondition.size(5));
    }

    @Test
    void InsuranceTest() {
        open("https://alfabank.ru/make-money/");

        $(".c2C7LVl").sibling(0).click();
        $x("//*[@data-test-id='accordion-header-0']").shouldHave(text("Альфа-Банк является участником системы обязательного страхования вкладов")).click();
        $x("//*[@data-test-id='accordion-header-1']").shouldHave(text("Федеральный закон от 23.12.2003 N 177-ФЗ «О страховании вкладов физических лиц в банках Российской Федерации»")).click();
        $x("//*[@data-test-id='accordion-header-2']").shouldHave(text("Страхованию подлежат")).click();
        $x("//*[@data-test-id='accordion-header-3']").shouldHave(text("Как происходит возмещение средств?")).click();
    }
}
