package dropmusic.model;

import dropmusic.auxfunc.Music;
import dropmusic.auxfunc.Review;
import rmi.RmiInterface;

import javax.servlet.ServletException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class que contém os dados de um dado Album.
 */

public class Album {
    private String albumName;
    private List<Music> musicList = Collections.synchronizedList(new ArrayList<Music>());
    private List<Review> reviewList = Collections.synchronizedList(new ArrayList<Review>());
    private String details;
    public static final String SESSION_MAP_KEY = "albumBean";

    private RmiInterface rmiServer;

    public List<Album> getAlbums() throws Exception {
        try {
            System.out.println("Creating RMI Connection...");
            int id = (int) (Math.random() * 100);
            id = id * 2 + 1;
            rmiServer = (RmiInterface) Naming.lookup("XPTO");

            return rmiServer.getAlbuns(id);
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            throw new ServletException(e);
        }
    }

    public Album(String name) {
        this.albumName = name;
    }

    public Album(String name, String details) {
        this.albumName = name;
        this.details = details;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public void changeAlbumName(String name) {
        this.albumName = name;
    }

    public String getAlbumDetails() {
        return this.details;
    }

    public void addToMusicList(Music music) {
        this.musicList.add(music);
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public void setAlbumDetails(String details) {
        this.details = details;
    }

    public void setReview(Review review) {
        this.reviewList.add(review);
    }

    public List<Review> getAlbumReviews() {
        return this.reviewList;
    }

    @Override
    public String toString() {
        return this.albumName + "," + this.details;
    }
}
