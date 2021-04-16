package com.starwars.client.configuration;

import com.starwars.client.controller.DatabaseLoadController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Configuration
public class SpringFoxConfig implements WebMvcConfigurer {


    @Value("${springfox.documentation.swagger.v2.home}")
    private String home;

    @Autowired
    private Docket docket;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage(DatabaseLoadController.class.getPackageName()))
          .paths(PathSelectors.any())
          .build()
          .apiInfo(apiInfo()) ;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        docket.apiInfo(apiInfo());
        registry.addResourceHandler( "swagger-ui.html" ).addResourceLocations( "classpath:/META-INF/resources/" );
        registry.addResourceHandler( "/webjars/**" ).addResourceLocations( "classpath:/META-INF/resources/webjars/" );

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Star wars client")
                .contact(new Contact("Team Developer", null, "teste@gmail.com"))
                .description("APIs responsável por pesquisar as naves do filme star wars")
                .version("1.0")
                .build();
    }



}