package dropmusic.action;

import com.opensymphony.xwork2.ActionSupport;
import dropmusic.model.DropMusicBean;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class DropMusicAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private transient Map<String, Object> session;

    @Override
    public String execute() throws Exception {
        DropMusicBean dropmusic = this.getDropMusicBean();
        return "success";
    }

    public DropMusicBean getDropMusicBean() throws Exception {
        if(!session.containsKey(DropMusicBean.SESSION_MAP_KEY)) {
            this.setDropMusicBean(new DropMusicBean());
        }

        return (DropMusicBean) session.get(DropMusicBean.SESSION_MAP_KEY);
    }

    public void setDropMusicBean(DropMusicBean dropMusicBean) {
        this.session.put(DropMusicBean.SESSION_MAP_KEY, dropMusicBean);
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}