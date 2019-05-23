package spring;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberRegisterServiceTest {

    private MemberRegisterService memberRegSvc;
    private RegisterRequest req;
    private MemberDao memberDao;
    private final String email = "karosis28@gmail.com";
    private final String password = "1234";
    private final String name = "kimminsu";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        memberDao = new MemberDao();
        req = new RegisterRequest();
        memberRegSvc = new MemberRegisterService(memberDao);
    }

    @Test
    public void testRegist_이미_등록된_Email이_없을_때() {

        //given

        req.setEmail(email);
        req.setPassword(password);
        req.setName(name);

        //when

        memberRegSvc.regist(req);
        Member registMember = memberDao.selectByEmail(email);

        //then

        assertThat(registMember.getId()).isNotNull();
        assertThat(registMember.getEmail()).isEqualTo(email);
        assertThat(registMember.getPassword()).isEqualTo(password);
        assertThat(registMember.getName()).isEqualTo(name);

    }

    @Test
    public void testRegist_이미_등록된_Email이_있을_때() {

        //given

        expectedException.expect(DuplicateMemberException.class);
        expectedException.expectMessage("dup email " + email);
        Member member = new Member(email, password, name, LocalDateTime.now());

        memberDao.insert(member);

        req.setEmail(email);
        req.setPassword(password);
        req.setName(name);

        //when

        memberRegSvc.regist(req);

        //then

    }

}