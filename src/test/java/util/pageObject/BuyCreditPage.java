package util.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BuyCreditPage {
    private SelenideElement cardInput;
    private SelenideElement monthInput;
    private SelenideElement yearInput;
    private SelenideElement cardOwnerInput;
    private SelenideElement cvcCodeInput;
    private SelenideElement continueButton;

    public BuyCreditPage(){
        $$("h3").filter(Condition.text("Оплата по карте")).filter(Condition.appear).get(0).shouldHave(Condition.visible);
        $("form").should(Condition.appear);
        ElementsCollection inputs = $$("input");
        cardInput = inputs.find(Condition.attribute("placeholder","0000 0000 0000 0000"));
        monthInput = inputs.find(Condition.attribute("placeholder","08"));
        yearInput = inputs.find(Condition.attribute("placeholder","22"));
        cvcCodeInput = inputs.find(Condition.attribute("placeholder","999"));
        cardOwnerInput = $("input:not([placeholder])");
        continueButton = $$("button").filter(Condition.text("Продолжить")).get(0);
    }

    public void continueButtonCLick(){
        continueButton.click();
    }
}
