package dropmusic.model;

import dropmusic.rest.DropboxConnection;

import java.io.Serializable;
import java.util.ArrayList;

public class DropboxBean implements Serializable {
    public static final String SESSION_MAP_KEY = "dropboxBean";
    private static final long serialVersionUID = 1L;

    private String musicToPlay;

    public ArrayList<String> getMusicList() {
        DropboxConnection dropboxConnection = new DropboxConnection();
        return dropboxConnection.getMusic();
    }

    public void setMusicToPlay(String musicToPlay) {
        this.musicToPlay = musicToPlay;
    }

}
