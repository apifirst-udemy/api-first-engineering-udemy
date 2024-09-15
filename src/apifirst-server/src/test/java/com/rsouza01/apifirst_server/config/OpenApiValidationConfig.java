package com.rsouza01.apifirst_server.config;

import com.atlassian.oai.validator.OpenApiInteractionValidator;
import com.atlassian.oai.validator.springmvc.OpenApiValidationFilter;
import com.atlassian.oai.validator.springmvc.OpenApiValidationInterceptor;
import jakarta.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class OpenApiValidationConfig {

    @Bean
    public Filter validationFilter() {

        return new OpenApiValidationFilter(
                true, // enable request validation
                true // enable response validation
        );
    }

    @Bean
    public WebMvcConfigurer openAPIValidationInterceptor() {

        OpenApiInteractionValidator validator = OpenApiInteractionValidator
                .createForSpecificationUrl(
                        "https://raw.githubusercontent.com/apifirst-udemy/api-first-openapi/main/dist/bundle.yaml")
                .build();

        OpenApiValidationInterceptor interceptor = new OpenApiValidationInterceptor(validator);

        return new WebMvcConfigurer() {

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(interceptor);
            }
        };
    }

}
