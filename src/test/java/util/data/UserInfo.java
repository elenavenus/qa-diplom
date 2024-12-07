package util.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserInfo {
    private String cardNumber;
    private String cardMonthExpire;
    private String cardYearExpire;
    private String cardOwner;
    private String cvcCode;
}
