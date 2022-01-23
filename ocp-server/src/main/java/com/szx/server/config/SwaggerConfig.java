package com.szx.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger 的配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // 规定扫描那些包来生成文档
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)  // 文档类型
                .apiInfo(apiInfo())
                .select()
                // 扫描路径
                .apis(RequestHandlerSelectors.basePackage("com.szx.server.controller"))
                // 全部内容
                .paths(PathSelectors.any())
                .build()
                .securityContexts(securityContexts())
                .securitySchemes(securitySchemes());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Ocp 接口文档")
                .description("主要包含controller包下的api")
                .contact(new Contact("szx", "http://localhost:8081/doc.html", "sunzhangxun@outlook.com"))
                .version("1.0.0")
                .build();
    }

    private List<ApiKey> securitySchemes() {
        // 请求头信息
        List<ApiKey> res = new ArrayList<>();
        ApiKey apiKey = new ApiKey("Authorization", "Authorization", "Header");
        res.add(apiKey);
        return res;
    }

    private List<SecurityContext> securityContexts() {
        // 设置需要认证的路径
        List<SecurityContext> res = new ArrayList<>();
        res.add(getContextByPath("/test/.*"));
        return res;
    }

    private SecurityContext getContextByPath(String regexPath) {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex(regexPath))
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        List<SecurityReference> res = new ArrayList<>();
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = new AuthorizationScope("global", "Global access");;
        res.add(new SecurityReference("Authentication", authorizationScopes));
        return res;
    }

}
