package xyz.walk8243.springstudy.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
