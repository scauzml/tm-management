package com.springboot.mybatisplus.util.swagger;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author{张明亮} 2018/12/22 18:15
 */
@Configuration
@EnableSwagger2

public class SwaggerConfiguration {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
         .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //.apis(RequestHandlerSelectors.basePackage("com.springboot.mybatisplus"))
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {
        //http://localhost:8080/swagger-ui.html
        return new ApiInfoBuilder()
                .title("张明亮")
                .description("----------接口文档----------")
                .termsOfServiceUrl("www.mistra.wang")
                .contact(new Contact("WangRui", "", ""))
                .version("1.0")
                .build();
    }

}
