package guru.qa.param.junit;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeEach
    void openQiwiWallet() {
        Configuration.baseUrl = "1920x1080";
        open("https://qiwi.com//search?/");

    }
}

