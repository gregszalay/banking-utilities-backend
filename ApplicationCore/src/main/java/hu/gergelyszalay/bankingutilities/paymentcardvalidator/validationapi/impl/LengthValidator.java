package hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.impl;

import hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.dto.paymentcard.PaymentCard;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.AbstractValidator;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.ValidationException;

public class LengthValidator<T extends PaymentCard> extends AbstractValidator<PaymentCard> {

    private final int cardNumberLength = 16;

    @Override
    protected boolean isValid(PaymentCard card) {
        if (card == null) throw new IllegalArgumentException("Card must not be null!");
        return card.getCardNumber().length() == this.cardNumberLength;
    }

    @Override
    protected ValidationException makeSpecificValidationException() {
        return new CardValidationException("Error: Card number must be " + this.cardNumberLength + " digits!");
    }

}
