package com.promineotech.finalproject.controller;

import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.finalproject.entity.Style;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

  @Validated
  @RequestMapping("/update")
  @OpenAPIDefinition(info = @Info(title = "Wig Update Service"), servers = 
  {@Server(url = "http://localhost:8080", description = "Local Server.")})


  public interface WigUpdateController {
    
    //@formatter:off
    @Operation(
        summary = " Updates a style",
        description = "Returns the updated style",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "The update is returned", 
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = Style.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameter is invalid", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "A style component was not found with the input criteria", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occured.", 
                content = @Content(
                    mediaType = "application/json"))
        },
        parameters = {
            @Parameter(name = "StyleId",
                allowEmptyValue = false,
                required = false,
                description = "Please enter a style name"),
            @Parameter(name = "basePrice",
                allowEmptyValue = false, 
                required = false, 
                description = "Please enter a price")
        }
      )
    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    Optional<Style> updateStyles(
        @RequestParam(required = false) 
        String newStyleId,
        @RequestParam(required = false) 
        BigDecimal basePrice);
    
     //@formatter:on
  }
  

