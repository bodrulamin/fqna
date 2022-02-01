package com.futureaisoft.openapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.Servers;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

@Configuration
@OpenAPIDefinition(

        servers = {
                @Server(url = "http://localhost:9002"),
                @Server(url = "http://futureaisoft.com:9002")
        },
        tags = {
                @Tag(name = "question-controller"),
                @Tag(name = "answer-controller"),
        },


        info = @Info(
                title = "Question and Answer API",
                version = "v1",

                license = @License(
                        url = "http://localhost:9002/oauth2/authorize/google?redirect_uri=http://localhost:3000/oauth2/redirect",
                        name = "Get Token"

                ),
                contact = @Contact(
                        name = "futureaisoft.com",
                        url = "https://futureaisoft.com"
                ),
                description = "Click on 'Get Token' to get Authorization token.")

)
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)

public class OpenApi30Config {

}

