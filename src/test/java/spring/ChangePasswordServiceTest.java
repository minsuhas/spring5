package spring;

import config.AppCtx;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setRemoveAssertJRelatedElementsFromStackTrace;

public class ChangePasswordServiceTest {

    private ApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
    private String oldPsw;
    private String newPsw;


    @Test
    public void testChangePassword() {
        //given

        Member member = new Member("karosis28@gmail.com","1234","kimminsu", LocalDateTime.now());
        MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
        ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);

        memberDao.insert(member);
        oldPsw = member.getPassword();
        newPsw = "4567";

        //when

        if (member != null) {
            changePwdSvc.changePassword(member.getEmail(), oldPsw, newPsw);
        }
        else
            throw new MemberNotFoundException("멤버가 없습니다.");

        //then

        assertThat(member).isNotNull();
        assertThat(member.getPassword()).isEqualTo(newPsw);
    }

}