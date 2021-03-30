package hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.impl;

import hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.dto.paymentcard.EmptyCardNumberException;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.dto.paymentcard.PaymentCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LengthValidatorTest {

    @Test
    void lengthValidator_ShouldReturnTrue_WhenCardNumberIsExactly16Digits() throws EmptyCardNumberException {
        PaymentCard testedCard = new PaymentCard("4187353926971870");
        Assertions.assertTrue(new LengthValidator<>().isValid(testedCard));
    }

    @Test
    void lengthValidator_ShouldReturnFalse_WhenCardNumberIsLongerThan16Digits() throws EmptyCardNumberException {
        PaymentCard testedCard = new PaymentCard("325423542324234544527995");
        Assertions.assertFalse(new LengthValidator<>().isValid(testedCard));
    }

    @Test
    void lengthValidator_ShouldReturnFalse_WhenCardNumberIsShorterThan16Digits() throws EmptyCardNumberException {
        PaymentCard testedCard = new PaymentCard("325423542324");
        Assertions.assertFalse(new LengthValidator<>().isValid(testedCard));
    }
}