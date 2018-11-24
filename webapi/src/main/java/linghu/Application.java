package linghu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import java.util.Arrays;

@SpringBootApplication(scanBasePackages = "linghu")
//@EnableAutoConfiguration(exclude = {
//        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
//})
public class Application {
    @Autowired
    private ApplicationContext appContext;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init() {
        return (args) -> {
            String[] beans = appContext.getBeanDefinitionNames();
            Arrays.sort(beans);
            for (String bean : beans)
            {

                if(appContext.getBean(bean).getClass().toString().contains("filter")){
                    System.out.println(bean + " of Type :: " + appContext.getBean(bean).getClass());
                }
            }
        };
    }
}