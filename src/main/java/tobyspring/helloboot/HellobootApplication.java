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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

// @SpringBootApplication
public class HellobootApplication {

    public static void main(String[] args) {
        System.out.println("Hello Containerless Standalone Application");
        // SpringApplication.run(HellobootApplication.class, args);

        // 스프링부트가 톰캣 서블릿컨테이너를 쉽게 사용할 수 있게 만들어준 클래스
        // Factory : 생성과정+ 설정을 마침을 예상할 수 있음
        // ServletWebServerFactory : 추상화
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();


        // 익명클래스 코드를 전체완성해준다(인텔리제이가)
        // functional interface
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            servletContext.addServlet("frountController", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    // 인증, 보안, 다국어, 공통 기능을 처리한다 (프론트 컨트롤러)
                    System.out.println(req.getRequestURL());
                    System.out.println(req.getMethod());
                    if(req.getRequestURL().toString().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
                        String name = req.getParameter("name");
                        resp.setStatus(HttpStatus.OK.value());
                        resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
                        resp.getWriter().println("Hello " + name);
                    }
                    else if(req.getRequestURL().toString().equals("/user")  && req.getMethod().equals("GET")) {
                        //
                    }
                    else {
                        resp.setStatus(HttpStatus.NOT_FOUND.value());
                    }
                }
            }).addMapping("/*");
        });  // 톰캣외 제티 등 서블릿 컨테이너를 지원하기 위함(추상화)
        webServer.start();


    }

}
