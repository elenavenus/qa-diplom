package tests.buyCredit.validateData;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import util.data.InvalidUserField;
import util.data.UserInfoDataGenerator;
import util.pageObject.BuyPage;
import util.pageObject.PageObjectUtils;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class BuyCreditValidateCardNumber {
    @Test
    void shouldValidateCardNumber(){
        BuyPage buyPage = PageObjectUtils.openBuyPage();
        buyPage.inputTestData(UserInfoDataGenerator.generateInvalidUser(InvalidUserField.CARD_NUMBER));
        buyPage.continueButtonCLick();
        $("div.notification_status_error div.notification__content").should(Condition.appear, Duration.ofSeconds(15)).shouldHave(Condition.text("Ошибка! Банк отказал в проведении операции."));
    }

    @Test
    void shouldValidateCardNumberFormat(){
        BuyPage buyPage = PageObjectUtils.openBuyPage();
        buyPage.inputTestData(UserInfoDataGenerator.generateInvalidUser(InvalidUserField.CARD_NUMBER_FORMAT));
        buyPage.continueButtonCLick();
        String errorMessage = "Неверный формат";
        buyPage.getCardNumberErrorSpan().should(Condition.appear).shouldHave(Condition.text(errorMessage));
    }
}
