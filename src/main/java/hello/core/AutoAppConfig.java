package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(

        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)
)
// ComponentScan 을 사용하면 @Bean을 등록하지 않는다. 구현체에 @Component 가 붙게되면 스프링 빈으로 자동등록이 되기 때문
// ComponentScan 을 사용하게 되면 의존관계 주입을 구현체에 @Autowired로 자동으로 주입 시켜준다
// @Component , @Autowired는 구현체에서 확인해야 한다.
// @Controller,@Service,@Repository,@Configuration 은 @Component를 포함하기 때문에 따로 적지 않아도 됨.
// @Controller = 스프링 MVC 컨트롤러로 인식
// @Repository = 스프링 데이터 접근 계층 ,
// @Configuration = 스프링 설정 정보 인식 , 스프링빈이 싱글톤을 유지하도록 한다.
// @Service = 비즈니스 계층

// AutoAppConfig 처럼 @ComponentScan을 사용하고 구현체에 @Component를 이용하는것이 자동 등록
// AppCofig 처럼 @Bean을 사용해 빈을 등록하는 것이 수동 등록

public class AutoAppConfig{



}
