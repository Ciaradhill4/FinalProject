package com.promineotech.finalproject.controller.support;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import com.promineotech.finalproject.entity.Style;

public class FetchWigTestSupport extends BaseTest {

  protected List<Style> buildExpected() {
    List<Style> list = new LinkedList<>();
  
     return list;
   
   }  
  
  protected void assertErrorMessageValid(Map<String, Object> error, HttpStatus status) {
   
  }
}
