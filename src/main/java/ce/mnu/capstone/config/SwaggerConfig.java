package ce.mnu.capstone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Server;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
//@EnableWebMvc
public class SwaggerConfig {

    private static final String API_NAME = "Capstone API Document";
    private static final String API_VERSION = "1,0.0";
    private static final String API_DESCRIPTION = "목포대학교 집중해줄래 팀 API 문서 <br> " +
            "상태 코드 참고 : <a href='http://www.incodom.kr/Status_code' target='_blank'>" +
            "http://www.incodom.kr/Status_code</a>";

    @Bean
    public Docket FrontApI() {
        return new Docket(DocumentationType.OAS_30) // 문서 타입
                .groupName("FrontEnd API Document")
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ce.mnu.capstone.controller.frontend"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
    @Bean
    public Docket DeepApI() {
        return new Docket(DocumentationType.OAS_30) // 문서 타입
                .groupName("DeepLearning API Document")
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ce.mnu.capstone.controller.deeplearning"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(API_NAME)
                .description(API_DESCRIPTION)
                .version(API_VERSION)
                .build();
    }
}
