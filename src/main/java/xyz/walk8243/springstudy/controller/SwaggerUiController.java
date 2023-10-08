package xyz.walk8243.springstudy.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import java.io.IOException;
import java.nio.charset.Charset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Hidden
@RestController
public class SwaggerUiController {

  @Value("classpath:swagger-ui/style.css")
  private Resource stylesheet;

  @GetMapping("/swagger-ui/index.css")
  @Operation(summary = "SwaggerUI CSS", description = "SwaggerUIのCSSを上書きする")
  public String swaggerCss() throws IOException {
    return stylesheet.getContentAsString(Charset.defaultCharset());
  }
}
