package com.restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by kerns on 2017/3/23.
 */
@ComponentScan("com.restapi.controller")
@Configuration
@EnableSwagger2
@EnableWebMvc
public class RestApiConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.restapi.controller")).paths(PathSelectors.any()).build();
    }

    @Bean
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("spring 中使用swagger2构建RESTFUL APIS").termsOfServiceUrl("http://blog.csdn.net/he90227").contact("逍遥飞鹤").version("1.1").build();
    }
}
