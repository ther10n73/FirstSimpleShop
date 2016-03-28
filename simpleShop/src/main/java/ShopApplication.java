import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Олег on 07.03.2016.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan("/controller/")
public class ShopApplication {

    public static void main (String[] args){
        SpringApplication.run(ShopApplication.class, args);
    }
}
