package hello.core.member;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// 회원 서비스
@RequiredArgsConstructor
public class MemberServiceImpl implements  MemberService{



    // AppConfig 때문에 구현체(MemoryMemberRepository)에 의존하지 않고 인터페이스에(MemberRepository)만 의존 (실행 역할)
    private final MemberRepository memberRepository;


    @Override
    public void join(Member member) {

        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);

    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
