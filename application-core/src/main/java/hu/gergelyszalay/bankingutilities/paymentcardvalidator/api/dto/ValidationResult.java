package hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.dto;

import hu.gergelyszalay.bankingutilities.paymentcardvalidator.paymentsystems.PaymentSystems;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.Validatable;

public class ValidationResult implements Validatable {

    private String cardNumber;
    private boolean isValid;
    private PaymentSystems paymentSystem;
    private String validationMessage;

    public ValidationResult(String cardNumber, boolean isValid, String validationMessage) {
        this.cardNumber = cardNumber;
        this.isValid = isValid;
        this.validationMessage = validationMessage;
        this.paymentSystem = PaymentSystems.UNKNOWN;
    }

    public ValidationResult() {
    }

    public String getCardNumber() {
        return cardNumber;
    }

    protected void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Boolean isValid() {
        return isValid;
    }

    @Override
    public void setValidity(boolean value) {
        this.isValid = value;
        this.cardNumber = this.formatCardNumber(this.cardNumber);
        if (this.isValid) setValidationMessage("Payment card with number " + this.cardNumber + " is Valid!");
    }

    public String getValidationMessage() {
        return validationMessage;
    }

    public void setValidationMessage(String validationMessage) {
        this.validationMessage = validationMessage;
    }

    public String getPaymentSystemName() {
        return paymentSystem.getName();
    }

    public void setPaymentSystem(PaymentSystems paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    public String formatCardNumber(String cardNumber) {
        StringBuilder numberBuilder = new StringBuilder(cardNumber);
        int totalLengthWithSpaces = cardNumber.length() + (cardNumber.length() / 4 - 1);
        for (int i = 4; i <= totalLengthWithSpaces; i += 5) {
            numberBuilder.insert(i, ' ');
        }
        return numberBuilder.toString().trim();
    }
}
