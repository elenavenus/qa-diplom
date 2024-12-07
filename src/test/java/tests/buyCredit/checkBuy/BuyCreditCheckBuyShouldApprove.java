package tests.buyCredit.checkBuy;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import util.data.UserInfoDataGenerator;
import util.pageObject.BuyCreditPage;
import util.pageObject.BuyPage;
import util.pageObject.PageObjectUtils;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class BuyCreditCheckBuyShouldApprove {
    @Test
    void shouldApprove() {
        BuyCreditPage buyCreditPage = PageObjectUtils.openBuyCreditPage();
        buyCreditPage.inputTestData(UserInfoDataGenerator.generateValidUser(true));
        buyCreditPage.continueButtonCLick();
        $("div.notification_status_ok div.notification__content").should(Condition.appear, Duration.ofSeconds(15)).shouldHave(Condition.text("Операция одобрена Банком."));
    }


}
