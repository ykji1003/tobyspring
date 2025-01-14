package tobyspring.config.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;
import tobyspring.config.MyAutoConfiguration;

@MyAutoConfiguration
public class DispatcherServletConfig {
    @Bean
        // 스프링웹을 사용하기 위해 필요한 디스팩쳐 서블릿을 생성하는 빈
    DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }
}
