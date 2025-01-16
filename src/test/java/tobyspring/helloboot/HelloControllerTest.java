package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloControllerTest {
    @Test
    void hello() {
        // 메서드가 2개가 되어 countOf를 default 메서드롤 선언해 오류 수정
        HelloController helloController = new HelloController(name -> "Hello " + name);

        String rtn = helloController.hello("Test");
        Assertions.assertThat(rtn).isEqualTo("Hello Test");
    }

    @Test
    void failsHelloController() {
        HelloController helloController = new HelloController(name -> name);
        Assertions.assertThatThrownBy(() -> {
            helloController.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            helloController.hello("");
        }).isInstanceOf(IllegalArgumentException.class);

    }
}
