package hello.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean("beanA", BeanA.class);
        Assertions.assertThat(beanA).isNotNull();


        BeanB beanB = ac.getBean("beanB", BeanB.class);
        org.junit.jupiter.api.Assertions.assertThrows(
                NoSuchBeanDefinitionException.class,
                () -> ac.getBean("beanB",BeanB.class));

    }

    // includeFilters 에 MyIncludeComponent 애노테이션을 추가해서 BeanA가 스프링 빈에 등록
    // excludeFilters 에 MyExcludeComponent 애노테이션을 추가해서 BeanB에 스프링 빈에 등록되지 않느다.


    // Configuration로 스프링 설정 정보를 인식
    @Configuration
    @ComponentScan( includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
                    excludeFilters = {
                        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
            ,@ComponentScan.Filter(type  =FilterType.ASSIGNABLE_TYPE,classes = BeanA.class)} // include를  exclude 한다.


    )
    static class ComponentFilterAppConfig{


    }
}
