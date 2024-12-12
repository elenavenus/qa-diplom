package util.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Locale;

public class UserInfoDataGenerator {
    private static final String APPROVE_CARD = "4444444444444441";
    private static final String DECLINE_CARD = "4444444444444442";

    private UserInfoDataGenerator() {
    }

    public static UserInfo generateValidUser(boolean approved) {
        Faker faker = new Faker(new Locale("eng"));
        String cardOwner = generateCardOwner(true);
        String yearExpire = generateYearExpire(true);
        String month = generateValidMonth();
        String cardNumber = generateValidCardNumber(approved);
        String cvc = generateCvcCode(true);
        return new UserInfo(cardNumber, month, yearExpire, cardOwner, cvc);
    }

    public static UserInfo generateInvalidUser(InvalidUserField field){
        UserInfo validUser = generateValidUser(true);
        switch (field){
            case INVALID_CARD_NUMBER:{
                validUser.setCardNumber(generateInvalidCardNumber(false));
                break;
            }
            case INVALID_CARD_NUMBER_FORMAT:{
                validUser.setCardNumber(generateInvalidCardNumber(true));
                break;
            }
            case INVALID_MONTH:{
                validUser.setCardMonthExpire(generateInvalidMonth(false));
                break;
            }
            case INVALID_MONTH_FORMAT:{
                validUser.setCardMonthExpire(generateInvalidMonth(true));
                break;
            }
            case INVALID_YEAR:{
                validUser.setCardYearExpire(generateYearExpire(false));
                break;
            }
            case INVALID_YEAR_FORMAT:{
                validUser.setCardYearExpire("0");
                break;
            }
            case INVALID_OWNER:{
                validUser.setCardOwner(generateCardOwner(false));
                break;
            }
            case INVALID_OWNER_FORMAT:{
                validUser.setCardOwner("");
                break;
            }
            case INVALID_CVC:{
                validUser.setCvcCode(generateCvcCode(false));
                break;
            }
        }
        return validUser;
    }

    public static String generateValidCardNumber(boolean isApprove){
        return isApprove ? APPROVE_CARD : DECLINE_CARD;
    }

    public static String generateInvalidCardNumber(boolean isInvalidFormat){
        Faker faker = new Faker();
        if(isInvalidFormat){
            return faker.numerify("####");
        }else{
            return faker.numerify("###############9");
        }
    }

    //isValid - если true, то метод генерирует валидные данные, иначе невалидные
    public static String generateCardOwner(boolean isValid) {
        if (isValid) {
            Faker faker = new Faker(new Locale("eng"));
            return faker.name().firstName() + " " + faker.name().lastName();
        } else {
            Faker faker = new Faker(new Locale("eng"));
            return faker.name().firstName() + faker.numerify("###");
        }
    }

    public static String generateYearExpire(boolean isValid) {
        if (isValid) {
            return String.valueOf(Year.now().getValue() % 100 + 1);
        } else {
            return String.valueOf((Year.now().getValue() - 3) % 100);
        }
    }

    public static String generateYearCurrent() {
        return String.valueOf(Year.now().getValue() % 100);
    }

    public static String generateValidMonth() {
        LocalDate localDate = LocalDate.now();
        Month currentMonth = localDate.getMonth();
        String monthString = String.valueOf(currentMonth.getValue());
        if (monthString.length() == 1) {
            monthString = "0" + monthString;
        }
        return monthString;
    }

    public static String generateInvalidMonth(boolean isInvalidFormat){
        if(isInvalidFormat){
            return "8";
        }else{
            return "00";
        }
    }

    public static String generateCvcCode(boolean isValid){
        Faker faker = new Faker();
        if(isValid){
            return faker.numerify("###");
        }else{
            return faker.numerify("##");
        }
    }

}
