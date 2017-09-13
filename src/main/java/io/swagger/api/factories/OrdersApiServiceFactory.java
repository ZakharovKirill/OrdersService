package io.swagger.api.factories;

import io.swagger.api.OrdersApiService;
import io.swagger.api.impl.OrdersApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-06T07:33:29.605Z")
public class OrdersApiServiceFactory {
    private final static OrdersApiService service = new OrdersApiServiceImpl();

    public static OrdersApiService getOrdersApi() {
        return service;
    }
}
