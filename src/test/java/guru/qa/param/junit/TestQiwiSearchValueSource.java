package guru.qa.param.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class TestQiwiSearchValueSource extends TestBase {

    @ValueSource(strings = {"билайн"})

    @ParameterizedTest(name = "Поиск провайдера по запросу {0} ")
    @DisplayName("Тест для проверки нахождения провайдера в списке по условию поиска")
    @Tags({@Tag("CRITICAL"), @Tag("SEARCH"), @Tag("BEELINE")})
    void testSearchBeline(String letters) {

    $(".css-1r6sfml").setValue(letters);
    $(".css-9uy14h").click();
    $(".css-2imjyh").shouldHave(text(letters));
    }

}
