package dropmusic.model;

import dropmusic.auxfunc.Album;
import rmi.RmiInterface;

import javax.servlet.ServletException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class DropMusicBean implements Serializable {
    public static final String SESSION_MAP_KEY = "dropMusicBean";

    private RmiInterface rmiServer;
    private int id;
    private String name;
    private String everyAlbum = "Meteora, The Wall";

    // To search:
    private String albumName;
    private String artistName;

    //To show:
    private String toShow;

    private List<Album> album;


    public DropMusicBean() throws Exception {
        try {
            System.out.println("Creating RMI Connection...");
            id = (int) (Math.random() * 100);
            id = id * 2 + 1;
            rmiServer = (RmiInterface) Naming.lookup("XPTO");
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            throw new ServletException(e);
        }
    }

    public String getEveryAlbum() throws RemoteException {
        return everyAlbum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistName() {
        return this.artistName;
    }

    public void setToShow(String toShow) {
        this.toShow = toShow;
    }

    public String getToShow() {
        return this.toShow;
    }

    // Calls to RMI Server:
    public String getGetAlbumData() throws RemoteException {
        System.out.println("Getting album data...");
        this.toShow = rmiServer.getAlbumData(this.albumName, this.id);

        this.albumName = null;

        return this.toShow;
    }

    public String getGetArtistData() throws RemoteException {
        System.out.println("Getting artist data...");
        this.toShow = rmiServer.getArtistData(this.artistName, this.id);

        this.artistName = null;

        return this.toShow;
    }

    // @TODO: perceber o porquê do RMI funcionar, mas aqui não consegue passar desta parte.
    public ArrayList<String> getGetAlbuns() throws RemoteException {
        return rmiServer.getAlbuns(this.id);
    }


}
