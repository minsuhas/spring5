package spring;

import config.AppCtx;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberRegisterServiceTest {

    private ApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
    private MemberRegisterService memberRegSvc;
    private MemberDao memberDao;
    private Long id;

    @Test
    public void testRegist() {

        //given

        memberRegSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
        memberDao = ctx.getBean("memberDao", MemberDao.class);
        RegisterRequest req = new RegisterRequest();
        req.setEmail("karosis28@gmail.com");
        req.setPassword("1234");
        req.setName("kimminsu");

        //when

        if (memberDao.selectByEmail("karosis28@gmail.com") != null) {
            throw new DuplicateMemberException("dup email " + req.getEmail());
        }
        this.id = memberRegSvc.regist(req);


        //then

        assertThat(this.id).isEqualTo(memberDao.selectByEmail(req.getEmail()).getId());

    }
}