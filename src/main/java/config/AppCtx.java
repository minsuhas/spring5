package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.*;


@Configuration
public class AppCtx {

    @Bean
    public MemberDao memberDao() {

        return new MemberDao();
    }

    @Bean
    public MemberRegisterService memberRegSvc() {

        return new MemberRegisterService(memberDao());
    }

    @Bean
    public ChangePasswordService changePwdSvc() {
        ChangePasswordService pwdSvc = new ChangePasswordService();
        //pwdSvc.setMemberDao(memberDao());
        //
        // ChangePasswordService 클래스 멤버 memeberDao에 @Autowired 부여 함으로써
        // 의존 자동주입, setMemberDao 메소드로 주입할 필요없음
        return pwdSvc;
    }

//    @Bean
//    public MemberPrinter memeberPrinter() {
//
//        return new MemberPrinter();
//    }

    @Bean
    @Qualifier("printer")
    public MemberPrinter memeberPrinter1() {

        return new MemberPrinter();
    }

    @Bean
    public MemberPrinter memeberPrinter2() {

        return new MemberPrinter();
    }

    // 같은 타입의 빈 객체가 두 개인 경우 @Qualifier 어노테이션을 사용하여 의존 객체 선택

    @Bean
    public MemberListPrinter listPrinter() {

        return new MemberListPrinter();
    }

    @Bean
    public MemberInfoPrinter infoPrinter() {
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
        //infoPrinter.setMemberDao(memberDao());
        //infoPrinter.setPrinter(memeberPrinter());
        //
        // MemberInfoPrinter 클래스 setMemberDao, setPrinter 메소드에 @Autowired 부여

        return infoPrinter;
    }

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }
}
