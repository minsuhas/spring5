package spring;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class ChangePasswordServiceTest {

    private MemberDao memberDao;
    private ChangePasswordService changePasswordSvc;
    private final String oldPassword = "1234";
    private final String newPassword = "5678";
    private final String email = "karosis28@gmail.com";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        memberDao = new MemberDao();
        changePasswordSvc = new ChangePasswordService(memberDao);
    }

    @Test
    public void testChangePassword_기존에_등록된_멤버가_없을_때() {
        //given

        expectedException.expect(MemberNotFoundException.class);
        expectedException.expectMessage("멤버가 없습니다.");

        //when

        changePasswordSvc.changePassword(email,oldPassword,newPassword);

        //then


    }

    @Test
    public void testChangePassword_기존에_등록된_멤버가_있을_때() {
        //given

        Member member = new Member(email, oldPassword,"kimminsu", LocalDateTime.now());
        memberDao.insert(member);

        //when

        changePasswordSvc.changePassword(email, oldPassword, newPassword);
        Member pwdChangedMember = memberDao.selectByEmail(email);

        //then

        assertThat(pwdChangedMember.getEmail()).isEqualTo(email);
        assertThat(pwdChangedMember.getPassword()).isEqualTo(newPassword);

    }

}