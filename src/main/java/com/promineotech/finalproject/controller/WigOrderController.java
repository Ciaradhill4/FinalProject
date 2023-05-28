package com.promineotech.finalproject.controller;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.finalproject.entity.OrderRequest;
import com.promineotech.finalproject.entity.Orders;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/order")
@OpenAPIDefinition(info = @Info(title = "Wig Order Service"), servers = 
{@Server(url = "http://localhost:8080", description = "Local Server.")})


public interface WigOrderController {
  
  //@formatter:off
  @Operation(
      summary = " Create an order for a Wig",
      description = "Returns the created Wig",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "The Wig is returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Orders.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameter is invalid", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "A Wig component was not found with the input criteria", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured.", 
              content = @Content(
                  mediaType = "application/json"))
      },
      parameters = {
          @Parameter(name = "orderRequest",
              allowEmptyValue = false, 
              required = false, 
              description = "Please place an order")
      }
    )
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Orders createOrder(@Valid @RequestBody OrderRequest orderRequest);
 // @RequestParam(required = false) 
  //WigStyle style);
   //@formatter:on
}
