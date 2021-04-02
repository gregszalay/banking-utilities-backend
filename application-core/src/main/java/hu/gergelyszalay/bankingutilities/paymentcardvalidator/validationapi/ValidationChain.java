package hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi;

public class ValidationChain<T extends Validatable> {

    private final AbstractValidator<T> rootValidator;

    @SafeVarargs
    public ValidationChain(AbstractValidator<T> rootValidator, AbstractValidator<T>... successorValidators) {
        if (rootValidator == null) throw new IllegalArgumentException("Root rootValidator must not be null!");
        this.rootValidator = rootValidator;
        buildChain(successorValidators);
    }

    private void buildChain(AbstractValidator<T>[] successorValidators) {
        if (successorValidators != null && successorValidators.length != 0) {
            this.rootValidator.setSuccessor(successorValidators[0]);
            for (int i = 0; i < successorValidators.length - 1; i++) {
                successorValidators[i].setSuccessor(successorValidators[i + 1]);
            }
        }
    }

    public void startValidation(T validatable) throws ValidationException {
        rootValidator.handleValidationRequest(validatable);
    }
}
