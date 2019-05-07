package spring;

import org.junit.Test;

import java.time.LocalDateTime;

public class ChangePasswordServiceTest {

    private Member member;
    private MemberDao memberDao;

    @Test
    public void testChangePassword() {
        //given

        member = new Member("karosis28@gmail.com","1234","kimminsu", LocalDateTime.now());
        memberDao = new MemberDao();

        memberDao.insert(member);

        //when

        if (memberDao.selectByEmail("a@b.c") == null) {
            throw new MemberNotFoundException("멤버가 없습니다.");
        }
        else {}

        //then
    }

}