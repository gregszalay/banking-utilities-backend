package hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.impl;

import hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.dto.paymentcard.PaymentCard;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.AbstractValidator;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.ValidationException;

public class CharacterValidator<T extends PaymentCard> extends AbstractValidator<PaymentCard> {

    @Override
    protected boolean isValid(PaymentCard card) {
        if (card == null) throw new IllegalArgumentException("Card must not be null!");
        final String onlyDigitsPattern = "^[0-9]+$";
        return card.getCardNumber().matches(onlyDigitsPattern);
    }

    @Override
    protected ValidationException makeSpecificValidationException() {
        return new CardValidationException("Error: Card number should only contain digits!");
    }

}
