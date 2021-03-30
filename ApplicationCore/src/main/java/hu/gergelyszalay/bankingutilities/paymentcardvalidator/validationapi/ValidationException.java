package hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi;

public abstract class ValidationException extends Exception {

    public ValidationException(String message) {
        super(message);
    }

}
