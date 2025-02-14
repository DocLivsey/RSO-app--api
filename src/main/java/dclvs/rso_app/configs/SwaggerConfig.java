package dclvs.rso_app.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@RequiredArgsConstructor
@PropertySource("/application.properties")
public class SwaggerConfig {

    private final Environment environment;

    public OpenAPI swaggerDefinition() {
        return new OpenAPI()
                .info(new Info()
                        .title(environment.getProperty("spring.application.name"))
                        .description(environment.getProperty("spring.application.description"))
                        .version(environment.getProperty("spring.application.version"))
                );
    }

}
