package dropmusic.action;

import com.opensymphony.xwork2.ActionSupport;
import dropmusic.model.DropMusicBean;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class DropMusicAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private transient Map<String, Object> session;

    // To search:
    private String albumName;
    private String artistName;

    @Override
    public String execute() throws Exception {
        System.out.println("Executing DropMusic Action!");

        if(this.albumName != null && !albumName.equals("")) {
            DropMusicBean dropMusic = this.getDropMusicBean();

            dropMusic.setAlbumName(this.albumName);
            if(!dropMusic.getGetAlbumData().isEmpty()){
                return "success";
            }
        }

        if(this.artistName != null && !artistName.equals("")) {
            DropMusicBean dropMusic = this.getDropMusicBean();

            dropMusic.setArtistName(this.artistName);

            if(!dropMusic.getGetArtistData().isEmpty()) {
                return "success";
            }
        }

        if(!LoginAction.isPersonLogged(this.session)) return ERROR;
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

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
