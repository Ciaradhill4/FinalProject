package com.promineotech.finalproject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.finalproject.entity.Style;
import com.promineotech.finalproject.entity.WigStyle;
import com.promineotech.finalproject.service.WigSalesService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultWigSalesController implements WigSalesController {

  @Autowired
  private WigSalesService wigSalesService;
  
  @Override
  public List<Style>fetchStyles(WigStyle style) {
    log.debug("style={}", style);
    return wigSalesService.fetchStyles(style);
  }
}
