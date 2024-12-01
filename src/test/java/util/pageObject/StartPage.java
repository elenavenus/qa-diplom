package util.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class StartPage {
    private SelenideElement buyButton;
    private SelenideElement buyCreditButton;

    public StartPage(){
        ElementsCollection buttons = $$("button");
        buyButton = buttons.get(0).shouldHave(Condition.text("Купить"));
        buyCreditButton = buttons.get(1).shouldHave(Condition.text("Купить в кредит"));
    }

    public void clickBuyButton(){
        buyButton.click();
    }

    public void clickBuyCreditButton(){
        buyCreditButton.click();
    }


}
