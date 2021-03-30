package hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.dto.paymentcard;

public class EmptyCardNumberException extends Exception {

    public EmptyCardNumberException(String message) {
        super(message);
    }

}
