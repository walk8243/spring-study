package xyz.walk8243.springstudy.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import java.io.IOException;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import xyz.walk8243.springstudy.model.constant.Environment;

@Slf4j
@Configuration
public class SwaggerConfiguration {

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI()
        .info(
            new Info()
                .title("Spring Study")
                .description("SpringBootの学習用")
                .version("v0.0.1")
                .license(
                    new License()
                        .name("The MIT License")
                        .identifier("MIT")
                        .url("https://github.com/walk8243/spring-study/blob/main/LICENSE")))
        .externalDocs(
            new ExternalDocumentation()
                .description("GitHub")
                .url("https://github.com/walk8243/spring-study"));
  }

  @Bean
  @Nullable public Resource swaggerUiStylesheet(@Nonnull ApplicationContext ctx, @Nullable Environment env)
      throws IOException {
    if (Objects.nonNull(env)) {
      final Resource envResource =
          ctx.getResource("classpath:swagger-ui/style_%s.css".formatted(env.getShortName()));
      if (envResource.exists()) {
        log.debug("SwaggerUIのCSSに{}を使います", envResource.getFilename());
        return envResource;
      }
    }

    final Resource baseResource = ctx.getResource("classpath:swagger-ui/style.css");
    if (baseResource.exists()) {
      log.debug("SwaggerUIのCSSは共通のものを使います");
      return baseResource;
    }

    for (Resource resource :
        ctx.getResources("classpath:/META-INF/resources/webjars/swagger-ui/*/index.css")) {
      if (resource.exists()) {
        log.debug("SwaggerUIのCSSはライブラリのものを使います");
        return resource;
      }
    }
    return new UrlResource("");
  }
}
