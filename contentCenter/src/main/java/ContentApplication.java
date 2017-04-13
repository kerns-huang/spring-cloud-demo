import com.content.controller.NewsController;
import com.content.repository.NewsRepository;
import com.google.common.base.Predicate;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by kerns on 2017/4/12.
 */
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {
        "com.content"
})
public class ContentApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(ContentApplication.class, args);
    }

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("news-api")//组api
                .apiInfo(apiInfo())
                .select()
                .paths(testPaths())
                .build();
    }

    private Predicate<String> testPaths() {
        return or(regex("/news.*"));
    }

    /**
     * api信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("內容中心")
                .description("用ElasticSearch实现，主要用于数据量大，又需要分页的数据，相对于mysql，在这分页比较有优势")
                .version("2.0")
                .build();
    }
}
