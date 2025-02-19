package tobyspring.helloboot;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import tobyspring.config.MySpringBootApplication;

// @SpringBootApplication
// @Configuration  : config정보, 구성정보를 가지고 있는 클래스라는걸 명시하는 어노테이션
// 애플리케이션 컨텍스트에 처음 등록된다.  BeanFactory Method를 가지는 것 이상으로
// 전체 애플리케이션을 구성하는데 필됴한 중요한 정보들을 많이 넣을 수 있기 때문이다.

@MySpringBootApplication
public class HellobootApplication {

    private final JdbcTemplate jdbcTemplate;

    public HellobootApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct  // implements InitializingBean 유사하다.
    void init() {
        jdbcTemplate.execute("create table if not exists member(name varchar(50) primary key, count int)");
    }

    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }
}
