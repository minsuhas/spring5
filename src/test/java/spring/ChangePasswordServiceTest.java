package spring;

import org.junit.Test;

import java.time.LocalDateTime;

public class ChangePasswordServiceTest {

    private ChangePasswordService changePasswordSvc;
    private Member member;
    private MemberDao memberDao;

    @Test
    public void testChangePassword_기존에_등록된_멤버가_없을_때() {
        //given

        member = new Member("karosis28@gmail.com","1234","kimminsu", LocalDateTime.now());
        memberDao = new MemberDao();
        changePasswordSvc = new ChangePasswordService(memberDao);

        //when

        //then

        changePasswordSvc.changePassword("karosis28@gmail.com","1234","5678");

    }

    @Test
    public void testChangePassword_기존에_등록된_멤버가_있을_때() {
        //given

        member = new Member("karosis28@gmail.com","1234","kimminsu", LocalDateTime.now());
        memberDao = new MemberDao();
        changePasswordSvc = new ChangePasswordService(memberDao);

        //when

        memberDao.insert(member);

        //then

        changePasswordSvc.changePassword("karosis28@gmail.com","1234","5678");

    }

}