package com.xianglesong;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
public class StartApp {
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
  public static void main(String[] args) {
//    ConfigurableApplicationContext context = new SpringApplicationBuilder(StartApp.class).run(args);
////    context.addApplicationListener(new ApplicationPidFileWriter());

    ApplicationContext applicationContext = SpringApplication.run(StartApp.class, args);
    String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();


  }

}
