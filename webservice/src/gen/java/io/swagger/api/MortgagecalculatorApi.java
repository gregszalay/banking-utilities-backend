package io.swagger.api;

import io.swagger.api.factories.MortgagecalculatorApiServiceFactory;
import io.swagger.model.MortgageCalculatorResult;
import io.swagger.model.MortgageInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import javax.servlet.ServletConfig;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;


@Path("/mortgagecalculator")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-03-26T15:28:42.066Z[GMT]")
public class MortgagecalculatorApi {
    private final MortgagecalculatorApiService delegate;

    public MortgagecalculatorApi(@Context ServletConfig servletContext) {
        MortgagecalculatorApiService delegate = null;

        if (servletContext != null) {
            String implClass = servletContext.getInitParameter("MortgagecalculatorApi.implementation");
            if (implClass != null && !"".equals(implClass.trim())) {
                try {
                    delegate = (MortgagecalculatorApiService) Class.forName(implClass).newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (delegate == null) {
            delegate = MortgagecalculatorApiServiceFactory.getMortgagecalculatorApi();
        }

        this.delegate = delegate;
    }

    @POST

    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Operation(summary = "Calculates monthly payments for a given mortgage", description = "", tags = {"mortgagecalculator"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful morgage payment calculation", content = @Content(schema = @Schema(implementation = MortgageCalculatorResult.class))),

            @ApiResponse(responseCode = "400", description = "Unsuccessful morgage payment calculation", content = @Content(schema = @Schema(implementation = MortgageCalculatorResult.class)))})
    public Response calculateMortgageMonthlyPayment(@Parameter(in = ParameterIn.DEFAULT, description = "Mortgage details sent for calculation of monthly payment", required = true) MortgageInput body

            , @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.calculateMortgageMonthlyPayment(body, securityContext);
    }
}
