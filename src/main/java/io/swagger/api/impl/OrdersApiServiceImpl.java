package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import java.sql.*;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-06T07:33:29.605Z")
public class OrdersApiServiceImpl extends OrdersApiService {
    String type;
    
    @Override
    public Response addOrder(OrderRequest body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        PostOrder post = new PostOrder(body);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "addOrder!")).build();
    }
    @Override
    public Response deleteOrderByID(Long orderID, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        DeleteOrder del = new DeleteOrder(orderID);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "deleteOrderByID!")).build();
    }
    @Override
    public Response getOrder(String filter, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        GetOrdersBase Orders = new GetOrdersBase(true, 0xffffffffL);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "getOrder!")).build();
    }
    @Override
    public Response getOrderById(Long orderID, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        GetOrdersBase OrderById = new GetOrdersBase(false, orderID);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "getOrderById!")).build();
    }
    @Override
    public Response updateOrder(Long orderID, OrderRequest body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "updateOrder!")).build();
    }
}