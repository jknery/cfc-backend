package br.com.carrefour.cfc.configurtions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
	ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("CFC-BACKEND")
            .description("API REST - CONTROLE DE FLUXO DE CAIXA E CONSOLIDAÇÕES")
            .version("1.0.0")
            .contact(buildContact())
            .build();
    }
	
	private Contact buildContact() {
		return new Contact("JOSÉ IVO KOERICH NERY","...", "joseivokoerichnery@gmail.com");
	}

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("br.com.carrefour.cfc.endpoints"))
                    .build()
                .apiInfo(apiInfo());
    }
}
