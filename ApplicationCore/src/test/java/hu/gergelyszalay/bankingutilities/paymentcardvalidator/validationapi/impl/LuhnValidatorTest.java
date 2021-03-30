package hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.impl;

import hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.dto.paymentcard.EmptyCardNumberException;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.dto.paymentcard.PaymentCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LuhnValidatorTest {

    @Test
    void luhnValidator_ShouldReturnTrue_WhenLastDigitMatchesLuhnAlgorithm() throws EmptyCardNumberException {
        PaymentCard testedCard = new PaymentCard("3562399090269796");
        Assertions.assertTrue(new LuhnValidator<>().isValid(testedCard));
    }

    @Test
    void luhnValidator_ShouldReturnFalse_WhenLastDigitDoesNotMatchLuhnAlgorithm() throws EmptyCardNumberException {
        PaymentCard testedCard = new PaymentCard("3562399090269795");
        Assertions.assertFalse(new LuhnValidator<>().isValid(testedCard));
    }

}