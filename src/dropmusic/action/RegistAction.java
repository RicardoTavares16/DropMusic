package dropmusic.action;

import com.opensymphony.xwork2.ActionSupport;
import dropmusic.model.PersonBean;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class RegistAction extends ActionSupport implements SessionAware {

    private transient Map<String, Object> session;

    @Override
    public String execute() throws Exception {


        return "";
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
