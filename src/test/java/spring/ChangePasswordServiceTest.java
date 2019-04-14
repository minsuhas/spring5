package spring;

import config.AppCtx;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class ChangePasswordServiceTest {

    private ApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
    private String oldPsw;
    private String newPsw;


    @Test
    public void testChangePassword() {
        Member member = new Member("karosis28@gmail.com","1234","kimminsu", LocalDateTime.now());
        MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
        ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);

        memberDao.insert(member);
        oldPsw = member.getPassword();
        newPsw = "4567";

        changePwdSvc.changePassword(member.getEmail(), oldPsw, newPsw);

        assertEquals(newPsw, member.getPassword());
    }
}