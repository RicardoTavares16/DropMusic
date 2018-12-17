package dropmusic.action;

import com.opensymphony.xwork2.ActionSupport;
import dropmusic.model.DropboxBean;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class DropboxAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private transient Map<String, Object> session;

    @Override
    public String execute() throws Exception {
        System.out.println("Executing Dropbox Action");

        DropboxBean drop = this.getDropboxBean();

        // Redirect to login. (not functional)
        //Desktop.getDesktop().browse(URI.create(dropboxConnection.getDropboxAuthURL()));

        System.out.println(drop.getMusicList());

        return "success";
    }


    public DropboxBean getDropboxBean() throws Exception {
        if(!session.containsKey(DropboxBean.SESSION_MAP_KEY)) {
            this.setDropboxBean(new DropboxBean());
        }

        return (DropboxBean) session.get(DropboxBean.SESSION_MAP_KEY);
    }
    public void setDropboxBean(DropboxBean addBean) {
        this.session.put(DropboxBean.SESSION_MAP_KEY, addBean);
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
