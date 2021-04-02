package io.swagger.api;

import io.swagger.api.factories.ValidationApiServiceFactory;
import io.swagger.model.PaymentCardInput;
import io.swagger.model.PaymentCardResult;
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


@Path("/validation")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-03-26T15:28:42.066Z[GMT]")
public class ValidationApi {
    private final ValidationApiService delegate;

    public ValidationApi(@Context ServletConfig servletContext) {
        ValidationApiService delegate = null;

        if (servletContext != null) {
            String implClass = servletContext.getInitParameter("ValidationApi.implementation");
            if (implClass != null && !"".equals(implClass.trim())) {
                try {
                    delegate = (ValidationApiService) Class.forName(implClass).newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (delegate == null) {
            delegate = ValidationApiServiceFactory.getValidationApi();
        }

        this.delegate = delegate;
    }

    @POST

    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Operation(summary = "Validate a payment card number", description = "", tags = {"paymentcardvalidator"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Valid Payment Card Number", content = @Content(schema = @Schema(implementation = PaymentCardResult.class))),

            @ApiResponse(responseCode = "400", description = "Invalid Payment Card Number", content = @Content(schema = @Schema(implementation = PaymentCardResult.class)))})
    public Response validatePaymentCardNumber(@Parameter(in = ParameterIn.DEFAULT, description = "payment card number sent for validation", required = true) PaymentCardInput body

            , @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.validatePaymentCardNumber(body, securityContext);
    }
}
