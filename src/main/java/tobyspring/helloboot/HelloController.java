package tobyspring.helloboot;

import java.util.Objects;

// RestController가 리턴타입을 보고 return Content-Type을 자동으로 결정한다.
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }


    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }


}