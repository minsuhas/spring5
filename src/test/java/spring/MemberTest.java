package spring;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberTest {

    private Member member;
    private final String oldPassword = "1234";
    private final String newPassword = "5678";
    private final String diffPassword = "0987";

    @Before
    public void setUp() {
        member = new Member("karosis28@gmail.com", oldPassword, "kimminsu", LocalDateTime.now());
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testChangePassword_입력받은_Password가_기존의_Password와_같을_경우() {

        //given


        //when

        member.changePassword(oldPassword, newPassword);

        //then

        assertThat(member.getPassword()).isEqualTo(newPassword);

    }

    @Test
    public void testChangePassword_입력받은_Password가_기존의_Password와_다른_경우() {

        //given

        expectedException.expect(WrongIdPasswordException.class);

        //when

        member.changePassword(diffPassword, newPassword);

        //then

    }
}