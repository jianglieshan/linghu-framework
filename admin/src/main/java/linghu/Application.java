package linghu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Arrays;

@SpringBootApplication(scanBasePackages = "linghu")
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
public class Application {
    @Autowired
    private ApplicationContext appContext;

    @Bean
    CommandLineRunner init() {
        return (args) -> {
            String[] beans = appContext.getBeanDefinitionNames();
            Arrays.sort(beans);
            for (String bean : beans)
            {
                System.out.println(bean + " of Type :: " + appContext.getBean(bean).getClass());
            }
        };
    }

    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager, LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
        System.out.println(">>>>>>>>>>" + entityManagerFactoryBean.getClass().getName()+">>>>>"+entityManagerFactoryBean.getJpaVendorAdapter().toString()
                +">>>>>"+entityManagerFactoryBean.getDataSource().toString()
        +">>>>>>"+entityManagerFactoryBean.getDataSource().getClass().getName());


        return new Object();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}