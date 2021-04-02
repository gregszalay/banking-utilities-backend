package io.swagger.api.factories;

import io.swagger.api.MortgagecalculatorApiService;
import io.swagger.api.impl.MortgagecalculatorApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-03-17T19:17:55.414Z[GMT]")
public class MortgagecalculatorApiServiceFactory {
    private final static MortgagecalculatorApiService service = new MortgagecalculatorApiServiceImpl();

    public static MortgagecalculatorApiService getMortgagecalculatorApi() {
        return service;
    }
}
