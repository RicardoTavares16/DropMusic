package dropmusic.auxfunc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class que contém os dados de dado Artista.
 */

public class Artist implements Serializable {
    List<Album> albumList = Collections.synchronizedList(new ArrayList<Album>());
    private String name;
    private String details;

    public Artist(String name) {
        this.name = name;
    }

    public Artist(String name, String details){
        this.name = name;
        this.details = details;
    }

    public String getArtistName(){
        return this.name;
    }

    public String getArtistDetails() {
        return this.details;
    }

    public void setArtistDetails(String details) {
        this.details = details;
    }

    public void addToArtistList(Album album) {
        this.albumList.add(album);
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public void editAlbumList(int x, Album album) {
        albumList.set(x, album);
    }

    @Override
    public String toString(){
        return this.name + "," + this.details;
    }
}
