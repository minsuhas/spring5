package spring;

import org.junit.Test;

public class MemberRegisterServiceTest {

    private MemberRegisterService memberRegSvc;
    private MemberDao memberDao;

    @Test
    public void testRegist() {

        //given

        memberDao = new MemberDao();
        memberRegSvc = new MemberRegisterService(memberDao);
        RegisterRequest req = new RegisterRequest();
        req.setEmail("karosis28@gmail.com");
        req.setPassword("1234");
        req.setName("kimminsu");

        memberRegSvc.regist(req);

        //when

        if (memberDao.selectByEmail("karosis28@gmail.com") != null) {
            throw new DuplicateMemberException("dup email " + req.getEmail());
        }

        //then

    }
}