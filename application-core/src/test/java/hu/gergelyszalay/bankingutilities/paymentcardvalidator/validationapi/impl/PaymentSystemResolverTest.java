package hu.gergelyszalay.bankingutilities.paymentcardvalidator.validationapi.impl;

import hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.dto.paymentcard.EmptyCardNumberException;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.dto.paymentcard.PaymentCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class PaymentSystemResolverTest {

    @Test
    void paymentSystemResolver_ShouldReturnTrue_WhenCardNumberMatchesValidPaymentSystem() throws EmptyCardNumberException {
        PaymentCard testedCard = new PaymentCard("6227566243791351");
        Assertions.assertTrue(new PaymentSystemResolver<>().isValid(testedCard));
    }

    @Test
    void paymentSystemResolver_ShouldReturnFalse_WhenCardNumberDoesNotMatchValidPaymentSystem() throws EmptyCardNumberException {
        PaymentCard testedCard = new PaymentCard("1111171513999106");
        Assertions.assertFalse(new PaymentSystemResolver<>().isValid(testedCard));
    }

}
