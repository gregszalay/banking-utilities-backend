package hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi;

public interface Validatable {
    Boolean isValid();

    void setValidity(boolean value);
}
