package sammycode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "sammycode")
public class AppConfig {

//    ====  Bean method ===
    @Bean
    public NumberGenerator numberGenerator(){
        return new NumberGeneratorImpl();
    }
    @Bean
    public Game game(){
        return new GameImpl();
    }
    @Bean
    public MassageGenerator massageGenerator(){
        return new MessageGeneratorImpl();

    }
}
