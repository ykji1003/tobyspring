package tobyspring.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Enable로 시작하는 anotation의 거의 대부분의 활용 용도는 import anotation을 다시 넣어
 * 어떤 기능을 가진 configuration class나 import selector 같은 것들을 가져오게 하는게 목적이다.
 * */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MyConfigurationPropertiesImportSelector.class) // import해서 element로 얻어오게한다.
public @interface EnableMyConfigurationProperties {
    Class<?> value();
}
