package hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi;

public abstract class AbstractValidator<T extends Validatable> {

    protected AbstractValidator<T> successor;

    protected void setSuccessor(AbstractValidator<T> successor) {
        if (successor == null) throw new IllegalArgumentException("Successor validator cannot be set to null!");
        this.successor = successor;
    }

    public void handleValidationRequest(T validatableObject) throws ValidationException {
        if (validatableObject == null) throw new IllegalArgumentException("Validatable object must not be null!");

        if (isValid(validatableObject)) {
            if (this.successor != null) {
                this.successor.handleValidationRequest(validatableObject);
            } else {
                validatableObject.setValidity(true);
            }
        } else {
            throw makeSpecificValidationException();
        }
    }

    protected abstract ValidationException makeSpecificValidationException();

    protected abstract boolean isValid(T validatableObject);

}
