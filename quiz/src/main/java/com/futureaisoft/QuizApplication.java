package com.futureaisoft;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;

@SpringBootApplication
public class QuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}

//
//	final String securitySchemeName = "bearerAuth";
//	final String apiTitle = String.format("%s API", StringUtils.capitalize(moduleName));
//	@Bean
//	public OpenAPI customOpenAPI(@Value("Question and Answer API") String appDesciption, @Value("v1") String appVersion) {
//		return new OpenAPI()
//				.addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
//				.components(
//						new Components()
//								.addSecuritySchemes(securitySchemeName,
//										new SecurityScheme()
//												.name(securitySchemeName)
//												.type(SecurityScheme.Type.HTTP)
//												.scheme("bearer")
//												.bearerFormat("JWT")
//								)
//				)
//				.info(new Info()
//						.title("FutureAiSoft QnA API")
//						.version(appVersion)
//						.description(appDesciption)
//						.termsOfService("http://swagger.io/terms/")
//						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
//
//	}
}
