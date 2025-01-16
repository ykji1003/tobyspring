package tobyspring.helloboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Service
@Primary // helloService의 후보 중 이 아이를 먼저 바라봐라.
public class HelloDecorator implements HelloService {

    private final HelloService helloService;

    public HelloDecorator(HelloService helloService) {
        this.helloService = helloService;
    }


    @Override
    public String sayHello(String name) {
        // return "*" + helloService.sayHello(name) + "*";
        return "*" + helloService.sayHello(name) + "*";
    }

    @Override
    public int countOf(String name) {
        return helloService.countOf(name);
    }
}
