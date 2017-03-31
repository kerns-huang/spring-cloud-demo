package com.restapi.main;

import com.google.common.base.Predicate;
import com.restapi.controller.TestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.AuthorizationScopeBuilder;
import springfox.documentation.builders.ImplicitGrantBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.petstore.controller.PetController;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Predicates.or;
import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.ant;
import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableSwagger2 //Enable swagger 2.0 spec
@ComponentScan(basePackageClasses = {
        PetController.class,
        TestController.class
})
public class Application {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
    }

    /**
     * api说明书
     *
     * @return
     */
    @Bean
    public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("full-petstore-api")//组api
                .apiInfo(apiInfo())
                .select()
                .paths(petstorePaths())
                .build()
                .securitySchemes(newArrayList(oauth()))
                .securityContexts(newArrayList(securityContext()));
    }
    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("test-api")//组api
                .apiInfo(apiInfo())
                .select()
                .paths(testPaths())
                .build()
                .securitySchemes(newArrayList(oauth()))
                .securityContexts(newArrayList(securityContext()));
    }

    @Bean
    public Docket userApi() {
        AuthorizationScope[] authScopes = new AuthorizationScope[1];
        authScopes[0] = new AuthorizationScopeBuilder()
                .scope("read")
                .description("read access")
                .build();
        SecurityReference securityReference = SecurityReference.builder()
                .reference("test")
                .scopes(authScopes)
                .build();
        ArrayList<SecurityContext> securityContexts = newArrayList(SecurityContext.builder().securityReferences
                (newArrayList(securityReference)).build());
        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(newArrayList(new BasicAuth("test")))
                .securityContexts(securityContexts)
                .groupName("user-api")
                .apiInfo(apiInfo())
                .select()
                .paths(userOnlyEndpoints())
                .build();
    }

    private Predicate<String> petstorePaths() {
        return or(
                regex("/api/pet.*"),
                regex("/api/user.*"),
                regex("/api/store.*")
        );
    }

    private Predicate<String> testPaths() {
        return or(regex("/test.*"));
    }

    private Predicate<String> userOnlyEndpoints() {
        return new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.contains("user");
            }
        };
    }

    /**
     * api信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Springfox petstore API")
                .description("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum " +
                        "has been the industry's standard dummy text ever since the 1500s, when an unknown printer "
                        + "took a " +
                        "galley of type and scrambled it to make a type specimen book. It has survived not only five " +
                        "centuries, but also the leap into electronic typesetting, remaining essentially unchanged. " +
                        "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum " +
                        "passages, and more recently with desktop publishing software like Aldus PageMaker including " +
                        "versions of Lorem Ipsum.")
                .termsOfServiceUrl("http://springfox.io")
                .contact("springfox")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
                .version("2.0")
                .build();
    }

    @Bean
    SecurityContext securityContext() {
        AuthorizationScope readScope = new AuthorizationScope("read:pets", "read your pets");
        AuthorizationScope[] scopes = new AuthorizationScope[1];
        scopes[0] = readScope;
        SecurityReference securityReference = SecurityReference.builder()
                .reference("petstore_auth")
                .scopes(scopes)
                .build();

        return SecurityContext.builder()
                .securityReferences(newArrayList(securityReference))
                .forPaths(ant("/api/pet.*"))
                .build();
    }

    @Bean
    SecurityScheme oauth() {
        return new OAuthBuilder()
                .name("petstore_auth")
                .grantTypes(grantTypes())
                .scopes(scopes())
                .build();
    }

    @Bean
    SecurityScheme apiKey() {
        return new ApiKey("api_key", "api_key", "header");
    }

    List<AuthorizationScope> scopes() {
        return newArrayList(
                new AuthorizationScope("write:pets", "modify pets in your account"),
                new AuthorizationScope("read:pets", "read your pets"));
    }

    List<GrantType> grantTypes() {
        GrantType grantType = new ImplicitGrantBuilder()
                .loginEndpoint(new LoginEndpoint("http://petstore.swagger.io/api/oauth/dialog"))
                .build();
        return newArrayList(grantType);
    }

    @Bean
    public SecurityConfiguration securityInfo() {
        return new SecurityConfiguration("abc", "123", "pets", "petstore", "123", ApiKeyVehicle.HEADER, "", ",");
    }
}