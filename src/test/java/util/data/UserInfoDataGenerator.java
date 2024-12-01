package util.data;

import com.github.javafaker.Faker;

import java.time.Year;
import java.util.Locale;

public class UserInfoDataGenerator {
    private static final String APPROVE_CARD = "4444444444444441";
    private static final String DECLINE_CARD = "4444444444444442";

    private UserInfoDataGenerator(){}

    public static UserInfo generateValidUser(boolean approved){
        Faker faker = new Faker(new Locale("eng"));
        String cardOwner = faker.name().firstName() + " " + faker.name().lastName();
        String yearExpire = String.valueOf(Year.now().getValue() % 100 + 1);
        String month = String.valueOf(faker.random().nextInt(1,12));
        if(month.length() == 1){
            month = "0" + month;
        }
        String cardNumber = approved ? APPROVE_CARD : DECLINE_CARD;
        String cvc = faker.numerify("###");
        return new UserInfo(cardNumber, month, yearExpire, cardOwner, cvc);
    }



}
