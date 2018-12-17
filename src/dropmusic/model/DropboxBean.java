package dropmusic.model;

import dropmusic.rest.DropboxConnection;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que faz a conexão com a Dropbox
 * A conexão é realizada e são devolvidas as músicas presentes na dropbox do projeto
 */
public class DropboxBean implements Serializable {
    public static final String SESSION_MAP_KEY = "dropboxBean";
    private static final long serialVersionUID = 1L;

    private String musicToPlay;

    /**
     * Acede à dropbox do projeto.
     *
     * @return lista de músicas na dropbox do projeto
     */
    public ArrayList<String> getMusicList() {
        DropboxConnection dropboxConnection = new DropboxConnection();
        return dropboxConnection.getMusic();
    }

    // set da música para tocar no browser.
    public void setMusicToPlay(String musicToPlay) {
        this.musicToPlay = musicToPlay;
    }

}
