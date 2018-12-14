package dropmusic.model;

import rmi.RmiInterface;

import javax.servlet.ServletException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class DropMusicBean implements Serializable {
    public static final String SESSION_MAP_KEY = "dropMusicBean";

    private RmiInterface rmiServer;
    private int id;
    private String name;

    // To search:
    private String albumName;
    private String artistName;

    //To show:
    private String toShow;

    // To Review:
    private String review;
    private int points;
    private String user;


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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setUser(String user) {
        this.user = user;
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

    public ArrayList<String> getGetAlbuns() throws RemoteException {
        return rmiServer.getAlbuns(this.id);
    }

    public Boolean getAddReview() throws RemoteException {
        return rmiServer.addReview(this.user, this.albumName, this.review + "*" + this.points, this.id);
    }


}
