package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.OrdersApiService;
import io.swagger.api.factories.OrdersApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.OrderRequest;
import io.swagger.model.OrderResponse;
import io.swagger.model.ResponseOrderCollection;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/orders")


@io.swagger.annotations.Api(description = "the orders API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-06T07:33:29.605Z")
public class OrdersApi  {
   private final OrdersApiService delegate = OrdersApiServiceFactory.getOrdersApi();

    @POST
    
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "Add a new order to the OrderList", notes = "", response = void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "basicAuth")
    }, tags={ "order", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Ok", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input", response = void.class) })
    public Response addOrder(@ApiParam(value = "Order object that needs to be added to the OrderList" ,required=true) OrderRequest body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addOrder(body,securityContext);
    }
    @DELETE
    @Path("/{orderID}")
    
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "Deletes order by ID", notes = "", response = void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "basicAuth")
    }, tags={ "order", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Ok", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Order not found", response = void.class) })
    public Response deleteOrderByID(@ApiParam(value = "Order id to delete",required=true) @PathParam("orderID") Long orderID
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteOrderByID(orderID,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "Find order", notes = "Returns a single order", response = ResponseOrderCollection.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "basicAuth")
    }, tags={ "order", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = ResponseOrderCollection.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied", response = ResponseOrderCollection.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = ResponseOrderCollection.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Order not found", response = ResponseOrderCollection.class) })
    public Response getOrder(@ApiParam(value = "Filters description",required=true) @PathParam("Filter") String filter
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getOrder(filter,securityContext);
    }
    @GET
    @Path("/{orderID}")
    
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "Find order by ID", notes = "Returns a single order", response = OrderResponse.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "basicAuth")
    }, tags={ "order", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = OrderResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied", response = OrderResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = OrderResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Order not found", response = OrderResponse.class) })
    public Response getOrderById(@ApiParam(value = "ID of order to return",required=true) @PathParam("orderID") Long orderID
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getOrderById(orderID,securityContext);
    }
    @PUT
    @Path("/{orderID}")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "Update an existing order", notes = "", response = void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "basicAuth")
    }, tags={ "order", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Order not found", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 405, message = "Validation exception", response = void.class) })
    public Response updateOrder(@ApiParam(value = "ID of order to return",required=true) @PathParam("orderID") Long orderID
,@ApiParam(value = "Order object that needs to be updated to the OrderList" ,required=true) OrderRequest body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateOrder(orderID,body,securityContext);
    }
}
