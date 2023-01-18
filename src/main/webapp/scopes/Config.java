package main.webapp.scopes;

import static org.springframework.web.util.TagUtils.*;

import org.springframework.context.annotation.*;

@Configuration
public class Config {
    @Bean
    @Scope(SCOPE_REQUEST)
    public HelloGeneratorRequest requestScopedBean() {
        return new HelloGeneratorRequest("request scope");
    }

    @Bean
    @Scope(SCOPE_SESSION)
    public HelloGeneratorSession sessionScopedBean() {
        return new HelloGeneratorSession("session scope");
    }

    @Bean
    @Scope(SCOPE_APPLICATION)
    public HelloGeneratorApp applicationScopedBean() {
        return new HelloGeneratorApp("app scope");
    }
}
