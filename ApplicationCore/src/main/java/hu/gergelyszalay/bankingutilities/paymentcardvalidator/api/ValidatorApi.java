package hu.gergelyszalay.bankingutilities.paymentcardvalidator.api;

import hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.dto.ValidationResult;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.impl.Validator;

public interface ValidatorApi {

    default ValidationResult validate(String cardNumber) {
        return new Validator().validate(cardNumber);
    }

}
