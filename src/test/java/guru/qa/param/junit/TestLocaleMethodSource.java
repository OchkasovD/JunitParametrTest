package guru.qa.param.junit;
import guru.qa.param.junit.data.DataSearch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static guru.qa.param.junit.data.DataSearch.*;



public class TestLocaleMethodSource extends TestBase {
    static Stream<Arguments> LocaleMethodSource() {
        return Stream.of(
                Arguments.of( homenet, List.of("Homenet")),
                Arguments.of( mail, List.of( "Мини-игры@Mail.Ru"))
        );

    }
    @MethodSource
    @ParameterizedTest(name = "Для локали {0} успешно отображаются провайдеры {1}")
    @DisplayName("Тест соответствия найденных провайдеров условиям поиска")
    @Tags({@Tag("CRITICAL"), @Tag("PROVIDERS")})
    void LocaleMethodSource (DataSearch request, List<String> provider) {
        $(".css-1r6sfml").setValue(String.valueOf(request));
        $(".css-9uy14h").click();
        $$(".css-2imjyh").filter(visible).shouldHave(texts(provider));


    }

}
