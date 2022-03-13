package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// Impl의 구현 객체 생성 , 생성자를 통해서 주입 , Impl이 실행에만 집중할수 있게 함 (연결 역할)
// 사요영역인 Impl을 변경하지 않아도 됨.
// appConfig.xml 과 비교
@Configuration
public class AppConfig {

    // 구현체를 사용하지 않기 위해 인터페이스를 사용해서 주입
    @Bean
     public MemberService memberService(){
         return new MemberServiceImpl(MemoryMemberRepository());
     }

     @Bean
     public MemberRepository MemoryMemberRepository(){
         return new MemoryMemberRepository();
     }

     @Bean
     public OrderService orderService(){
         return new OrderServiceImpl(MemoryMemberRepository(),discountPolicy());
     }

     @Bean
     public DiscountPolicy discountPolicy(){
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
     }

}
