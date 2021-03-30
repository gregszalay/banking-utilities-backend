package hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.dto.paymentcard;

import hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.dto.ValidationResult;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.Validatable;

public class PaymentCard extends ValidationResult implements Validatable {

    public PaymentCard(String cardNumber) {
        if (cardNumber == null) throw new IllegalArgumentException("Card number must not be null!");
        String cleanCardNumber = cardNumber.trim().replaceAll("[ ]+", "");
        if (cleanCardNumber.isEmpty()) throw new IllegalArgumentException("Card number must not be empty!");
        this.setCardNumber(cleanCardNumber);
    }

}
