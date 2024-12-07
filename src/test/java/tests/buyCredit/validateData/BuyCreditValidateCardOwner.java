package tests.buyCredit.validateData;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import util.data.InvalidUserField;
import util.data.UserInfoDataGenerator;
import util.pageObject.BuyPage;
import util.pageObject.PageObjectUtils;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class BuyCreditValidateCardOwner {
    @Test
    void shouldValidateCardOwner(){
        BuyPage buyPage = PageObjectUtils.openBuyPage();
        buyPage.inputTestData(UserInfoDataGenerator.generateInvalidUser(InvalidUserField.OWNER));
        buyPage.continueButtonCLick();
        $("div.notification_status_error div.notification__content").should(Condition.appear, Duration.ofSeconds(15)).shouldHave(Condition.text("Ошибка! Банк отказал в проведении операции."));
    }

    @Test
    void shouldValidateCardOwnerFormat(){
        BuyPage buyPage = PageObjectUtils.openBuyPage();
        buyPage.inputTestData(UserInfoDataGenerator.generateInvalidUser(InvalidUserField.OWNER_FORMAT));
        buyPage.continueButtonCLick();
        String errorMessage = "Поле обязательно для заполнения";
        buyPage.getCardOwnerErrorSpan().should(Condition.appear).shouldHave(Condition.text(errorMessage));
    }
}
