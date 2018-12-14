package dropmusic.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class DropboxAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private transient Map<String, Object> session;

    @Override
    public String execute() throws Exception {

        return ERROR;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
