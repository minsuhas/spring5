package spring;


public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException(String mssage) {
        System.out.println(mssage);
    }
}
