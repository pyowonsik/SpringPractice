package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// Impl의 구현 객체 생성 , 생성자를 통해서 주입 , Impl이 실행에만 집중할수 있게 함 (연결 역할)
// 사요영역인 Impl을 변경하지 않아도 됨.
// appConfig.xml 과 비교
@Configuration
// 애플리케이션 컨택스트는 @Configuration이 붙은 클래스들을 설정 정보로 등록, @Bean이 붙은 메소드의 이름으로 빈 목록 생성
// @Configuration 이 없어지면 싱글톤 패턴이 깨지게 된다.
// ApplicationContext 와 연결 한다.
public class AppConfig {


    // 인터페이스만 사용하기 위해 구현체를 리턴 받는다.
    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
        // MemberServiceImpl 의 매개변수는 interface이기때문에  memberRepository의 리턴 값을 구현체로 하는
        // 의존성 주입을 사용했다.
    }

    @Bean
    public MemberRepository memberRepository(){
        System.out.println("call AppConfig.MemoryMemberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        System.out.println("call AppConfig.discountPolicy");
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
