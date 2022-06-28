package project.code03.Exception;

public class Caller1 {
    Caller2 caller2 = new Caller2();

    public void call2RTException() {
        System.out.println("Caller1.call2RTException开始");
        caller2.call3RTException();
        System.out.println("Caller1.call2RTException结束");
    }

    public void call2Exception() throws ClassNotFoundException {
        System.out.println("Caller1.call2Exception开始");
        try {
            caller2.call3Exception();
        } catch (ClassNotFoundException ex) {
            System.out.println("got exception in Caller1: "+ex.getMessage());
        }
        System.out.println("Caller1.call2Exception结束");
    }
}
