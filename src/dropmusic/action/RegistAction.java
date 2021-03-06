package dropmusic.action;

import com.opensymphony.xwork2.ActionSupport;
import dropmusic.model.PersonBean;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class RegistAction extends ActionSupport implements SessionAware {

    private static final long serialVersionUID = 4L;
    private transient Map<String, Object> session;

    private String username = null, password = null;

    private static final String SUCCESS = "success";

    @Override
    public String execute() throws Exception {
        if(this.username != null && !username.equals("")) {
            PersonBean person = this.getPersonBean();
            person.setUsername(this.username);
            person.setPassword(this.password);
            //System.out.println(username + ", " + password);

            if(this.getPersonBean().getReg()) {

                session.put("loggedin", true);
                session.put("username", username);
                session.put("editor", false);
                return SUCCESS;
            }
        }
        return ERROR;
    }

    public PersonBean getPersonBean() throws Exception {
        if(!session.containsKey(PersonBean.SESSION_MAP_KEY)) {
            this.setPersonBean(new PersonBean());
        }

        return (PersonBean) session.get(PersonBean.SESSION_MAP_KEY);
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setPersonBean(PersonBean personBean) {
        this.session.put(PersonBean.SESSION_MAP_KEY, personBean);
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
