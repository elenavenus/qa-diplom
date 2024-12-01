package tests.buy.checkBuy;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import util.data.UserInfoDataGenerator;
import util.pageObject.BuyPage;
import util.pageObject.StartPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class BuyCheckBuyShouldApprove {
    @Test
    void shouldApprove(){
        StartPage startPage = open("http://localhost:8080", StartPage.class);
        startPage.clickBuyButton();
        BuyPage buyPage = new BuyPage();
        buyPage.inputTestData(UserInfoDataGenerator.generateValidUser(true));
        buyPage.continueButtonCLick();
        $("div .notification__content").should(Condition.appear, Duration.ofSeconds(15)).shouldHave(Condition.text("Операция одобрена Банком."));
    }
}
