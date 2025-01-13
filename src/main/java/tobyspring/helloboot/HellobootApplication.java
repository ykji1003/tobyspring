package tobyspring.helloboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

// @SpringBootApplication
// @Configuration  : config정보, 구성정보를 가지고 있는 클래스라는걸 명시하는 어노테이션
// 애플리케이션 컨텍스트에 처음 등록된다.  BeanFactory Method를 가지는 것 이상으로
// 전체 애플리케이션을 구성하는데 필됴한 중요한 정보들을 많이 넣을 수 있기 때문이다.
@Configuration
@ComponentScan // @component 어노테이션이 등록된 빈들을 모두 등록해준다.
public class HellobootApplication {

    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }

    @Bean DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }


    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }



}
