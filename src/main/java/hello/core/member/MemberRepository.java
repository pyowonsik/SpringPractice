package hello.core.member;

public interface MemberRepository {

    // Repository 입장에서는 save , id를 찾음
    void save(Member member);
    Member findById(Long memberId);
}
