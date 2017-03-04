package erp.config;

import erp.model.HelloWorld;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * Created by Dima on 04.03.2017.
 */
@Configuration
public class AppConfig {


    @Bean
    public HelloWorld helloWorld() {
        return new HelloWorld("HELLO DIMAN");
    }
}
