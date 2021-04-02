package hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.impl;

import hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.dto.paymentcard.PaymentCard;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.AbstractValidator;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.ValidationException;

public class LuhnValidator<T extends PaymentCard> extends AbstractValidator<PaymentCard> {

    @Override
    protected boolean isValid(PaymentCard card) {
        if (card == null) throw new IllegalArgumentException("Card must not be null!");

        String cardNumber = card.getCardNumber();
        String lastDigit = String.valueOf(cardNumber.charAt(cardNumber.length() - 1));
        byte checkDigit = (byte) Short.parseShort(lastDigit);
        short sum = 0;

        for (int i = cardNumber.length() - 2; i >= 0; i--) {
            short digit = Short.parseShort(String.valueOf(cardNumber.charAt(i)));
            digit = (short) ((i % 2 == 0) ? digit * 2 : digit);
            sum += (digit > 9) ? digit - 9 : digit;
        }

        return (sum + checkDigit) % 10 == 0;

    }

    @Override
    protected ValidationException makeSpecificValidationException() {
        return new CardValidationException("Error: Card number and Luhn check digit do not match!");
    }

}
