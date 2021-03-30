package io.swagger.api;

import io.swagger.model.PaymentCardInput;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-03-26T15:28:42.066Z[GMT]")
public abstract class ValidationApiService {
    public abstract Response validatePaymentCardNumber(PaymentCardInput body, SecurityContext securityContext) throws NotFoundException;
}
