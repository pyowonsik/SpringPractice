package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
// AppConfig 덕분에 구햔체에 의존하지 않고 인터페이스에만 의존  (실행 역할)
public class OrderServiceImpl implements OrderService{


    // MemoryMemberRepository , FixDiscountPolicy 구현체 사용
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;  // 인터페이스에만 의존하게 한다.
    //@Autowired
    // private final DiscountPolicy rateDiscountPolicy

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository,@MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);    // discount를 계산해서 새로운 order 리턴
    }



    public MemberRepository getMemberRepository() {
        return memberRepository;
    }


}
