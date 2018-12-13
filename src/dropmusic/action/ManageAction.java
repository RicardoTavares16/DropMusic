package dropmusic.action;

import com.opensymphony.xwork2.ActionSupport;
import dropmusic.model.PersonBean;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class ManageAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private transient Map<String, Object> session;

    private String user1, user2;

    @Override
    public String execute() throws Exception {

        user1 = session.get("username").toString();
        System.out.println(user2);

        System.out.println(session.get(PersonBean.SESSION_MAP_KEY));

        if(this.user1 != null && !user1.equals("") && this.user2 != null && !user2.equals("")){
            PersonBean person = this.getPersonBean();

            person.setUser1(this.user1);
            person.setUser2(this.user2);

            if(this.getPersonBean().getMakeEditor()) {
                return "success";
            }
        }


        return ERROR;
    }

    public PersonBean getPersonBean() throws Exception {
        if(!session.containsKey(PersonBean.SESSION_MAP_KEY)) {
            return null;
        }

        return (PersonBean) session.get(PersonBean.SESSION_MAP_KEY);
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
