package dropmusic.action;

import com.opensymphony.xwork2.ActionSupport;
import dropmusic.model.DropMusicBean;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;


public class ReviewAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private transient Map<String, Object> session;

    private String albumName;
    private String review;
    private int points;
    private String user;

    @Override
    public String execute() throws Exception {
        if(this.albumName != null && !this.albumName.equals("")) {
            DropMusicBean dropMusic = this.getDropMusicBean();
            dropMusic.setAlbumName(this.albumName);

            return "success";
        }
        user = session.get("username").toString();


        // @TODO: TRATAMENTO DA STRING

        if(this.review != null && !review.equals("")) {
            DropMusicBean dropMusic = this.getDropMusicBean();

            dropMusic.setUser(this.user);
            dropMusic.setReview(this.review);
            dropMusic.setPoints(this.points);
            if(dropMusic.getAddReview()){

                System.out.println("--> Review Added");
                return "success";
            } else {
                System.out.println("--> FAIL ADDING REVIEW");

                return ERROR;
            }
        }
        return ERROR;
    }

    public void setAlbumName(String albumName) {
        System.out.println("Set do nome");
        this.albumName = albumName;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setPoints(int points) {
        this.points = points;
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

