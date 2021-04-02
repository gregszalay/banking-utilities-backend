package io.swagger.model.impl;

import hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.dto.ValidationResult;
import io.swagger.model.PaymentCardResult;

public class PaymentCardResultAdapter {

    public PaymentCardResult convert(ValidationResult coreApplicationResult) {

        PaymentCardResult conversionResult = new PaymentCardResult();

        conversionResult.setCardNumber((coreApplicationResult.getCardNumber()));
        conversionResult.setValidationResult(coreApplicationResult.isValid());
        conversionResult.setValidationMessage(coreApplicationResult.getValidationMessage());
        conversionResult.setPaymentSystemName((coreApplicationResult.getPaymentSystemName()));

        return conversionResult;

    }


}
