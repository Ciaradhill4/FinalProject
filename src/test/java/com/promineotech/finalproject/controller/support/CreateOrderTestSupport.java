package com.promineotech.finalproject.controller.support;

public class CreateOrderTestSupport extends BaseTest {

  protected String createOrderBody() {
    // @formatter:off
    return "{\n"
        + "  \"customer\":\"CHRISTINE_JINKINS\",\n"
        + "  \"style\":\"BOB\",\n"
        + "  \"color\":\"ONE\",\n"
        + "  \"texture\":\"YAKI\",\n"
        + "  \"length\":\"12_INCHES\",\n"
        + "}";
    // @formatter:on    
  }
}
