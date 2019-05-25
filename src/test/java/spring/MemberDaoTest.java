package spring;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class MemberDaoTest {

    private MemberDao memberDao;
    private final String password = "1234";
    private final String email = "karosis28@gmail.com";

    @Before
    public void setUp() {
        memberDao = new MemberDao();
    }

    @Test
    public void testSelectByEmail_Email을_가진_멤버가_없을_때() {

        //given


        //when

        Member member = memberDao.selectByEmail(email);

        //then

        assertThat(member).isNull();
    }

    @Test
    public void testSelectByEmail_Email을_가진_멤버가_있을_때() {
        //given

        Member member = new Member(email, password, "KIMMINSU", LocalDateTime.now());
        memberDao.insert(member);

        //when

        Member insertedMember = memberDao.selectByEmail(email);

        //then

        assertThat(insertedMember).isNotNull();
        assertThat(insertedMember.getEmail()).isEqualTo(email);
        assertThat(insertedMember.getRegisterDateTime()).isNotNull();

    }
}