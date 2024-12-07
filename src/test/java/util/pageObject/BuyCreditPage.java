package util.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import util.data.UserInfo;

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
        $$("h3").filter(Condition.text("Кредит по данным карты")).filter(Condition.appear).get(0).shouldHave(Condition.visible);
        $("form").should(Condition.appear);
        ElementsCollection inputs = $$("input");
        cardInput = inputs.find(Condition.attribute("placeholder","0000 0000 0000 0000"));
        monthInput = inputs.find(Condition.attribute("placeholder","08"));
        yearInput = inputs.find(Condition.attribute("placeholder","22"));
        cvcCodeInput = inputs.find(Condition.attribute("placeholder","999"));
        cardOwnerInput = $("input:not([placeholder])");
        continueButton = $$("button").filter(Condition.text("Продолжить")).get(0);
    }

    public void inputTestData(UserInfo userInfo){
        cardInput.setValue(userInfo.getCardNumber());
        monthInput.setValue(userInfo.getCardMonthExpire());
        yearInput.setValue(userInfo.getCardYearExpire());
        cvcCodeInput.setValue(userInfo.getCvcCode());
        cardOwnerInput.setValue(userInfo.getCardOwner());
    }

    public void continueButtonCLick(){
        continueButton.click();
    }

    public SelenideElement getMonthErrorSpan(){
        return monthInput.parent().parent().$(".input__sub");
    }

    public SelenideElement getYearErrorSpan(){
        return yearInput.parent().parent().$(".input__sub");
    }

    public SelenideElement getCardNumberErrorSpan(){
        return cardInput.parent().parent().$(".input__sub");
    }

    public SelenideElement getCardOwnerErrorSpan(){
        return cardOwnerInput.parent().parent().$(".input__sub");
    }

    public SelenideElement getCvcCodeErrorSpan(){
        return cvcCodeInput.parent().parent().$(".input__sub");
    }

}
