package spring;

import config.AppCtx;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class MemberRegisterServiceTest {

    private ApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
    private MemberRegisterService memberRegSvc;
    private MemberDao memberDao;
    private Long id;

    @Test
    public void testRegist() {
        memberRegSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
        memberDao = ctx.getBean("memberDao", MemberDao.class);
        RegisterRequest req = new RegisterRequest();
        req.setEmail("karosis28@gmail.com");
        req.setPassword("1234");
        req.setName("kimminsu");

        this.id = memberRegSvc.regist(req);

        assertEquals(this.id, memberDao.selectByEmail(req.getEmail()).getId());
    }
}