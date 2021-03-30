package io.swagger.api;

import io.swagger.model.MortgageInput;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-03-26T15:28:42.066Z[GMT]")
public abstract class MortgagecalculatorApiService {
    public abstract Response calculateMortgageMonthlyPayment(MortgageInput body, SecurityContext securityContext) throws NotFoundException;
}
