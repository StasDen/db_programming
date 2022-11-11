package ua.lviv.iot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
    private static final String SWAGGER_API_VERSION = "1.0";
    private static final String LICENSE = "Project license";
    private static final String PROJECT_TITLE = "Spring Start Boot by stasden";
    private static final String PROJECT_DESC = "Information about the project";

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(PROJECT_TITLE).description(PROJECT_DESC).license(LICENSE).version(SWAGGER_API_VERSION).build();
    }

    @Bean
    public Docket decksInfo() {
        return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo()).pathMapping("/").select().paths(PathSelectors.any()).build();
    }
}
