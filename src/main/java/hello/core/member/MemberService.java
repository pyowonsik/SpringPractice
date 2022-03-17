package hello.core.member;

public interface MemberService {

    // Service 입장에서는 join , member를 찾음
    void join(Member member);
    Member findMember(Long memberId);
}
