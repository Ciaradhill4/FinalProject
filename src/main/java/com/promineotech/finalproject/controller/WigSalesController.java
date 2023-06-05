 package com.promineotech.finalproject.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.finalproject.entity.Styles;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/wstyle")
@OpenAPIDefinition(info = @Info(title = "Wig Sales Service"), servers = 
{@Server(url = "http://localhost:8080", description = "Local Server.")})


public interface WigSalesController {
  
  //@formatter:off
  @Operation(
      summary = "Returns a style",
      description = "Returns a style given an optional style",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of wig styles is returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Styles.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameter is invalid", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No wig styles were found with the input criteria", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured.", 
              content = @Content(
                  mediaType = "application/json"))
      },
      parameters = {
          @Parameter(name = "stylePK", 
              allowEmptyValue = false, 
              required = false, 
              description = "Enter a style"),
      }
    )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Styles>fetchStyles(
      @RequestParam(required = false) 
      Long stylePK);
   //@formatter:on
}
