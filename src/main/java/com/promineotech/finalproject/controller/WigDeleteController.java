package com.promineotech.finalproject.controller;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
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
  @RequestMapping("/delete")
  @OpenAPIDefinition(info = @Info(title = "Wig Delete Service"), servers = 
  {@Server(url = "http://localhost:8080", description = "Local Server.")})

  public interface WigDeleteController {
    
    //@formatter:off
    @Operation(
        summary = " Deletes a style",
        description = "Deletes a style given a required styleId",
        responses = {
            @ApiResponse(
                responseCode = "202", 
                description = "The style is deleted", 
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
                description = "A style was not found with the input criteria", 
                content = @Content(
                    mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occured.", 
                content = @Content(
                    mediaType = "application/json"))
        },
        parameters = {
            @Parameter(name = "styleId",
                allowEmptyValue = false, 
                required = false, 
                description = "Please enter a style to delete"),
            /*@Parameter(name = "basePrice",
                allowEmptyValue = false, 
                required = false, 
                description = "Please enter a price")*/
        }
    )
        
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.ACCEPTED)
  Optional<Style> deleteStyles(
      @RequestParam(required = false) 
      Style styleId);
      /*@RequestParam(required = false) 
      BigDecimal basePrice);*/
}
