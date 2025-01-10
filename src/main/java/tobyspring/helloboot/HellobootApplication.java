package tobyspring.helloboot;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.IOException;

// @SpringBootApplication
public class HellobootApplication {

    public static void main(String[] args) {

        // 스프링 컨테이너
        GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
        // 관례와몇가지 룰을 통해 알아서 다 해주는 걸 지향한다.
        applicationContext.registerBean(HelloController.class);   // 빈등록
        applicationContext.registerBean(SimplHelloService.class); // 빈등록
        applicationContext.refresh();                             // 빈 오브젝트 생성


        System.out.println("Hello Containerless Standalone Application");
        // SpringApplication.run(HellobootApplication.class, args);

        // 스프링부트가 톰캣 서블릿컨테이너를 쉽게 사용할 수 있게 만들어준 클래스
        // Factory : 생성과정+ 설정을 마침을 예상할 수 있음
        // 스프링 컨테이너는 빈을 재사용할 수 있는 기능을 제공한다.
        // ServletWebServerFactory : 추상화
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();


        // 익명클래스 코드를 전체완성해준다(인텔리제이가)
        // functional interface
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            servletContext.addServlet("dispatcherServlet",
                    new DispatcherServlet(applicationContext)
                    ).addMapping("/*");
        });  // 톰캣외 제티 등 서블릿 컨테이너를 지원하기 위함(추상화)
        webServer.start();


    }

}
