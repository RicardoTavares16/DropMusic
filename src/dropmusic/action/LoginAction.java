package dropmusic.action;

public class LoginAction {

    private static final String SUCCESS_USER = "success user";
    private static final String SUCCESS_ADMIN = "success admin";

    public String execute() throws Exception{
        System.out.println("A executar LoginAction...");

        return SUCCESS_USER;
    }
}