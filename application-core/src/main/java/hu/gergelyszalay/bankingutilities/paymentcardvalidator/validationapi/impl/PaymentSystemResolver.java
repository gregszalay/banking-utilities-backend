package hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.impl;

import hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.dto.paymentcard.PaymentCard;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.paymentsystems.PaymentSystems;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.AbstractValidator;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.ValidationException;

public class PaymentSystemResolver<T extends PaymentCard> extends AbstractValidator<PaymentCard> {

    @Override
    protected boolean isValid(PaymentCard card) {
        if (card == null) throw new IllegalArgumentException("Card must not be null!");

        PaymentSystems paymentSystem = PaymentSystems.getPaymentSystemByID(card.getCardNumber());
        card.setPaymentSystem(paymentSystem);

        return !paymentSystem.equals(PaymentSystems.UNKNOWN);

    }

    @Override
    protected ValidationException makeSpecificValidationException() {
        return new CardValidationException("Error: Card was not issued by a valid payment system!");
    }

}
