package aspect;

import chapter7.Calculator;
import chapter7.RecCalculator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import static org.assertj.core.api.Assertions.assertThat;


public class ExeTimeAspectTest {

    private Calculator cal;
    private AspectJProxyFactory factory;

    @Before
    public void setUp() {
        cal = new RecCalculator();
        factory = new AspectJProxyFactory(cal);
    }


    @Test
    public void tsetMeasure_프록시_객체수행시간_측정_테스트() {

        //given

        ExeTimeAspect aspect = new ExeTimeAspect();
        factory.addAspect(aspect);
        Calculator exeTimeProxy = factory.getProxy();

        //when

        exeTimeProxy.factorial(5);


        //then

        assertThat(exeTimeProxy).isNotNull();
        assertThat(exeTimeProxy.getClass()).isNotEqualTo(cal);
    }
}