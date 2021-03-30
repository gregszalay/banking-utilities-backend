package io.swagger.api.impl;

import hu.gergelyszalay.bankingutilities.mortgagecalculator.api.MortgageCalculatorApi;
import hu.gergelyszalay.bankingutilities.mortgagecalculator.api.dto.MortgageInput;
import hu.gergelyszalay.bankingutilities.mortgagecalculator.api.dto.MortgageResult;
import io.swagger.api.MortgagecalculatorApiService;
import io.swagger.api.NotFoundException;
import io.swagger.model.impl.MortgageInputAdapter;
import io.swagger.model.impl.MortgageResultAdapter;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-03-17T19:17:55.414Z[GMT]")
public class MortgagecalculatorApiServiceImpl extends MortgagecalculatorApiService {
    @Override
    public Response calculateMortgageMonthlyPayment(io.swagger.model.MortgageInput body, SecurityContext securityContext) throws NotFoundException {

        MortgageInput coreApplicationInput = new MortgageInputAdapter().convert(body);
        MortgageResult coreApplicationResult = new MortgageCalculatorApi() {
        }.calculatePayment(coreApplicationInput);

        io.swagger.model.MortgageCalculatorResult restWebResult = new MortgageResultAdapter().convert(coreApplicationResult);

        if (restWebResult.getMortgageMonthlyPayment() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity(restWebResult).build();
        }

        return Response.status(Response.Status.ACCEPTED).entity(restWebResult).build();
    }
}
