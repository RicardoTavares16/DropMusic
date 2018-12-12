package dropmusic.action;

import com.opensymphony.xwork2.ActionSupport;
import dropmusic.model.AddBean;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class AddAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private transient Map<String, Object> session;

    private String musicToAdd;
    private String albumToAdd;
    private String artistToAdd;


    @Override
    public String execute() throws Exception {
        System.out.println(this.musicToAdd);
        System.out.println(this.albumToAdd);
        System.out.println(this.artistToAdd);
        AddBean add = this.getAddBean();
        if(this.musicToAdd != null && !musicToAdd.equals("")) {
            add.setMusicToAdd(this.musicToAdd);
            if(this.getAddBean().addMusic()) {
                this.musicToAdd = null;
                return "success";
            }
        }
        if(this.albumToAdd != null && !albumToAdd.equals("")) {
            add.setAlbumToAdd(this.albumToAdd);
            if(this.getAddBean().addAlbum()) {
                this.albumToAdd = null;
                return "success";
            }
        }
        if(this.artistToAdd != null && !artistToAdd.equals("")) {
            add.setArtistToAdd(this.artistToAdd);
            if(this.getAddBean().addArtist()) {
                this.artistToAdd = null;
                return "success";
            }
        }
        return ERROR;
    }

    public AddBean getAddBean() throws Exception {
        if(!session.containsKey(AddBean.SESSION_MAP_KEY)) {
            this.setAddBean(new AddBean());
        }

        return (AddBean) session.get(AddBean.SESSION_MAP_KEY);
    }
    public void setAddBean(AddBean addBean) {
        this.session.put(AddBean.SESSION_MAP_KEY, addBean);
    }

    public void setMusicToAdd(String musicToAdd) {
        this.musicToAdd = musicToAdd;
    }

    public void setAlbumToAdd(String albumToAdd) {
        this.albumToAdd = albumToAdd;
    }

    public void setArtistToAdd(String artistToAdd) {
        this.artistToAdd = artistToAdd;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
