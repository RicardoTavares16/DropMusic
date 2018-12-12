package dropmusic.model;

import rmi.RmiInterface;

import javax.servlet.ServletException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class AddBean implements Serializable {
    public static final String SESSION_MAP_KEY = "addBean";
    private static final long serialVersionUID = 1L;

    private String musicToAdd;
    private String albumToAdd;
    private String artistToAdd;
    private int id;
    private RmiInterface rmiServer;

    public AddBean() throws Exception{
        try {
            id = (int) (Math.random() * 100);
            id = id * 2 + 1;
            rmiServer = (RmiInterface) Naming.lookup("XPTO");
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            throw new ServletException(e);
        }
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

    public String getMusicToAdd() {
        return musicToAdd;
    }

    public String getAlbumToAdd() {
        return albumToAdd;
    }

    public String getArtistToAdd() {
        return artistToAdd;
    }

    // Calls to RMI Server:
    public boolean addMusic() throws RemoteException {
        return rmiServer.addMusic(musicToAdd, id);
    }

    public boolean addAlbum() throws RemoteException {
        return rmiServer.addAlbum(albumToAdd, id);
    }

    public boolean addArtist() throws RemoteException {
        return rmiServer.addArtist(artistToAdd, id);
    }

}
