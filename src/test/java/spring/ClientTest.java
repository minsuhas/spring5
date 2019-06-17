package spring;

import config.AppCtxChapter6;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ClientTest {

    private ApplicationContext ctx;
    private Client client1;
    private Client client2;

    @Test
    public void testGetBean_prototype_범위의_빈객체가_getBean으로_호출시_다른_객체가_생성되는지() {

        //given

        ctx = new AnnotationConfigApplicationContext(AppCtxChapter6.class);

        //when

        client1 = ctx.getBean(Client.class);
        client2 = ctx.getBean(Client.class);

        //then

        assertThat(client1).isNotEqualTo(client2);

    }

}