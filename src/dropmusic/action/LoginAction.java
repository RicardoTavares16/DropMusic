package dropmusic.action;

import com.opensymphony.xwork2.ActionSupport;
import dropmusic.auxfunc.Person;
import dropmusic.model.PersonBean;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;


public class LoginAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private transient Map<String, Object> session;

    private String username = null, password = null;

    private static final String SUCCESS_USER = "success user";
    private static final String SUCCESS_ADMIN = "success admin";

    @Override
    public String execute() throws Exception {
        System.out.println("Trying to Login");

        PersonBean person = this.getPersonBean();
        username = person.getUsername();
        password = person.getPassword();

        System.out.println(username + ", " + password);

        return SUCCESS_ADMIN;
    }

    public PersonBean getPersonBean() {
        if(!session.containsKey(PersonBean.SESSION_MAP_KEY)) {
            this.setPersonBean(new PersonBean());
        }

        return (PersonBean) session.get(PersonBean.SESSION_MAP_KEY);
    }

    public void setPersonBean(PersonBean personBean) {
        this.session.put(PersonBean.SESSION_MAP_KEY, personBean);
    }


    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

}
