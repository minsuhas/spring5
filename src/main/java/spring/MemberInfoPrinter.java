package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("infoPrinter")
public class MemberInfoPrinter {

    private MemberDao memberDao;
    private MemberPrinter printer;

    @Autowired
    public MemberInfoPrinter(MemberDao memberDao, MemberPrinter printer) {
        this.memberDao = memberDao;
        this.printer = printer;
    }

    public void printMemberInfo(String email) {
        Member member = memberDao.selectByEmail(email);
        if (member == null) {
            System.out.println("데이터 없음\n");
            return;
        }
        printer.print(member);
        System.out.println();
    }
}
