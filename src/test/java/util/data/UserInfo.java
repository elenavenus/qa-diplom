package util.data;

import lombok.Value;

@Value
public class UserInfo {
    String cardNumber;
    String cardMonthExpire;
    String cardYearExpire;
    String cardOwner;
    String cvcCode;
}
