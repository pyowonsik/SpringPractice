package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){

        AppConfig appConfig = new AppConfig();

        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 : " +  memberService1);
        System.out.println("memberService2 : " + memberService2);
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);

    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){

        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);


        Assertions.assertThat(singletonService1).isSameAs(singletonService2);

    }

    // 애플리케이션 컨텍스트에 의해 등록된 빈은 기본적으로 싱글톤으로 관리된다.
    // 즉, 스프링에 여러 번 빈을 요청하더라도 매번 *동일한 객체* 를 돌려준다는 것이다.
    // 애플리케이션 컨텍스트가 싱글톤으로 빈을 관리하는 이유는 대규모 트래픽을 처리할 수 있도록 하기 위함이다.
    // 스프링 싱글톤은 자바 싱글톤의 단점들을 보완한다.

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")   // 스프링 컨테이너는 싱글톤 패턴을 포함한다.
    void springContainer(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService",MemberService.class);
        MemberService memberService2 = ac.getBean("memberService",MemberService.class);


        System.out.println("memberService1 : " + memberService1);
        System.out.println("memberService2 : " + memberService2);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }


}
