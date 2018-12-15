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

    // To edit:
    private String newName;
    private String newDetails;

    @Override
    public String execute() throws Exception {
        DropMusicBean dropMusic = this.getDropMusicBean();

        dropMusic.setUser(session.get("username").toString());

        System.out.println("Executing DropMusic Action!");

        if(this.newName != null && !this.newName.equals("")){
            System.out.println(this.newName);
            dropMusic.setNewName(this.newName);
            if(dropMusic.getEditAlbumName()) {
                return "success";
            } else {
                return ERROR;
            }
        }

        if(this.newDetails != null && !this.newDetails.equals("")) {
            System.out.println(this.newDetails);
            dropMusic.setNewDetails(this.newDetails);
            if(dropMusic.getEditAlbumDetails()) {
                return "success";
            } else {
                return ERROR;
            }
        }

        if(this.albumName != null && !albumName.equals("")) {
            dropMusic.setAlbumName(this.albumName);

            if(!dropMusic.getGetAlbumData().isEmpty()){
                return "success";
            }
        }

        if(this.artistName != null && !artistName.equals("")) {
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

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public void setNewDetails(String newDetails) {
        this.newDetails = newDetails;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
