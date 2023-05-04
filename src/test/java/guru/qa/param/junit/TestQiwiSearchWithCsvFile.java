package guru.qa.param.junit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;


public class TestQiwiSearchWithCsvFile extends TestBase {

    @CsvFileSource(resources = "/BeelineSearch.csv")
    @ParameterizedTest(name = "Поиск провайдера по запросу {0} найден провайдер в списке {1}")
    @DisplayName("Тест для проверки нахождения провайдера в списке по условию поиска")
    @Tags({@Tag("CRITICAL"), @Tag("SEARCH"), @Tag("BEELINE"), @Tag("MTS")})
    void testQiwiSearch(String request, String provider) {

    $(".css-1r6sfml").setValue(request);
    $(".css-9uy14h").click();
    $(".css-2imjyh").shouldHave(text(provider));
    }

}
