package util.pageObject;

import static com.codeborne.selenide.Selenide.open;

public class PageObjectUtils {
    private PageObjectUtils(){}

    public static BuyPage openBuyPage(){
        StartPage startPage = open("http://localhost:8080", StartPage.class);
        startPage.clickBuyButton();
        return new BuyPage();
    }

    public static BuyCreditPage openBuyCreditPage(){
        StartPage startPage = open("http://localhost:8080", StartPage.class);
        startPage.clickBuyCreditButton();
        return new BuyCreditPage();
    }
}
