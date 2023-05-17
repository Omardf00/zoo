package com.example.zoo.documentation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Zoo Api",
                version = "1.0",
                description = "Api designed to manage animals in the zoo",
                license = @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0"),
                contact = @Contact(url = "https://github.com/Omardf00", name = "Omar", email = "omar.dominguez.fuentes@atos.net")
        ),
        servers = {
                @Server(
                        description = "Localhost Server",
                        url = "http://localhost:8080/api/v1/animal"
                )
        }
)
public class DocumentationConfig {
}
