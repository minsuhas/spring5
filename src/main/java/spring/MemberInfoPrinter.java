package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberInfoPrinter {

    private MemberDao memberDao;
    private MemberPrinter printer;

    @Autowired
    public void setMemberDao(MemberDao memberDao) {

        this.memberDao = memberDao;
    }

    @Autowired
    @Qualifier("printer") // Config 클래스에서 의존객체 설정
    public void setPrinter(MemberPrinter printer) {

        this.printer = printer;
    }

    public void  printMemberInfo(String email) {
        Member member = memberDao.selectByEmail(email);
        if (member == null) {
            System.out.println("데이터 없음\n");
            return;
        }
        printer.print(member);
        System.out.println();
    }
}
