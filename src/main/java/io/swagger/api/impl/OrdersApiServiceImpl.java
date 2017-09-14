package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;
import io.swagger.model.OrderRequest;

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
        OrderOperation.PostOrder(body);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK)).build();
    }
    @Override
    public Response deleteOrderByID(Long orderID, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        OrderOperation.DeleteOrder(orderID);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK)).build();
    }
    @Override
    public Response getOrder(String filter, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        OrderOperation.GetOrdersBase(true, 0xffffffffL);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK)).build();
    }
    @Override
    public Response getOrderById(Long orderID, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        OrderOperation.GetOrdersBase(false, orderID);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK)).build();
    }
    @Override
    public Response updateOrder(Long orderID, OrderRequest body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        OrderOperation.UpdateOderID(orderID, body);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK)).build();
    }
}