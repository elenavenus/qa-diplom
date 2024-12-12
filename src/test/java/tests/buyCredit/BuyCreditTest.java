package tests.buyCredit;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import util.data.InvalidUserField;
import util.data.UserInfoDataGenerator;
import util.pageObject.BuyCreditPage;
import util.pageObject.BuyPage;
import util.pageObject.PageObjectUtils;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class BuyCreditTest {
    @Test
    void shouldApprove() {
        BuyCreditPage buyCreditPage = PageObjectUtils.openBuyCreditPage();
        buyCreditPage.inputTestData(UserInfoDataGenerator.generateValidUser(true));
        buyCreditPage.continueButtonCLick();
        $("div.notification_status_ok div.notification__content").should(Condition.appear, Duration.ofSeconds(15)).shouldHave(Condition.text("Операция одобрена Банком."));
    }


    @Test
    void shouldDeclined(){
        BuyCreditPage buyCreditPage = PageObjectUtils.openBuyCreditPage();
        buyCreditPage.inputTestData(UserInfoDataGenerator.generateValidUser(false));
        buyCreditPage.continueButtonCLick();
        $("div.notification_status_error div.notification__content").should(Condition.appear, Duration.ofSeconds(15)).shouldHave(Condition.text("Ошибка! Банк отказал в проведении операции."));
    }

    @Test
    void shouldValidateMonth(){
        BuyCreditPage buyPage = PageObjectUtils.openBuyCreditPage();
        buyPage.inputTestData(UserInfoDataGenerator.generateInvalidUser(InvalidUserField.INVALID_MONTH));
        buyPage.continueButtonCLick();
        String errorMessage = "Неверно указан срок действия карты";
        buyPage.getMonthErrorSpan().should(Condition.appear).shouldHave(Condition.text(errorMessage));
    }

    @Test
    void shouldValidateMonthFormat(){
        BuyCreditPage buyPage = PageObjectUtils.openBuyCreditPage();
        buyPage.inputTestData(UserInfoDataGenerator.generateInvalidUser(InvalidUserField.INVALID_MONTH_FORMAT));
        buyPage.continueButtonCLick();
        String errorMessage = "Неверный формат";
        buyPage.getMonthErrorSpan().should(Condition.appear).shouldHave(Condition.text(errorMessage));
    }

    @Test
    void shouldValidateYear(){
        BuyCreditPage buyPage = PageObjectUtils.openBuyCreditPage();
        buyPage.inputTestData(UserInfoDataGenerator.generateInvalidUser(InvalidUserField.INVALID_YEAR));
        buyPage.continueButtonCLick();
        String errorMessage = "Истёк срок действия карты";
        buyPage.getYearErrorSpan().shouldHave(Condition.appear).shouldHave(Condition.text(errorMessage));
    }

    @Test
    void shouldValidateYearFormat(){
        BuyCreditPage buyPage = PageObjectUtils.openBuyCreditPage();
        buyPage.inputTestData(UserInfoDataGenerator.generateInvalidUser(InvalidUserField.INVALID_YEAR_FORMAT));
        buyPage.continueButtonCLick();
        String errorMessage = "Неверный формат";
        buyPage.getYearErrorSpan().shouldHave(Condition.appear).shouldHave(Condition.text(errorMessage));
    }

    @Test
    void shouldValidateCardNumber(){
        BuyCreditPage buyPage = PageObjectUtils.openBuyCreditPage();
        buyPage.inputTestData(UserInfoDataGenerator.generateInvalidUser(InvalidUserField.INVALID_CARD_NUMBER));
        buyPage.continueButtonCLick();
        $("div.notification_status_error div.notification__content").should(Condition.appear, Duration.ofSeconds(15)).shouldHave(Condition.text("Ошибка! Банк отказал в проведении операции."));
    }

    @Test
    void shouldValidateCardNumberFormat(){
        BuyCreditPage buyPage = PageObjectUtils.openBuyCreditPage();
        buyPage.inputTestData(UserInfoDataGenerator.generateInvalidUser(InvalidUserField.INVALID_CARD_NUMBER_FORMAT));
        buyPage.continueButtonCLick();
        String errorMessage = "Неверный формат";
        buyPage.getCardNumberErrorSpan().should(Condition.appear).shouldHave(Condition.text(errorMessage));
    }

    @Test
    void shouldValidateCardOwner(){
        BuyCreditPage buyPage = PageObjectUtils.openBuyCreditPage();
        buyPage.inputTestData(UserInfoDataGenerator.generateInvalidUser(InvalidUserField.INVALID_OWNER));
        buyPage.continueButtonCLick();
        $("div.notification_status_error div.notification__content").should(Condition.appear, Duration.ofSeconds(15)).shouldHave(Condition.text("Ошибка! Банк отказал в проведении операции."));
    }

    @Test
    void shouldValidateCardOwnerFormat(){
        BuyCreditPage buyPage = PageObjectUtils.openBuyCreditPage();
        buyPage.inputTestData(UserInfoDataGenerator.generateInvalidUser(InvalidUserField.INVALID_OWNER_FORMAT));
        buyPage.continueButtonCLick();
        String errorMessage = "Поле обязательно для заполнения";
        buyPage.getCardOwnerErrorSpan().should(Condition.appear).shouldHave(Condition.text(errorMessage));
    }

    @Test
    void shouldValidateCvc(){
        BuyCreditPage buyPage = PageObjectUtils.openBuyCreditPage();
        buyPage.inputTestData(UserInfoDataGenerator.generateInvalidUser(InvalidUserField.INVALID_CVC));
        buyPage.continueButtonCLick();
        String errorMessage = "Неверный формат";
        buyPage.getCvcCodeErrorSpan().should(Condition.appear).shouldHave(Condition.text(errorMessage));
    }

}
