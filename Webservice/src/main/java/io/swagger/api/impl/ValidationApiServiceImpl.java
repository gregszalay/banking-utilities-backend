package io.swagger.api.impl;

import hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.ValidatorApi;
import hu.gergelyszalay.bankingutilities.paymentcardvalidator.api.dto.ValidationResult;
import io.swagger.api.NotFoundException;
import io.swagger.api.ValidationApiService;
import io.swagger.model.PaymentCardInput;
import io.swagger.model.PaymentCardResult;
import io.swagger.model.impl.PaymentCardResultAdapter;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-03-17T19:17:55.414Z[GMT]")
public class ValidationApiServiceImpl extends ValidationApiService {
    @Override
    public Response validatePaymentCardNumber(PaymentCardInput body, SecurityContext securityContext) throws NotFoundException {

        String cardNumber = body.getCardNumber();

        ValidationResult validationResult = new ValidatorApi() {
        }.validate(body.getCardNumber());

        PaymentCardResult restWebResult = new PaymentCardResult();
        restWebResult = new PaymentCardResultAdapter().convert(validationResult);

        return Response.status(200).entity(restWebResult).build();

    }
}
