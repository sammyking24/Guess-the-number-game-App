package sammycode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args){
        log.info("Guess The Number Game");

//       create context (container)
        ConfigurableApplicationContext context
               = new AnnotationConfigApplicationContext(AppConfig.class);

//        get number generator bean from context (container)
        NumberGenerator numberGenerator
                = context.getBean(NumberGenerator.class);

//        Call the method next() to get a random number
        int number = numberGenerator.next();

//        log generated number
        log.info("number = {}", number);

//        get get message generator bean from context (container)
        MassageGenerator massageGenerator =
                context.getBean(MassageGenerator.class);
        log.info("getMainMessage= {}", massageGenerator.getMainMessage());
        log.info("getResultMessage= {}", massageGenerator.getResultMessage());

//        close context (container)
        context.close();

    }
}
