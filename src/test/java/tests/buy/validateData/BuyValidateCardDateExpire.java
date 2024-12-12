package tests.buy.validateData;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import util.data.InvalidUserField;
import util.data.UserInfoDataGenerator;
import util.pageObject.BuyPage;
import util.pageObject.PageObjectUtils;

import static com.codeborne.selenide.Selenide.open;

public class BuyValidateCardDateExpire {

    @Test
    void shouldValidateMonth(){
        BuyPage buyPage = PageObjectUtils.openBuyPage();
        buyPage.inputTestData(UserInfoDataGenerator.generateInvalidUser(InvalidUserField.INVALID_MONTH));
        buyPage.continueButtonCLick();
        String errorMessage = "Неверно указан срок действия карты";
        buyPage.getMonthErrorSpan().should(Condition.appear).shouldHave(Condition.text(errorMessage));
    }

    @Test
    void shouldValidateMonthFormat(){
        BuyPage buyPage = PageObjectUtils.openBuyPage();
        buyPage.inputTestData(UserInfoDataGenerator.generateInvalidUser(InvalidUserField.INVALID_MONTH_FORMAT));
        buyPage.continueButtonCLick();
        String errorMessage = "Неверный формат";
        buyPage.getMonthErrorSpan().should(Condition.appear).shouldHave(Condition.text(errorMessage));
    }

    @Test
    void shouldValidateYear(){
        BuyPage buyPage = PageObjectUtils.openBuyPage();
        buyPage.inputTestData(UserInfoDataGenerator.generateInvalidUser(InvalidUserField.INVALID_YEAR));
        buyPage.continueButtonCLick();
        String errorMessage = "Истёк срок действия карты";
        buyPage.getYearErrorSpan().shouldHave(Condition.appear).shouldHave(Condition.text(errorMessage));
    }

    @Test
    void shouldValidateYearFormat(){
        BuyPage buyPage = PageObjectUtils.openBuyPage();
        buyPage.inputTestData(UserInfoDataGenerator.generateInvalidUser(InvalidUserField.INVALID_YEAR_FORMAT));
        buyPage.continueButtonCLick();
        String errorMessage = "Неверный формат";
        buyPage.getYearErrorSpan().shouldHave(Condition.appear).shouldHave(Condition.text(errorMessage));
    }
}
