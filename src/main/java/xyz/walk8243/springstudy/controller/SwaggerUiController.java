package xyz.walk8243.springstudy.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Hidden
@RestController
@RequiredArgsConstructor
public class SwaggerUiController {

  private final Resource swaggerUiStylesheet;

  @GetMapping(
      value = "/swagger-ui/index.css",
      produces = {"text/css"})
  @Operation(summary = "SwaggerUI CSS", description = "SwaggerUIのCSSを上書きする")
  public String swaggerCss() {
    if (Objects.isNull(swaggerUiStylesheet)) {
      return "";
    }

    try {
      return swaggerUiStylesheet.getContentAsString(Charset.defaultCharset());
    } catch (IOException e) {
      return "";
    }
  }
}
