package tests.buy.checkBuy;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import util.data.UserInfoDataGenerator;
import util.pageObject.BuyPage;
import util.pageObject.PageObjectUtils;
import util.pageObject.StartPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BuyCheckBuyShouldDeclined {
    @Test
    void shouldDeclined(){
        BuyPage buyPage = PageObjectUtils.openBuyPage();
        buyPage.inputTestData(UserInfoDataGenerator.generateValidUser(false));
        buyPage.continueButtonCLick();
        $("div.notification_status_error div.notification__content").should(Condition.appear, Duration.ofSeconds(15)).shouldHave(Condition.text("Ошибка! Банк отказал в проведении операции."));
    }
}
