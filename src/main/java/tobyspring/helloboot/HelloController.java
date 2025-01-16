package tobyspring.helloboot;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

// RestController가 리턴타입을 보고 return Content-Type을 자동으로 결정한다.
@RestController
public class HelloController {

    // 컨테이너 등록 빈 오브젝트 중 헬로서비스 인터페이스로 구현한 게 단일의존후보일 경우 의존대상이라고 생각하고 지정함.
    // 오토와이어링
    private final HelloService helloService;



    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }
    @GetMapping("/hello")
    public String hello(String name) {
        // @RestController 어노테이션 사용 시 특별한 행동이 없을 경우 @ResponseBody가 기본설정으로 쓰인다.
        // dispatcher servlet은 view(화면)을 찾으려고 하기 때문에 이대로는 오류가 발생한다.
        if(name == null || name.trim().length() == 0) throw new IllegalArgumentException();
        return helloService.sayHello(name);
    }

    @GetMapping("/count")
    public String count(String name) {
        return name + ": " + helloService.countOf(name);
    }


}