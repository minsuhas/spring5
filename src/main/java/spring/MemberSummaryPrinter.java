package spring;

import java.time.format.DateTimeFormatter;

public class MemberSummaryPrinter extends MemberPrinter {

    public MemberSummaryPrinter(DateTimeFormatter dateTimeFormatter) {
        super(dateTimeFormatter);
    }

    @Override
    public void print(Member member) {
        System.out.printf("회원 정보: 이메일=%s, 이름=%s\n", member.getEmail(), member.getName());
    }
}
