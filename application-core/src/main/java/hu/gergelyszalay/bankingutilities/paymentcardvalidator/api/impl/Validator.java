package hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.impl;

import hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.ValidatorApi;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.dto.ValidationResult;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.dto.paymentcard.PaymentCard;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.ValidationChain;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.impl.CharacterValidator;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.impl.LengthValidator;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.impl.LuhnValidator;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.impl.PaymentSystemResolver;

public class Validator implements ValidatorApi {

    private static final ValidationChain<PaymentCard> cardValidationChain = new ValidationChain<>(
            new CharacterValidator<>(),
            new LengthValidator<>(),
            new PaymentSystemResolver<>(),
            new LuhnValidator<>()
    );

    public ValidationResult validate(String cardNumber) {
        try {
            PaymentCard inputCard = new PaymentCard(cardNumber);
            cardValidationChain.startValidation(inputCard);
            return inputCard;
        } catch (Exception exception) {
            return new ValidationResult(cardNumber, false, exception.getMessage());
        }

    }

}
