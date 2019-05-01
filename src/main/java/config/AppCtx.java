package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.*;

import java.time.format.DateTimeFormatter;


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
        ChangePasswordService pwdSvc = new ChangePasswordService(memberDao());
        //pwdSvc.setMemberDao(memberDao());
        //
        // ChangePasswordService 클래스 멤버 memeberDao에 @Autowired 부여 함으로써
        // 의존 자동주입, setMemberDao 메소드로 주입할 필요없음
        return pwdSvc;
    }

    @Bean
    public MemberPrinter memberPrinter() {

        return new MemberPrinter(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
    }

    @Bean
    public MemberSummaryPrinter memberSummaryPrinter() {

        return new MemberSummaryPrinter(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
    }

    @Bean
    public MemberListPrinter listPrinter() {

        return new MemberListPrinter(memberDao(), memberPrinter());
    }

    @Bean
    public MemberInfoPrinter infoPrinter() {
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter(memberDao(), memberSummaryPrinter());
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
