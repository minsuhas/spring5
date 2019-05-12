package spring;

import org.junit.Test;

import java.time.LocalDateTime;

public class MemberRegisterServiceTest {

    private MemberRegisterService memberRegSvc;
    private RegisterRequest req;
    private Member member;
    private MemberDao memberDao;

    @Test
    public void testRegist_이미_등록된_이메일이_없을_때() {

        //given
        memberDao = new MemberDao();
        req = new RegisterRequest();
        memberRegSvc = new MemberRegisterService(memberDao);

        //when

        req.setEmail("karosis28@gmail.com");
        req.setPassword("1234");
        req.setName("kim");

        //then

        memberRegSvc.regist(req);

    }

    @Test
    public void testRegist_이미_등록된_이메일이_있을_때() {

        //given

        member = new Member("karosis28@gmail.com","1234","kim", LocalDateTime.now());
        memberDao = new MemberDao();
        req = new RegisterRequest();
        memberRegSvc = new MemberRegisterService(memberDao);

        //when

        memberDao.insert(member);

        req.setEmail("karosis28@gmail.com");
        req.setPassword("1234");
        req.setName("kim");

        //then

        memberRegSvc.regist(req);

    }

}