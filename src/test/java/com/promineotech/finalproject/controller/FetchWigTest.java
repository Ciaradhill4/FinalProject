package com.promineotech.finalproject.controller;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import com.promineotech.finalproject.controller.support.FetchWigTestSupport;


class FetchWigTest {

  
  class TestsThatDoNotPollteTheApplicationContext extends FetchWigTestSupport {
    
    void testThatWigsAreReturnedWhenAValidWigStyleIsSelected() {
      // Given: a valid wig style and URI
      

      // When: a connection is made to URI
      

      // Then: a success(OK-200) status code is returned
      

      // And the actual list is the same as the expected list
      
    }


    @ParameterizedTest
    @MethodSource("com.promineotech.finalproject.controller.FetchWigTest#paramatersForUnknownInput")
    void testThatAnErrorMessageIsReturnedWhenAnUnknownWigIsSupplied() {

      
      // Given: a valid wig style and URI

     
      // When: a connection is made to URI
      
      // Then: a not found (404) status code is returned
      
      // And: an error message is returned
    }



    @ParameterizedTest
    @MethodSource("com.promineotech.finalproject.controller.FetchWigTest#paramatersForInvalidInput")
    void testThatAnErrorMessageIsReturnedWhenAnInvalidWigIsSupplied(String style, String reason) {

      // Given: a valid wig style and URI

      // When: a connection is made to URI

      // Then: a not found (404) status code is returned

      // And: an error message is returned
    
    }
   }

  }
