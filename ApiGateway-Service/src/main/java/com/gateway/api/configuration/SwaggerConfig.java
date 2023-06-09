//package com.gateway.api.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.ParameterBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.schema.ModelRef;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Parameter;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//public class SwaggerConfig {
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
//                .apis(RequestHandlerSelectors.basePackage("com.gateway.api.controller")).paths(PathSelectors.any())
//                .build().globalOperationParameters(setHeaderToken());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().title("action-swagger").description("swagger实战").termsOfServiceUrl("")
//                .version("1.0").build();
//    }
//
//    /**
//     * @Description: 设置swagger文档中全局参数
//     * @param
//     * @Date: 2020/9/11 10:15
//     * @return: java.util.List<springfox.documentation.service.Parameter>
//     */
//
//    private List<Parameter> setHeaderToken() {
//        List<Parameter> pars = new ArrayList<>();
//        ParameterBuilder userId = new ParameterBuilder();
//        userId.name("token").description("用户TOKEN").modelRef(new ModelRef("string")).parameterType("header")
//                .required(true).build();
//        pars.add(userId.build());
//        return pars;
//    }
//
//}
