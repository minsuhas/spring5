package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.MemberPrinter;
import spring.VersionPrinter;

import java.time.format.DateTimeFormatter;


@Configuration
@ComponentScan(basePackages = {"spring"})
public class AppCtx {

    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
    }

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }
}
