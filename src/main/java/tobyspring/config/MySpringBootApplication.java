package tobyspring.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)  // class, interface, enum에 지정가능
@Configuration
@ComponentScan // 동일 패키지 선상에 있는 컴포넌트들에 대해서 스캐닝을한다.
@EnableMyAutoConfiguration
public @interface MySpringBootApplication {

}
