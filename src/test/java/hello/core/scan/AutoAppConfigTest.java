package hello.core.scan;

import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan(){


        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfigTest.class);

        // @ComponentScan을 등록한 클래스는 메소드에 @Bean을 등록하지 않아도 자동으로 등롣이 된다.
        // ---> getBean 사용 가능 , 구현을 사용보다는 인터페이스를 사용해야해서 MemberService를 사용
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);



    }
}
