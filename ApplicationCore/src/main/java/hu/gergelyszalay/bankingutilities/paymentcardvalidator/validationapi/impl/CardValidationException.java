package hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.impl;

import hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.ValidationException;

public class CardValidationException extends ValidationException {

    public CardValidationException(String message) {
        super(message);
    }

}
