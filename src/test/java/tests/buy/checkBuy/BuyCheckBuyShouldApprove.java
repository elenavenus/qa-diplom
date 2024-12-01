package tests.buy.checkBuy;

import org.junit.jupiter.api.Test;
import util.pageObject.BuyPage;
import util.pageObject.StartPage;

import static com.codeborne.selenide.Selenide.*;

public class BuyCheckBuyShouldApprove {
    @Test
    void shouldApprove(){
        StartPage startPage = open("http://localhost:8080", StartPage.class);
        startPage.clickBuyButton();
        BuyPage buyPage = new BuyPage();
        buyPage.inputTestData();
    }
}
