package tobyspring.helloboot;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public interface HelloService {
    String sayHello(String name);

    // 익명클래스를 이용한 람다식을 꼼수를 통한 사용가능하게끔 변경처리
    default int countOf(String name) {
        return 0;
    };
}
