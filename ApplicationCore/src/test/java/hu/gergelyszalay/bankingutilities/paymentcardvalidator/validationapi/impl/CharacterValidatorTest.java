package hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.impl;

import hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.dto.paymentcard.EmptyCardNumberException;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.dto.paymentcard.PaymentCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CharacterValidatorTest {

    @Test
    void characterValidator_ShouldReturnTrue_WhenPaymentCardNumberOnlyContainsDigits() throws EmptyCardNumberException {
        PaymentCard testedCard = new PaymentCard("3562399090269796");
        Assertions.assertTrue(new CharacterValidator<>().isValid(testedCard));
    }

    @Test
    void characterValidator_ShouldReturnFalse_WhenPaymentCardNumberContainsNotOnlyDigits() throws EmptyCardNumberException {
        PaymentCard testedCard = new PaymentCard("235423*423452354");
        Assertions.assertFalse(new CharacterValidator<>().isValid(testedCard));
    }

}