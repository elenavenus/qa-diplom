package tests.buyCredit.validateData;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import util.data.InvalidUserField;
import util.data.UserInfoDataGenerator;
import util.pageObject.BuyPage;
import util.pageObject.PageObjectUtils;

public class BuyCreditValidateCVCCode {
    @Test
    void shouldValidateCvc(){
        BuyPage buyPage = PageObjectUtils.openBuyPage();
        buyPage.inputTestData(UserInfoDataGenerator.generateInvalidUser(InvalidUserField.INVALID_CVC));
        buyPage.continueButtonCLick();
        String errorMessage = "Неверный формат";
        buyPage.getCvcCodeErrorSpan().should(Condition.appear).shouldHave(Condition.text(errorMessage));
    }
}
