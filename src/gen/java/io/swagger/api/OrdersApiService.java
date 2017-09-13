package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.OrderRequest;
import io.swagger.model.OrderResponse;
import io.swagger.model.ResponseOrderCollection;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-06T07:33:29.605Z")
public abstract class OrdersApiService {
    public abstract Response addOrder(OrderRequest body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteOrderByID(Long orderID,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getOrder(String filter,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getOrderById(Long orderID,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateOrder(Long orderID,OrderRequest body,SecurityContext securityContext) throws NotFoundException;
}
