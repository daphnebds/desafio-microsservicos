package br.com.desafio.totalshake.pagamento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SpringFoxConfig {

    @Bean
    public Docket api() {

        //http://localhost:8080/swagger-ui/#/pagamento-controller
        var apiInfo = new ApiInfoBuilder()
                .title("MS PAGAMENTO")
                .version("1.0")
                .license(null)
                .licenseUrl(null)
                .termsOfServiceUrl(null)
                .build();

        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}